package es.uva.inf.vensimparserforsemanticmerge.formatters;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Delimiter {

    public static void main(String args[]) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] p1 = text.split(viewsDelimiter, 2);
            String graphDelimiter = "///---";
            // graphDelimiter = graphDelimiter.replaceAll("b", "\\\\");
            String[] views = p1[1].split(graphDelimiter, 2);
            String[] metadata = views[1].split(":L\\<%\\^E\\!@", 2);
            // System.out.println(views[1]);
            writeFile(p1[0].substring(0, p1[0].length() - 2), viewsDelimiter, views[0], graphDelimiter,
                    metadata[0].substring(5, metadata[0].length()), metadata[1], args[1]);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void writeFile(String equation, String viewDelimiter, String views, String graphDelimiter,
            String graphs, String metadata, String outputName) {

        String viewsDelimiter = "aaa---///";
        viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
        String[] viewsSeparated = views.split(viewDelimiter);

        try {
            FileWriter writer = new FileWriter(outputName, false);
            writer.write(equation);
            writer.write("<[VIEWS START]>\r\n");
            //writer.write(viewDelimiter);
            //writer.write(views);
            for (int i = 0; i < viewsSeparated.length; i++) {
                writer.write("<[VIEW START]>\r\n");
                writer.write(viewDelimiter);
                if (i != viewsSeparated.length - 1) {
                    writer.write(viewsSeparated[i].substring(0, viewsSeparated[i].length() - 2));
                } else {
                    writer.write(viewsSeparated[i]);
                }
                writer.write("<[VIEW END]>\r\n");
            }
            writer.write(graphDelimiter + "\\\\\\" + "\r\n");
            writer.write("<[VIEWS END]>\r\n");
            writer.write("<[GRAPH START]>\r\n");
            writer.write(graphs);
            writer.write("<[GRAPH END]>\r\n");
            writer.write(":L<%^E!@");
            writer.write(metadata);
            writer.close();
        } catch (IOException ex) {
            System.err.println("An error occurred during writing.");
        }
    }
}
