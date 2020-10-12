package es.uva.inf.grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class Comment {
   
    public static void main(String args[]){
        try{
            String text = new String(Files.readAllBytes(Paths.get("VensimExampleModels/SHODOR/sociology101_mod.mdl")),StandardCharsets.UTF_8);
            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] p1 = text.split(viewsDelimiter,2);
            String graphDelimiter = "///---";
            String[] views = p1[1].split(graphDelimiter,2);

            String[] separatedViews = views[0].split(viewsDelimiter);

            ArrayList<String> viewNames = new ArrayList<>();
            ArrayList<Set> sets = new ArrayList<>();
            for(int i=0;i<separatedViews.length;i++){
                Set set = crearSets(separatedViews[i]);
                sets.add(set);
                String viewName = getViewName(separatedViews[i]);
                viewNames.add(viewName);
            }

            modifyComment(p1[0],sets,viewNames);

        } catch (IOException ex) {
            System.err.println("File couldn´t be read");
        }
    }

    private static String getViewName (String views){
        String[] lines = views.split("\n"); 
        return lines[2].substring(1);
    }

    private static Set crearSets(String views) {  //is static necessary?
        String[] lines = views.split("\n");
        Set set = new HashSet<String>();
        for(int i=4;i<lines.length;i++){
            String[] positions = lines[i].split(",");
            if(positions.length>1){
                set.add(positions[2]);
            }else{
                set.add(positions[0]);
            } 
        }
        return set;
    }

    private static void modifyComment(String equationsText, ArrayList<Set> sets, ArrayList<String> viewNames){
        String[] noControl = equationsText.split("\\*\\*\\*\\*\\*\\*\\*\\*\\*",2);
        String[] equations = noControl[0].split("\\|");
        ArrayList<String> eqNames = new ArrayList<>();
        ArrayList<String> eqView = new ArrayList<>();
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
            //System.out.println(equationName);
            equationName = equationName.trim();
            eqNames.add(equationName);
        }

        String newEquations="";
        for(int i=0;i<eqNames.size();i++){
            for(int j=0;j<sets.size();j++){
                if(sets.get(j).contains(eqNames.get(i))){
                   String newEq = modify(equations[i],viewNames.get(j));
                   newEq+="|";
                   newEquations+=newEq; 
                }
            }
        }
        System.out.println(newEquations);
        System.out.println("*********"+noControl[1]);
    }

    private static String modify(String equation, String viewName){
        //System.out.println(equation);
        int position = StringUtils.ordinalIndexOf(equation, "~", 2);
        String appendix = viewName;
        return insertString(equation, appendix, position);
    }

    // Function to insert string 
    public static String insertString( 
        String originalString, 
        String stringToBeInserted, 
        int index) 
    { 
  
        // Create a new string 
        String newString = originalString.substring(0, index + 1) 
                           + stringToBeInserted
                           + originalString.substring(index + 1); 
  
        // return the modified String 
        return newString; 
    } 
}
