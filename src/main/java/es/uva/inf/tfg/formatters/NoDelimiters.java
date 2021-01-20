package es.uva.inf.tfg.formatters;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoDelimiters {

    public static void main(String args[]) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
            String[] newlines = text.split("\r\n");
            String[] fileName = args[0].split("\\.");
            String backUpName = fileName[0] + ".2mdl";
            FileWriter writerBackup = new FileWriter(backUpName, false);
            writerBackup.write(text);
            writerBackup.close();
            String outputName = args[0];
            //String outputName = "out.txt";
            FileWriter writer = new FileWriter(outputName, false);
            for (int i = 0; i < newlines.length; i++) {
                if (!newlines[i].contains("<[VIEWS START]>") && !newlines[i].contains("<[VIEW START]>")
                        && !newlines[i].contains("<[VIEW END]>") && !newlines[i].contains("<[VIEWS END]>")
                        && !newlines[i].contains("<[GRAPH START]>") && !newlines[i].contains("<[GRAPH END]>")) {
                    writer.write(newlines[i] + "\r\n");
                }
            }
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}