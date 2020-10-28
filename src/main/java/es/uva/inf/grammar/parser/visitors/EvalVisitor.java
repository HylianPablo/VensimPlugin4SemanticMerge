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
import java.util.List;

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
            int equationsHeader=0;
            int equationsFooter=9;

            String text = new String(Files.readAllBytes(Paths.get(input)),StandardCharsets.UTF_8);

            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] graphs = text.split(viewsDelimiter,2);

            //String[] noControl = graphs[0].split("\t.Control",2); 
            //String[] equationsLines = noControl[0].split("\\|");
            ArrayList<Boolean> newLinesInEquation = checkForNewLines(input);
            /*
            for(int i=0;i<equationsLines.length;i++){
                newLinesInEquation.add(equationsLines[i].split("\n").length);
            }
            */
            /*
            for(int i=0;i<newLinesInEquation.size();i++){
                System.out.println(newLinesInEquation.get(i));
            }
            */
            
            equationsEndLine = graphs[0].split("\n").length;

            List<ModelParser.SymbolWithDocContext> equations = ctx.model().symbolWithDoc();
            for(int i=0;i<equations.size();i++){
                int a = equations.get(i).start.getStartIndex();
                int b = equations.get(i).stop.getStopIndex();
                Interval interval = new Interval(a,b);
                String equation = ctx.start.getInputStream().getText(interval);
                equationsFooter+=equation.length();
                equationsFooter+=2; //Posiblemente la última línea (sin contar la línea de \r\n no cuente el salto de línea)
                equationsFooter+=2; // \r + \n
            }
            equationsFooter+=166; //Control**** characters APROX, MUST BE CHANGED


            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);
            
            fw.write("---\n");
            fw.write("type: file\n");
            fw.write("name: "+input+"\n");
            fw.write("locationSpan : {start: [1,0], end: [" + (lastLine) + ","+lastLineLength+"]}\n");
            fw.write("footerSpan : [0,-1]\n");
            fw.write("parsingErrorsDetected : false\n");
            fw.write("children:\n");
            fw.write("  - type : equations\n");
            fw.write("    locationSpan : {start: [1,0], end: [" + (equationsEndLine-1) + ",2]}\n");
            fw.write("    headerSpan : [0, 8]\n"); //Assuming file will always start with {UTF-8}, WILL BE CHANGED
            fw.write("    footerSpan : [" + equationsFooter + ", " + equationsFooter + "]\n");
            fw.write("    children :\n");
            int locationSpanStartEq = 2; //Assuming there is always an encoding line {UTF-8}
            int initCharEq = 9; //Assuming there is always an encoding line {UTF-8}
            for(int i =0; i<equations.size();i++){
                fw.write("    - type : equation\n");
                fw.write("      name : "+equations.get(i).symbolWithDocDefinition().equation().lhs().Id().getText()+"\n");
                int a = equations.get(i).start.getStartIndex();
                int b = equations.get(i).stop.getStopIndex();
                Interval interval = new Interval(a,b);
                String equation = ctx.start.getInputStream().getText(interval);
                if(equation.indexOf("FINAL TIME")!=-1){ //Control is reached
                    locationSpanStartEq+=6;
                    initCharEq+=167;
                }
                int endCharEq;
                if(i<newLinesInEquation.size()){
                    if(newLinesInEquation.get(i)){
                        endCharEq = equation.length()+3; //\r \n + last \n that is not read by equation
                    }else{
                        endCharEq = equation.length()+1;
                        locationSpanStartEq-=1;
                    }
                }else{
                    endCharEq = equation.length()+3; //\r \n + last \n that is not read by equation
                }
                int equationNewLines = equation.split("\n").length; //One line for UTF-8 and other for \r\n
                //System.out.println(equationNewLines);
                fw.write("      locationSpan : {start: ["+locationSpanStartEq+",0], end: [" + (locationSpanStartEq+equationNewLines) + "," + "2" + "]}\n"); //It will always end in '\r \n'
                locationSpanStartEq=locationSpanStartEq+equationNewLines+1;
                
                fw.write("      span : [" + initCharEq + ", " + (endCharEq+initCharEq) + "]\n");
                initCharEq=initCharEq+endCharEq +1; //+1 to get into next line
            }
            fw.write("  - type : sketches\n");
            fw.write("    locationSpan : {start: ["+locationSpanStartEq+",0], end: [" + lastLine + ","+lastLineLength+"]}\n");
            fw.write("    span : [" + (initCharEq) + ", " + (initCharEq+graphs[1].length()+8) + "]\n"); // 9 characters representing \\\---///, which was deleted in split(), -1 because last char not readed
            

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
        int len=0;
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
