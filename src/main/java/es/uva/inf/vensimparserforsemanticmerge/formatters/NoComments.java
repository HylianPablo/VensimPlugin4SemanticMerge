package es.uva.inf.vensimparserforsemanticmerge.formatters;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoComments {

    public static void eraseComments(String args[]) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
            String viewsDelimiter = "\\<\\[VIEWS START\\]\\>";
            String[] equationsDefinition = text.split(viewsDelimiter, 2);
            String[] noControl = equationsDefinition[0].split("\t.Control", 2);
            String[] equations = noControl[0].split("\\|");
            String newEquations[] = new String[equations.length];
            String modEquationsText = "";
            modEquationsText += equations[0];
            modEquationsText += "|";
            for (int i = 1; i < equations.length; i++) {
                String[] first = equations[i].split("\\<\\[DESCRIPTION\\]\\>:", 2);
                if (first.length == 1) {
                    continue;
                }
                String[] second = first[0].split("\\<\\[VIEW\\]\\>:");
                newEquations[i] = second[0] + first[1] + "|";
                modEquationsText += newEquations[i];
            }
            String controlRestored = modEquationsText + "\r\n\r\n"
                    + "********************************************************\r\n" + "\t.Control" + noControl[1];
            FileWriter writer = new FileWriter(args[0], false);
            writer.write(controlRestored);
            writer.write("<[VIEWS START]>");
            writer.write(equationsDefinition[1]);
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
