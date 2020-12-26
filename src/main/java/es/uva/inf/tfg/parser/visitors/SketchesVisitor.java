package es.uva.inf.tfg.parser.visitors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.v4.runtime.misc.Interval;
import es.uva.inf.tfg.utils.UtilFunctions;
import es.uva.inf.tfg.parser.ModelParser;

public class SketchesVisitor {

    private ModelParser.FileContext ctx;
    private int initCharEq;
    private int locationSpanStartEq;
    private String input;
    private String output;

    public SketchesVisitor(ModelParser.FileContext ctx, int initCharEq, int locationSpanStartEq, String input,
            String output) {
        this.ctx = ctx;
        this.initCharEq = initCharEq;
        this.locationSpanStartEq = locationSpanStartEq;
        this.input = input;
        this.output = output;
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

            List<ModelParser.ViewInfoContext> viewInfoList = ctx.model().sketchesGraphsAndMetadata().sketches()
                    .viewInfo();
            int graphsLastLine = UtilFunctions.linesUntilText(text, "///---\\\\\\");
            fw.write("  - type : sketches\r\n");
            fw.write("    name : sketches\r\n");
            fw.write("    locationSpan : {start: [" + (locationSpanStartEq) + ", 0], end: [" + (graphsLastLine + 1)
                    + ", " + 15 + "]}\r\n");
            initCharEq += 2;
            fw.write("    headerSpan : [" + initCharEq + ", " + (initCharEq + 16) + "]\r\n"); // Views start delimiter
            initCharEq += 17;
            // Divides text on graphs
            String[] viewChars = text.split("\\<\\[VIEWS END\\]\\>", 2);
            fw.write("    footerSpan : [" + (viewChars[0].length() - 11) + ", " + (viewChars[0].length() + 14)//+14+25
                    + "]\r\n");
            fw.write("    children:\r\n");
            for (int i = 0; i < viewInfoList.size(); i++) {
                int a = viewInfoList.get(i).start.getStartIndex();
                int b = viewInfoList.get(i).stop.getStopIndex();
                Interval interval = new Interval(a, b);
                String viewText = ctx.start.getInputStream().getText(interval);
                fw.write("    - type : view\r\n");
                fw.write("      name : " + viewInfoList.get(i).viewName().getText().substring(1,
                        viewInfoList.get(i).viewName().getText().length()) + "\r\n");
                fw.write("      locationSpan : {start: [" + (locationSpanStartEq + 1) + ", 0], end: ["
                        + (locationSpanStartEq + viewText.split("\n").length) + ", " + (14) + "]}\r\n"); //It will end in \\\---/// PROVISIONAL PARA UNA VISTA
                fw.write("      headerSpan : [" + initCharEq + ", " + (initCharEq + 67 + 16) + "]\r\n");
                initCharEq += 16;
                initCharEq += 68;
                int indexViewEnd = UtilFunctions.ordinalIndexOf(text, "<[VIEW END]>", i);
                fw.write("      footerSpan : [" + (indexViewEnd) + ", " + (indexViewEnd + 13) + "]\r\n");
                int viewSettingsChars = viewInfoList.get(i).viewName().getText().length() + 2;
                viewSettingsChars += viewInfoList.get(i).versionCode().getText().length() + 2;
                viewSettingsChars += viewInfoList.get(i).viewVariables().viewSettings().getText().length() + 2;
                locationSpanStartEq += 3;
                fw.write("      children:\r\n");
                fw.write("      - type : viewSettings\r\n");
                fw.write("        name : viewSettings\r\n");
                fw.write("        locationSpan : {start: [" + (locationSpanStartEq) + ", 0], end: ["
                        + (locationSpanStartEq + 2) + ", " + (viewText.split("\n")[3].length() + 1) + "]}\r\n");
                locationSpanStartEq += 3;
                fw.write("        span : [" + initCharEq + ", " + (initCharEq + viewSettingsChars - 1) + "]\r\n");
                initCharEq += viewSettingsChars;

                List<ModelParser.ViewVariableContext> viewVariablesList = viewInfoList.get(i).viewVariables()
                        .viewVariable();
                List<ModelParser.ArrowContext> arrowsList = viewInfoList.get(i).viewVariables().arrow();
                int arrowsIndex = 0;
                int viewVariablesIndex = 0;
                for (int j = 1; j <= (viewVariablesList.size() + arrowsList.size()); j++) { // ViewSettings is ommited so it starts on 1
                    if (viewInfoList.get(i).viewVariables().getChild(j).getClass()
                            .equals(arrowsList.get(0).getClass())) {
                        fw.write("      - type : arrow\r\n");
                        fw.write("        name : arrow\r\n");
                        fw.write("        locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                                + locationSpanStartEq + ", " + (arrowsList.get(arrowsIndex).getText().length() + 2)
                                + "]}\r\n");
                        locationSpanStartEq++;
                        fw.write("        span : [" + initCharEq + ", "
                                + (initCharEq + arrowsList.get(arrowsIndex).getText().length() + 1) + "]\r\n");
                        initCharEq += arrowsList.get(arrowsIndex).getText().length();
                        initCharEq += 2;
                        arrowsIndex++;
                    } else {
                        boolean nameNextLine = false;
                        if (Integer.parseInt(viewVariablesList.get(viewVariablesIndex).bits.getText()) % 2 == 0) {
                            if (Integer
                                    .parseInt(viewVariablesList.get(viewVariablesIndex).internalId.getText()) == 10) {
                                fw.write("      - type : shadow variable\r\n");
                            } else {
                                fw.write("      - type : graph variable\r\n");
                            }
                        } else {
                            fw.write("      - type : variable\r\n");
                        }
                        if (viewVariablesList.get(viewVariablesIndex).name != null) { // Third field of variable is not
                                                                                      // null
                            fw.write("        name : " + viewVariablesList.get(viewVariablesIndex).name.getText()
                                    + "\r\n");
                        } else {
                            // Third field equals zero so name is defined in the next line
                            if (!viewVariablesList.get(viewVariablesIndex).visualInfo().getText().equals("")) {
                                fw.write("        name : "
                                        + viewVariablesList.get(viewVariablesIndex).visualInfo().getText() + "\r\n");
                                nameNextLine = true;
                                // It just has an irrelevant variable on third field. Name is trivial, must be
                                // changed
                            } else {
                                fw.write("        name : Numeric\r\n");
                            }
                        }
                        if (!nameNextLine) {
                            fw.write("        locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                                    + locationSpanStartEq + ", "
                                    + (viewVariablesList.get(viewVariablesIndex).getText().length() + 2) + "]}\r\n");
                            locationSpanStartEq++;
                            fw.write("        span : [" + initCharEq + ", "
                                    + (initCharEq + viewVariablesList.get(viewVariablesIndex).getText().length() + 1)
                                    + "]\r\n");
                            initCharEq += viewVariablesList.get(viewVariablesIndex).getText().length();
                            initCharEq += 2;
                            viewVariablesIndex++;
                        } else {
                            int commaCounter = UtilFunctions.countCharacters(
                                    viewVariablesList.get(viewVariablesIndex).visualInfo().getText(), ',');
                            if (commaCounter == -1) {
                                commaCounter = 0;
                            }
                            fw.write("        locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                                    + (locationSpanStartEq + 1) + ", "
                                    + (viewVariablesList.get(viewVariablesIndex).visualInfo().getText().length() + 2
                                            + commaCounter) //It trims space after comma, so it need to be added
                                    + "]}\r\n");
                            locationSpanStartEq += 2;
                            fw.write("        span : [" + initCharEq + ", "
                                    + (initCharEq + viewVariablesList.get(viewVariablesIndex).getText().length() + 2 + 1
                                            + commaCounter)
                                    + "]\r\n");
                            initCharEq += viewVariablesList.get(viewVariablesIndex).getText().length();
                            initCharEq += 2; // extra characters of second line
                            initCharEq += 2;
                            initCharEq += commaCounter;
                            viewVariablesIndex++;

                        }
                    }
                }
                initCharEq += 15; //<[VIEW END]>
                if (i != viewInfoList.size() - 1) {
                    initCharEq--;
                }
            }
            locationSpanStartEq += 3;
            initCharEq += 25;
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Error on sketches visitor: " + ex.getMessage());
        }
    }
}
