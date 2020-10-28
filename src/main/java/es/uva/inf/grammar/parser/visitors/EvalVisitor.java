package es.uva.inf.grammar.parser.visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            
            int equationsEndLine=0;
            int equationsHeader=0;
            int equationsFooter=0;

            String text = new String(Files.readAllBytes(Paths.get(input)),StandardCharsets.UTF_8);
            
            String[] noControl = text.split("\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*\\*",2); 
            equationsEndLine = countFileLines(noControl[0]);

            List<ModelParser.SymbolWithDocContext> equations = ctx.model().symbolWithDoc();
            for(int i=0;i<equations.size();i++){
                int a = equations.get(i).start.getStartIndex();
                int b = equations.get(i).stop.getStopIndex();
                Interval interval = new Interval(a,b);
                System.out.println(ctx.start.getInputStream().getText(interval));
                System.out.println("DIFF");
            }
            

            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);
            /*
            fw.write("---\n");
            fw.write("type: file\n");
            fw.write("name: "+input+"\n");
            fw.write("locationSpan : {start: [1,0], end: [" + lastLine + ",1]}\n");
            fw.write("footerSpan : [0,-1]\n");
            fw.write("parsingErrorsDetected : false\n");
            fw.write("children:\n");
            fw.write("  - type : equations\n");
            fw.write("    locationSpan : {start: [1,0], end: [" + equationsEndLine + ",1]}\n");
            fw.write("    headerSpan : [0, 8]\n"); //Assuming file will always start with {UTF-8}, WILL BE CHANGED
            fw.write("    footerSpan : [" + equationsFooter + ", " + equationsFooter + "]\n");
            fw.write("    children :\n");
            */

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
            lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return lines;
        }
    }

}
