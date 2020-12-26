package es.uva.inf.tfg.parser.visitors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import es.uva.inf.tfg.parser.ModelBaseVisitor;
import es.uva.inf.tfg.parser.ModelParser;
import es.uva.inf.tfg.utils.UtilFunctions;

public class MainVisitor extends ModelBaseVisitor<String> {

    private String input = "";
    private String output = "";

    public void setInput(String text) {
        input = text;
    }

    public void setOutput(String text) {
        output = text;
    }

    @Override
    public String visitFile(ModelParser.FileContext ctx) {
        try {
            int lastLine = UtilFunctions.countFileLines(input);
            //int lastLineLength = lastLineLength(input, lastLine) + 2;

            int equationsEndLine = 0;

            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);

            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] graphs = text.split(viewsDelimiter, 2);

            equationsEndLine = graphs[0].split("\n").length;

            String[] equationFooterChars = text.split("\\<\\[VIEWS START\\]\\>", 2);
            int equationsFooter = equationFooterChars[0].length() - 1;

            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);

            fw.write("---\r\n");
            fw.write("type: file\r\n");
            fw.write("name: " + input + "\r\n");
            fw.write("locationSpan : {start: [1, 0], end: [" + (lastLine + 1) + ", " + 2 + "]}\r\n");
            fw.write("footerSpan : [0,-1]\r\n");
            fw.write("parsingErrorsDetected : false\r\n");
            fw.write("children:\r\n");
            fw.write("  - type : SymbolWithDocs\r\n");
            fw.write("    name: {UTF-8}\r\n");
            fw.write("    locationSpan : {start: [1, 0], end: [" + (equationsEndLine - 3) + ", 2]}\r\n"); //estaba en eEndLine -2
            fw.write("    headerSpan : [0, 8]\r\n"); // Assuming file will always start with {UTF-8}
            fw.write("    footerSpan : [" + (equationsFooter - 1) + ", " + (equationsFooter) + "]\r\n"); //antes +2+3
            fw.write("    children :\r\n");
            fw.flush();
            int locationSpanStartEq = 2; // Assuming there is always an encoding line {UTF-8}
            int initCharEq = 9; // Assuming there is always an encoding line {UTF-8}
            EquationsVisitor equationsVisitor = new EquationsVisitor(ctx, initCharEq, locationSpanStartEq, input,
                    output);
            equationsVisitor.visit();

            initCharEq = equationsVisitor.getInitCharEq();
            locationSpanStartEq = equationsVisitor.getLocationSpanStartEq();

            SketchesVisitor sketchesVisitor = new SketchesVisitor(ctx, initCharEq, locationSpanStartEq, input, output);
            sketchesVisitor.visit();
            initCharEq = sketchesVisitor.getInitCharEq();
            locationSpanStartEq = sketchesVisitor.getLocationSpanStartEq();

            GraphsMetadataVisitor graphsMetadataVisitor = new GraphsMetadataVisitor(ctx, initCharEq,
                    locationSpanStartEq, input, output, lastLine);
            graphsMetadataVisitor.visit();
            initCharEq = graphsMetadataVisitor.getInitCharEq();
            locationSpanStartEq = graphsMetadataVisitor.getLocationSpanStartEq();

            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Error on MainVisitor: " + ex.getMessage());
        }
        return null;
    }

}
