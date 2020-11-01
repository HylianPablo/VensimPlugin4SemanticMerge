package es.uva.inf.grammar.parser.visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.misc.Interval;

import es.uva.inf.grammar.parser.ModelBaseVisitor;
import es.uva.inf.grammar.parser.ModelParser;

public class EvalVisitor extends ModelBaseVisitor<String> {

    private String input="";
    private String output="";

    public void setInput(String text){
        input=text;
    }

    public void setOutput(String text){
        output=text;
    }


    @Override
    public String visitFile(ModelParser.FileContext ctx){
        try{
            int lastLine = countFileLines(input);
            int lastLineLength = lastLineLength(input, lastLine) + 2;
            
            int equationsEndLine=0;
            int equationsFooter=9;

            String text = new String(Files.readAllBytes(Paths.get(input)),StandardCharsets.UTF_8);

            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] graphs = text.split(viewsDelimiter,2);

            ArrayList<Boolean> newLinesInEquation = checkForNewLines(input);
            
            equationsEndLine = graphs[0].split("\n").length;

            List<ModelParser.SymbolWithDocContext> equations = ctx.model().symbolWithDoc();
            
            equationsFooter+=166; //Control delimiter characters APROX, MUST BE CHANGED

            equationsFooter=graphs[0].length()-3;

            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);
            
            fw.write("---\n");
            fw.write("type: file\n");
            fw.write("name: "+input+"\n");
            fw.write("locationSpan : {start: [1, 0], end: [" + (lastLine+1) + ", "+2+"]}\n");
            fw.write("footerSpan : [0,-1]\n");
            fw.write("parsingErrorsDetected : false\n");
            fw.write("children:\n");
            fw.write("  - type : equations\n");
            fw.write("    name: {UTF-8}\n");
            fw.write("    locationSpan : {start: [1, 0], end: [" + (equationsEndLine-1) + ", 2]}\n");
            fw.write("    headerSpan : [0, 8]\n"); //Assuming file will always start with {UTF-8}, WILL BE CHANGED
            fw.write("    footerSpan : [" + (equationsFooter-1) + ", " + equationsFooter + "]\n");
            fw.write("    children :\n");
            int locationSpanStartEq = 2; //Assuming there is always an encoding line {UTF-8}
            int initCharEq = 9; //Assuming there is always an encoding line {UTF-8}
            BufferedReader reader = new BufferedReader(new FileReader(input));
            reader.readLine();//UTF-8
            for(int i =0; i<equations.size();i++){
                fw.write("    - type : equation\n");
                String equationText;  //Mostly all strcutures are equations, but it will be cases that there will be subscriptRanges or others
                if(equations.get(i).symbolWithDocDefinition().equation()!=null){
                    equationText=equations.get(i).symbolWithDocDefinition().equation().lhs().Id().getText();
                }else{
                    equationText=equations.get(i).symbolWithDocDefinition().subscriptRange().Id().getText();
                }
                fw.write("      name : "+equationText+"\n");
                int a = equations.get(i).start.getStartIndex();
                int b = equations.get(i).stop.getStopIndex();
                Interval interval = new Interval(a,b);
                String equation = ctx.start.getInputStream().getText(interval); //Obtaining all text of equation without trimming
                for(int j=0;j<equation.split("\n").length;j++){
                    reader.readLine();
                }
                Set<String> equationFollowingLines = new HashSet<String>();
                reader.mark(400);  //Arbitrary limit, an equation its supposed to have less than 400 characters, but it can be changed
                for(int j =0;j<3;j++){
                    equationFollowingLines.add(reader.readLine());  //Three lines are read due that it can exists various newlines between equations
                }
                reader.reset();
                if(equationFollowingLines.contains("\t.Control")){ //Control is reached MODIFICAR, NO ES NECESARIO LLEGAR A FINAL TIME
                    locationSpanStartEq+=6;
                    initCharEq+=167;    //Added in order to match Control Delimiter Characters
                }
                int endCharEq;
                int endColumnLocationSpan = 2;
                int equationNewLines = equation.split("\n").length; //One line for UTF-8 and other for \r\n
                if(i<newLinesInEquation.size()){ //It only checks until .Control delimiter
                    if(newLinesInEquation.get(i)){
                        endCharEq = equation.length()+3; //\r \n + last \n that is not read by equation
                        reader.readLine();
                    }else{
                        endCharEq = equation.length()+1;
                        endColumnLocationSpan = equation.split("\n")[equationNewLines-1].length() + 2; //\r \n
                        equationNewLines--;
                    }
                }else{
                    endCharEq = equation.length()+3; //\r \n + last \n that is not read by equation
                }
                if(equationText.indexOf("TIME STEP")!=-1){
                    endCharEq-=2;
                    equationNewLines--;
                    endColumnLocationSpan = 4; //\r \n
                }
                fw.write("      locationSpan : {start: ["+locationSpanStartEq+", 0], end: [" + (locationSpanStartEq+equationNewLines) + ", " + endColumnLocationSpan + "]}\n"); //It will always end in '\r \n'
                locationSpanStartEq=locationSpanStartEq+equationNewLines+1;
                
                fw.write("      span : [" + initCharEq + ", " + (endCharEq+initCharEq) + "]\n");
                initCharEq=initCharEq+endCharEq +1; //+1 to get into next line
            }
            reader.close();
            fw.write("  - type : sketches\n");
            fw.write("    name: \\\\\\---/// Sketch information - do not modify anything except names\n");
            fw.write("    locationSpan : {start: ["+(locationSpanStartEq+1)+", 0], end: [" + (lastLine+1) + ", "+2+"]}\n");
            initCharEq+=2;
            fw.write("    headerSpan : ["+initCharEq+", "+(initCharEq+67)+"]\n"); //Sketch informations characters
            fw.write("    footerSpan : ["+(lastLine+1)+", 2]\n");
            fw.write("    children:\n");
            fw.write("    - type : sketch\n");
            fw.write("      name : V300  Do not put anything below this section - it will be ignored\n");
            fw.write("      locationSpan : {start: ["+(locationSpanStartEq+2)+", 0], end: [" + (lastLine) + ", "+lastLineLength+"]}\n");
            //initCharEq+=67;
            fw.write("      span : [" + (initCharEq+68) + ", " + (initCharEq+graphs[1].length()+10-2) + "]\n"); // 9 characters representing \\\---///, which was deleted in split(), +1 because last char not readed
            

            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private int countFileLines(String input){
        int lines=0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(input));
            while (reader.readLine() != null) lines++;
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return lines;
        }
    }

    private int lastLineLength(String input, int lastLine){
        int len=0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(input));
            for(int i=0;i<lastLine-1;i++){
                reader.readLine();
            }
            len = reader.readLine().length();
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return len;
        }
    }

    private ArrayList<Boolean> checkForNewLines(String input){
        ArrayList<Boolean> array = new ArrayList<>();
        //int len=0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            while (true){
                line = reader.readLine();
                if(line.indexOf("\t.Control")!=-1){
                    break;
                }else if(line.indexOf("|")!=-1){
                    String nextLine = reader.readLine();
                    array.add(nextLine.isBlank());
                }
            }

            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return array;
        }
    }

}
