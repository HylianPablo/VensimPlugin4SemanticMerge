package es.uva.inf.vensimparserforsemanticmerge.formatters;

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

    public static void main(String args[]) throws IOException {
        try {
            String text = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
            String[] fileName = args[0].split("\\.");
            String backUpName = fileName[0] + ".2mdl";
            FileWriter writerBackup = new FileWriter(backUpName, false);
            writerBackup.write(text);
            writerBackup.close();
            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] p1 = text.split(viewsDelimiter, 2);
            String graphDelimiter = "///---";
            String[] views = p1[1].split(graphDelimiter, 2);

            String[] separatedViews = views[0].split(viewsDelimiter);

            ArrayList<String> viewNames = new ArrayList<>();
            ArrayList<Set<String>> sets = new ArrayList<>();
            for (int i = 0; i < separatedViews.length; i++) {
                Set<String> set = crearSets(separatedViews[i]);
                sets.add(set);
                String viewName = getViewName(separatedViews[i]);
                viewNames.add(viewName);
            }
            String commentModified = modifyComment(p1[0], sets, viewNames);
            String outputFile;
            if (args.length == 1) {
                outputFile = "out.mdl";
            } else {
                outputFile = args[1];
            }
            writeFile(commentModified.substring(0, commentModified.length() - 2), viewsDelimiter, p1[1], outputFile);

        } catch (IOException ex) {
            throw new IOException("File couldn´t be read"); //REVISAR
        }
    }

    private static String getViewName(String views) {
        String[] lines = views.split("\n");
        return lines[2].substring(1);
    }

    private static Set<String> crearSets(String views) {
        String[] lines = views.split("\n");
        Set<String> set = new HashSet<String>();
        for (int i = 4; i < lines.length; i++) {
            String[] positions = lines[i].split(",");
            if (positions.length > 2) {
                set.add(positions[2]);
            } else {
                set.add(positions[0]);
            }
        }
        return set;
    }

    private static String modifyComment(String equationsText, ArrayList<Set<String>> sets,
            ArrayList<String> viewNames) {
        String[] noControl = equationsText.split("\t.Control", 2);
        String[] equations = noControl[0].split("\\|");
        ArrayList<String> eqNames = new ArrayList<>();
        ArrayList<String> eqNamesNoUnderScores = new ArrayList<>();
        for (int i = 0; i < equations.length - 1; i++) {
            String equationName;
            String[] lines = equations[i].split("\n");
            if (i == 0) {
                equationName = lines[1];
            } else {
                equationName = lines[2];
            }
            int equalPos = equationName.indexOf("=");
            if (equalPos != -1)
                equationName = equationName.substring(0, equalPos);
            int parenthesisPos = equationName.indexOf("(");
            if (parenthesisPos != -1)
                equationName = equationName.substring(0, parenthesisPos);
            int bracketPos = equationName.indexOf("[");
            if (bracketPos != -1)
                equationName = equationName.substring(0, bracketPos);
            equationName = equationName.trim();
            String noUnderscore = equationName;
            noUnderscore = noUnderscore.replaceAll("_", " ");
            eqNames.add(equationName);
            eqNamesNoUnderScores.add(noUnderscore);
        }

        String newEquations = "";
        for (int i = 0; i < eqNames.size(); i++) {
            int flag = 0;
            for (int j = 0; j < sets.size(); j++) {
                if (sets.get(j).contains(eqNames.get(i))) {
                    flag = 1;
                    sets.get(j).remove(eqNames.get(i));
                    String newEq = modify(equations[i], viewNames.get(j));
                    newEq += "|";
                    newEquations += newEq;
                    break;
                } else if (sets.get(j).contains(eqNamesNoUnderScores.get(i))) {
                    flag = 1;
                    sets.get(j).remove(eqNamesNoUnderScores.get(i));
                    String newEq = modify(equations[i], viewNames.get(j));
                    newEq += "|";
                    newEquations += newEq;
                    break;
                }
            }
            if (flag == 0) {
                String commentEq = equations[i] + "|";
                newEquations += commentEq;
            }
        }
        return (newEquations + "\r\n\r\n" + "********************************************************\r\n"
                + "\t.Control" + noControl[1]);
    }

    private static String modify(String equation, String viewName) {
        int position = StringUtils.ordinalIndexOf(equation, "~", 2);
        String appendix = viewName.trim();
        if (equation.indexOf("<[VIEW]>:") == -1) {
            appendix = "<[VIEW]>: " + appendix;
            return insertString(equation, appendix, position);
        } else {
            return updateViewName(equation, appendix, position);
        }
    }

    private static String updateViewName(String equation, String appendix, int position) {
        //System.out.println(equation);
        String[] viewpart = equation.split("\\<\\[VIEW\\]\\>:");
        String[] descriptionPart = viewpart[1].split("\\<\\[DESCRIPTION\\]\\>:");
        return viewpart[0] + "<[VIEW]>: " + appendix + " <[DESCRIPTION]>:" + descriptionPart[1];
    }

    private static String insertString(String originalString, String stringToBeInserted, int index) {
        String newString = originalString.substring(0, index + 1) + stringToBeInserted + " <[DESCRIPTION]>:"
                + originalString.substring(index + 1);
        return newString;
    }

    private static void writeFile(String commentModified, String viewDelimiter, String lastPart, String outputName) {
        try {
            FileWriter writer = new FileWriter(outputName, false);
            writer.write(commentModified);
            writer.write(viewDelimiter);
            writer.write(lastPart);
            writer.close();
        } catch (IOException ex) {
            System.err.println("An error occurred during writing.");
        }
    }
}
