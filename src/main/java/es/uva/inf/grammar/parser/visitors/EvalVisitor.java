package es.uva.inf.grammar.parser.visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.misc.Interval;

import es.uva.inf.grammar.parser.ModelBaseVisitor;
import es.uva.inf.grammar.parser.ModelParser;

public class EvalVisitor extends ModelBaseVisitor<String> {

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
            int lastLine = countFileLines(input);
            int lastLineLength = lastLineLength(input, lastLine) + 2;

            int equationsEndLine = 0;

            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);

            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] graphs = text.split(viewsDelimiter, 2);

            // Check if equation has a newline after its definition
            ArrayList<Boolean> newLinesInEquation = checkForNewLines(input);

            equationsEndLine = graphs[0].split("\n").length;

            List<ModelParser.SymbolWithDocContext> equations = ctx.model().symbolWithDoc();
            List<ModelParser.MacroDefinitionContext> macros = ctx.model().macroDefinition();

            int macrosListLen = 0;
            if (macros != null) {
                macrosListLen = macros.size();
            }

            int indexOfEquations = 0;
            int indexOfMacros = 0;
            ArrayList<Boolean> isMacroList = checkForMacros(input);

            String[] equationFooterChars = text.split("\\<\\[VIEW START\\]\\>", 2);
            int equationsFooter = equationFooterChars[0].length() - 1;

            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);

            int extraLocationSpan = 0;
            int extraCharsEq = 0;

            fw.write("---\r\n");
            fw.write("type: file\r\n");
            fw.write("name: " + input + "\r\n");
            fw.write("locationSpan : {start: [1, 0], end: [" + (lastLine + 1) + ", " + 2 + "]}\r\n");
            fw.write("footerSpan : [0,-1]\r\n");
            fw.write("parsingErrorsDetected : false\r\n");
            fw.write("children:\r\n");
            fw.write("  - type : SymbolWithDocs\r\n");
            fw.write("    name: {UTF-8}\r\n");
            fw.write("    locationSpan : {start: [1, 0], end: [" + (equationsEndLine - 2) + ", 2]}\r\n"); //estaba en eEndLine -2
            fw.write("    headerSpan : [0, 8]\r\n"); // Assuming file will always start with {UTF-8}
            fw.write("    footerSpan : [" + (equationsFooter - 1) + ", " + (equationsFooter) + "]\r\n"); //antes +2+3
            fw.write("    children :\r\n");
            int locationSpanStartEq = 2; // Assuming there is always an encoding line {UTF-8}
            int initCharEq = 9; // Assuming there is always an encoding line {UTF-8}
            BufferedReader reader = new BufferedReader(new FileReader(input));
            reader.readLine();// UTF-8
            for (int i = 0; i < (equations.size() + macrosListLen); i++) {
                String equationText; // Mostly all structures are equations, but it will be cases that there will be
                                     // subscriptRanges or others
                String typeName;
                String equation;
                if (!isMacroList.get(i)) {
                    if (equations.get(indexOfEquations).symbolWithDocDefinition().equation() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().equation().lhs().Id()
                                .getText();
                        typeName = "equation";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().subscriptRange() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().subscriptRange().Id()
                                .getText();
                        typeName = "subscriptRange";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().lookupDefinition() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().lookupDefinition()
                                .lhs().Id().getText();
                        typeName = "lookupDefinition";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().dataEquation() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().dataEquation().lhs()
                                .Id().getText();
                        typeName = "dataEquation";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().constraint() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().constraint().lhs().Id()
                                .getText();
                        typeName = "constraint";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition()
                            .unchangeableConstant() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().unchangeableConstant()
                                .lhs().Id().getText();
                        typeName = "unchangeableConstant";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().stringAssign() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().stringAssign().lhs()
                                .Id().getText();
                        typeName = "stringAssign";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().subscriptCopy() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().subscriptCopy().copy
                                .toString();
                        typeName = "subscriptCopy";
                    } else {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().realityCheck().lhs()
                                .Id().getText();
                        typeName = "realityCheck";
                    }
                    int a = equations.get(indexOfEquations).start.getStartIndex();
                    int b = equations.get(indexOfEquations).stop.getStopIndex();
                    Interval interval = new Interval(a, b);
                    equation = ctx.start.getInputStream().getText(interval); // Obtaining all text of equation without
                                                                             // trimming
                    indexOfEquations++;
                } else {
                    typeName = "macro";
                    equationText = macros.get(indexOfMacros).macroHeader().Id().getText();
                    int a = macros.get(indexOfMacros).start.getStartIndex();
                    int b = macros.get(indexOfMacros).stop.getStopIndex();
                    Interval interval = new Interval(a, b);
                    equation = ctx.start.getInputStream().getText(interval); // Obtaining all text of macro without
                                                                             // trimming
                    indexOfMacros++;
                }
                fw.write("    - type : " + typeName + "\r\n");
                fw.write("      name : " + equationText + "\r\n");
                for (int j = 0; j < equation.split("\r\n").length; j++) {
                    reader.readLine();
                }
                Set<String> equationFollowingLines = new HashSet<String>();
                reader.mark(400); // Arbitrary limit, an equation its supposed to have less than 400 characters,
                                  // but it can be changed
                for (int j = 0; j < 3; j++) {
                    equationFollowingLines.add(reader.readLine()); // Three lines are read due that it can exists
                                                                   // various newlines between equations
                }
                reader.reset();
                if (equationFollowingLines.contains("\t.Control")) {

                    extraLocationSpan = 6;
                    extraCharsEq = 167; // Added in order to match Control Delimiter Characters
                }
                int endCharEq;
                int endColumnLocationSpan = 2;
                int equationNewLines = equation.split("\n").length; // One line for UTF-8 and other for \n //Antes
                                                                    // dividia en \r\n
                if (i < newLinesInEquation.size()) { // It only checks until .Control delimiter
                    if (newLinesInEquation.get(i)) {
                        endCharEq = equation.length() + 3; // \r \n + last \n that is not read by equation
                        reader.readLine();
                    } else {
                        endCharEq = equation.length() + 1;
                        endColumnLocationSpan = equation.split("\n")[equationNewLines - 1].length() + 2; // \r \n
                        equationNewLines--;
                        // locationSpanStartEq--;
                    }
                } else {
                    endCharEq = equation.length() + 3; // \r \n + last \n that is not read by equation
                }
                if (i == (equations.size() + macrosListLen) - 1) {
                    endCharEq -= 2;
                    equationNewLines--;
                    endColumnLocationSpan = 4; // \r \n
                }
                /* MACRO ADJUSTMENTS */
                if (typeName.equals("macro")) {
                    equationNewLines--;
                    endColumnLocationSpan = equation.split("\r\n")[equationNewLines].length() + 2; // \r \n
                    endCharEq = equation.length() + 1;
                }

                fw.write("      locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                        + (locationSpanStartEq + equationNewLines + extraLocationSpan) + ", " + endColumnLocationSpan
                        + "]}\r\n"); // It will always end in '\r \n'
                locationSpanStartEq = locationSpanStartEq + equationNewLines + 1;

                fw.write("      span : [" + initCharEq + ", " + (endCharEq + initCharEq + extraCharsEq) + "]\r\n");
                initCharEq = initCharEq + endCharEq + 1; // +1 to get into next line

                locationSpanStartEq += extraLocationSpan;
                extraLocationSpan = 0;
                initCharEq += extraCharsEq;
                extraCharsEq = 0;
            }
            reader.close();
            locationSpanStartEq++; // Because TIMESTEP ends one line earlier due to footerSpan

            List<ModelParser.ViewInfoContext> viewInfoList = ctx.model().sketchesGraphsAndMetadata().sketches()
                    .viewInfo();
            int graphsLastLine = linesUntilText(text, "///---\\\\\\");
            fw.write("  - type : sketches\r\n");
            fw.write("    name : sketches\r\n");
            fw.write("    locationSpan : {start: [" + (locationSpanStartEq) + ", 0], end: [" + (graphsLastLine + 1)
                    + ", " + 14 + "]}\r\n");
            initCharEq += 2;
            fw.write("    headerSpan : [" + initCharEq + ", " + (initCharEq + 15) + "]\r\n"); // View start delimiter
            initCharEq += 16;
            // Divides text on graphs
            String[] viewChars = text.split("\\<\\[VIEW END\\]\\>", 2);
            fw.write(
                    "    footerSpan : [" + (viewChars[0].length()) + ", " + (viewChars[0].length() + 11 + 2) + "]\r\n");
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
                        + (locationSpanStartEq + viewText.split("\n").length + 1) + ", " + (11) + "]}\r\n"); //It will end in \\\---/// PROVISIONAL PARA UNA VISTA
                fw.write("      headerSpan : [" + initCharEq + ", " + (initCharEq + 67) + "]\r\n");
                initCharEq += 68;
                String[] viewCharsNewLines = viewChars[0].split("\n");
                fw.write("      footerSpan : [" + (viewChars[0].length() - 11) + ", " + (viewChars[0].length() - 1)
                        + "]\r\n");
                int viewSettingsChars = viewInfoList.get(i).viewName().getText().length() + 2;
                viewSettingsChars += viewInfoList.get(i).versionCode().getText().length() + 2;
                viewSettingsChars += viewInfoList.get(i).viewVariables().viewSettings().getText().length() + 2;
                locationSpanStartEq += 2;
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
                            .equals(arrowsList.get(i).getClass())) {
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
                    } else { // Variable case SE DEBERIA COMPROBAR LAS SHADOWS Y MARCAR COMO RELEVANTES
                             // CIERTOS CAMPOS
                        boolean nameNextLine = false;
                        fw.write("      - type : variable\r\n");
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
                                fw.write("        name : nextLine\r\n");
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
                            fw.write("        locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                                    + (locationSpanStartEq + 1) + ", "
                                    + (viewVariablesList.get(viewVariablesIndex).visualInfo().getText().length() + 2)
                                    + "]}\r\n");
                            locationSpanStartEq += 2;
                            fw.write("        span : ["
                                    + initCharEq + ", " + (initCharEq
                                            + viewVariablesList.get(viewVariablesIndex).getText().length() + 2 + 1)
                                    + "]\r\n");
                            initCharEq += viewVariablesList.get(viewVariablesIndex).getText().length();
                            initCharEq += 2; // extra characters of second line
                            initCharEq += 2;
                            viewVariablesIndex++;

                        }
                    }
                }
            }
            locationSpanStartEq += 2;
            initCharEq += 25;
            boolean graphsExists = false;
            if (!ctx.model().sketchesGraphsAndMetadata().graphsGroup().graphs().isEmpty()) {
                graphsExists = true;
                int metadataLastLine = linesUntilText(text, ":L<%^E!@");
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
                // String[] viewsSeparatorText = text.split("///---", 2)[1].split("\r\n");
                fw.write("    headerSpan : [" + initCharEq + ", " + (initCharEq + 16) // graphs start delimiter
                        + "]\r\n");
                // initCharEq += viewsSeparatorText[1].length();
                initCharEq += 17;
                // Divides text in metadata
                String[] graphChars = text.split(":L\\<%\\^E\\!@", 2);
                String[] graphCharsNewLines = graphChars[0].split("\n");
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
                    // PARA DELIMITAR GRAPHS, DEBERIA SER CAMBIADO
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
                locationSpanStartEq -= 2;
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
                fw.write("      locationSpan : {start: [" + locationSpanStartEq + ", 0], end: [" + locationSpanStartEq
                        + ", " + (metadataLines.get(i).getText().length() + 2) + "]}\r\n");
                locationSpanStartEq++;
                fw.write("      span : [" + initCharEq + ", "
                        + (initCharEq + metadataLines.get(i).getText().length() + 1) + "]\r\n");
                initCharEq += metadataLines.get(i).getText().length();
                initCharEq += 2;
            }

            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private int countFileLines(String input) {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            while (reader.readLine() != null)
                lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private int lastLineLength(String input, int lastLine) {
        int len = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            for (int i = 0; i < lastLine - 1; i++) {
                reader.readLine();
            }
            len = reader.readLine().length();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return len;
    }

    private ArrayList<Boolean> checkForNewLines(String input) {
        ArrayList<Boolean> array = new ArrayList<>();
        // int len=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            String line;
            while (true) {
                line = reader.readLine();
                if (line.indexOf("\t.Control") != -1) {
                    break;
                } else if (line.indexOf("|") != -1) {
                    String nextLine = reader.readLine();
                    array.add(nextLine.isBlank());
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private ArrayList<Boolean> checkForMacros(String input) {
        ArrayList<Boolean> array = new ArrayList<>();
        try {
            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
            String[] noControl = text.split("\t.Control", 2);
            String[] equations = noControl[0].split("\\|");
            for (int i = 0; i < equations.length; i++) {
                array.add(equations[i].indexOf(":MACRO:") != -1);
            }
            for (int i = 0; i < 4; i++) { // TIME STEP equations
                array.add(false);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return array;
    }

    private int linesUntilText(String text, String line) {
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(line)) {
                return (i + 1);
            }
        }
        return -1;
    }

}
