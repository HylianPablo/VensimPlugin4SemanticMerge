package es.uva.inf.vensimparserforsemanticmerge.parser.visitors;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.v4.runtime.misc.Interval;

import es.uva.inf.vensimparserforsemanticmerge.parser.ModelParser;
import es.uva.inf.vensimparserforsemanticmerge.utils.UtilFunctions;

public class GraphsMetadataVisitor {

    private ModelParser.FileContext ctx;
    private int initCharEq;
    private int locationSpanStartEq;
    private String input;
    private String output;
    private int lastLine;

    public GraphsMetadataVisitor(ModelParser.FileContext ctx, int initCharEq, int locationSpanStartEq, String input,
            String output, int lastLine) {
        this.ctx = ctx;
        this.initCharEq = initCharEq;
        this.locationSpanStartEq = locationSpanStartEq;
        this.input = input;
        this.output = output;
        this.lastLine = lastLine;
    }

    public int getInitCharEq() {
        return initCharEq;
    }

    public int getLocationSpanStartEq() {
        return locationSpanStartEq;
    }

    public void visit() {
        try {
            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
            File outF = new File(output);
            FileWriter fw = new FileWriter(outF, true);//True is used to append text instead of overwritting it
            boolean graphsExists = false;
            if (!ctx.model().sketchesGraphsAndMetadata().graphsGroup().graphs().isEmpty()) {
                graphsExists = true;
                int metadataLastLine = UtilFunctions.linesUntilText(text, ":L<%^E!@");
                List<ModelParser.GraphsContext> graphsList = ctx.model().sketchesGraphsAndMetadata().graphsGroup()
                        .graphs();
                // Divides text in metadata, and then gets number of newlines
                String[] untilMetadataText = text.split(":L\\<%\\^E\\!@", 2)[0].split("\r\n");
                fw.write("  - type : graphs\r\n");
                fw.write("    name : graphs\r\n");
                fw.write(
                        "    locationSpan : {start: [" + (locationSpanStartEq) + ", 0], end: [" + (metadataLastLine - 1)
                                + ", " + (untilMetadataText[untilMetadataText.length - 1].length() + 2) + "]}\r\n");
                // New lines since graph section is started
                fw.write("    headerSpan : [" + initCharEq + ", " + (initCharEq + 16) // graphs start delimiter
                        + "]\r\n");
                initCharEq += 17;
                // Divides text in metadata
                String[] graphChars = text.split(":L\\<%\\^E\\!@", 2);
                fw.write("    footerSpan : [" + (graphChars[0].length() - 15) + ", " + (graphChars[0].length() - 1)
                        + "]\r\n"); // \r
                fw.write("    children:\r\n");
                locationSpanStartEq++;
                boolean justOneGraph = true;
                if (graphsList.size() > 1) {
                    justOneGraph = false;
                }
                for (int i = 0; i < graphsList.size(); i++) {
                    fw.write("    - type : graph\r\n");
                    fw.write("      name : " + graphsList.get(i).title().getText().substring(6,
                            graphsList.get(i).title().getText().length()) + "\r\n");
                    int a = graphsList.get(i).start.getStartIndex();
                    int b = graphsList.get(i).stop.getStopIndex();
                    Interval interval = new Interval(a, b);
                    String graphText = ctx.start.getInputStream().getText(interval);
                    int nChildren = graphText.split("\n").length - 1;
                    int nChildrenLen = graphText.split("\n")[graphText.split("\n").length - 1].length() + 2;
                    int extraGrapsSpan = 0;
                    if (!justOneGraph && i != graphsList.size() - 1) { //Graphs are always separated by \r\n
                        nChildren++;
                        nChildrenLen = 2;
                        extraGrapsSpan = 2;
                    }
                    fw.write("      locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                            + (locationSpanStartEq + nChildren) + ", " + nChildrenLen + "]}\r\n");
                    locationSpanStartEq += nChildren;
                    if (!justOneGraph && i != graphsList.size() - 1) {
                        locationSpanStartEq++;
                    }
                    fw.write("      span : [" + initCharEq + ", "
                            + (initCharEq + graphText.length() + extraGrapsSpan + 1) + "]\r\n");
                    initCharEq += graphText.length() + 2;
                    initCharEq += extraGrapsSpan;
                    if (i == graphsList.size() - 1) {
                        initCharEq += 15; //GRAPH END
                    }

                }
            }
            int metadataHeaderPlus = 10;
            if (!graphsExists) {
                metadataHeaderPlus = 42; //chars from graphs delimiter
            }

            locationSpanStartEq += 2;
            fw.write("  - type : metadata\r\n");
            fw.write("    name : metadata\r\n");
            fw.write("    locationSpan : {start: [" + (locationSpanStartEq) + ", 0], end: [" + (lastLine + 1) + ", "
                    + (2) // 9 \n
                    + "]}\r\n");
            locationSpanStartEq++;
            fw.write("    headerSpan : [" + initCharEq + ", " + (initCharEq + metadataHeaderPlus) + "]\r\n");
            initCharEq += metadataHeaderPlus;
            initCharEq++;
            fw.write("    footerSpan : [" + (text.length()) + ", " + (text.length() + 1) + "]\r\n");
            fw.write("    children:\r\n");
            if (!graphsExists) {
                locationSpanStartEq += 2;
            }
            List<ModelParser.MetadataLineContext> metadataLines = ctx.model().sketchesGraphsAndMetadata()
                    .metadataDivisor().metadataLine();
            for (int i = 0; i < metadataLines.size(); i++) {
                fw.write("    - type : metadataLine\r\n");
                fw.write("      name : metadataLine\r\n");
                int intvMetadata1 = metadataLines.get(i).start.getStartIndex();
                int intvMetadata2 = metadataLines.get(i).stop.getStopIndex();
                Interval intervalMetadata = new Interval(intvMetadata1, intvMetadata2);
                fw.write("      locationSpan : {start: [" + locationSpanStartEq + ", 0], end: [" + locationSpanStartEq
                        + ", " + (ctx.start.getInputStream().getText(intervalMetadata).length() + 2) + "]}\r\n");
                locationSpanStartEq++;
                fw.write("      span : [" + initCharEq + ", "
                        + (initCharEq + ctx.start.getInputStream().getText(intervalMetadata).length() + 1) + "]\r\n");
                initCharEq += ctx.start.getInputStream().getText(intervalMetadata).length();
                initCharEq += 2;
            }
            fw.flush();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error on graphs and metedata visitor: " + ex.getMessage());
        }
    }
}
