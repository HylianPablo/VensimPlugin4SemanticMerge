package es.uva.inf.grammar;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class Comment {
   
    public static void main(String args[]){
        try{
            String text = new String(Files.readAllBytes(Paths.get("VensimExampleModels/LIBRO/CHAP08VE/LINEARPO.MDL")));
            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] p1 = text.split(viewsDelimiter,2);
            String graphDelimiter = "///---";
            String[] views = p1[1].split(graphDelimiter,2);

            String[] separatedViews = views[0].split(viewsDelimiter);

            ArrayList<String> viewNames = new ArrayList<>();
            ArrayList<Set<String>> sets = new ArrayList<>();
            for(int i=0;i<separatedViews.length;i++){
                Set<String> set = crearSets(separatedViews[i]);
                sets.add(set);
                String viewName = getViewName(separatedViews[i]);
                viewNames.add(viewName);
            }
            String commentModified=modifyComment(p1[0],sets,viewNames);
            writeFile(commentModified.substring(0, commentModified.length()-2),viewsDelimiter,p1[1]);

        } catch (IOException ex) {
            System.err.println("File couldn´t be read.");
        }
    }

    private static String getViewName (String views){
        String[] lines = views.split("\n"); 
        return lines[2].substring(1);
    }

    private static Set<String> crearSets(String views) {  
        String[] lines = views.split("\n");
        Set<String> set = new HashSet<String>();
        for(int i=4;i<lines.length;i++){
            String[] positions = lines[i].split(",");
            if(positions.length>2){
                set.add(positions[2]);
            }else{
                set.add(positions[0]);
            } 
        }
        return set;
    }

    private static String modifyComment(String equationsText, ArrayList<Set<String>> sets, ArrayList<String> viewNames){
        String[] noControl = equationsText.split("\t.Control",2); 
        String[] equations = noControl[0].split("\\|");
        ArrayList<String> eqNames = new ArrayList<>();
        for(int i=0;i<equations.length-1;i++){
            String equationName;
            String[] lines = equations[i].split("\n");
            if(i==0){
                equationName = lines[1];
            }else{
                equationName = lines[2];
            }
            int equalPos = equationName.indexOf("=");
            if(equalPos!=-1)
                equationName = equationName.substring(0, equalPos);
            int parenthesisPos = equationName.indexOf("(");
            if(parenthesisPos!=-1)
                equationName = equationName.substring(0, parenthesisPos);
            equationName = equationName.trim();
            eqNames.add(equationName);
        }

        String newEquations="";
        for(int i=0;i<eqNames.size();i++){
            int flag = 0;
            for(int j=0;j<sets.size();j++){
                if(sets.get(j).contains(eqNames.get(i))){
                   flag = 1;
                   sets.get(j).remove(eqNames.get(i));
                   String newEq = modify(equations[i],viewNames.get(j));
                   newEq+="|";
                   newEquations+=newEq;
                   break; 
                }
            }if(flag==0){
                String commentEq = equations[i] + "|";
                newEquations+=commentEq;
            }
        }
        return(newEquations+"\n\n"+"********************************************************\n"+"\t.Control"+noControl[1]);
    }

    private static String modify(String equation, String viewName){
        int position = StringUtils.ordinalIndexOf(equation, "~", 2);
        String appendix = viewName.trim();
        return insertString(equation, appendix, position);
    }

    public static String insertString( 
        String originalString, 
        String stringToBeInserted, 
        int index) 
    { 
        String newString = originalString.substring(0, index + 1) 
                           + stringToBeInserted
                           + originalString.substring(index + 1); 
        return newString; 
    }

    public static void writeFile(String commentModified, String viewDelimiter, String lastPart){
        try{
            FileWriter writer = new FileWriter("out.mdl");
            writer.write(commentModified);
            writer.write(viewDelimiter);
            writer.write(lastPart);
            writer.close();
        }catch(IOException ex){
            System.err.println("An error occurred during writing.");
        }
    }
}
