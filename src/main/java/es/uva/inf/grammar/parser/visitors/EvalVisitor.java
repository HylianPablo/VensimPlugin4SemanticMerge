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
            int equationsFooter = 9;

            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);

            String viewsDelimiter = "aaa---///";
            viewsDelimiter = viewsDelimiter.replaceAll("a", "\\\\");
            String[] graphs = text.split(viewsDelimiter, 2);

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

            equationsFooter += 166; // Control delimiter characters APROX, MUST BE CHANGED

            equationsFooter = graphs[0].length() - 3;

            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);

            int extraLocationSpan = 0;
            int extraCharsEq = 0;

            fw.write("---\n");
            fw.write("type: file\n");
            fw.write("name: " + input + "\n");
            fw.write("locationSpan : {start: [1, 0], end: [" + (lastLine + 1) + ", " + 2 + "]}\n");
            fw.write("footerSpan : [0,-1]\n");
            fw.write("parsingErrorsDetected : false\n");
            fw.write("children:\n");
            fw.write("  - type : SymbolWithDocs\n");
            fw.write("    name: {UTF-8}\n");
            fw.write("    locationSpan : {start: [1, 0], end: [" + (equationsEndLine - 1) + ", 2]}\n");
            fw.write("    headerSpan : [0, 8]\n"); // Assuming file will always start with {UTF-8}
            fw.write("    footerSpan : [" + (equationsFooter - 1) + ", " + equationsFooter + "]\n");
            fw.write("    children :\n");
            int locationSpanStartEq = 2; // Assuming there is always an encoding line {UTF-8}
            int initCharEq = 9; // Assuming there is always an encoding line {UTF-8}
            BufferedReader reader = new BufferedReader(new FileReader(input));
            reader.readLine();// UTF-8
            for (int i = 0; i < (equations.size() + macrosListLen); i++) {
                String equationText; // Mostly all strcutures are equations, but it will be cases that there will be
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
                    equation = ctx.start.getInputStream().getText(interval); // Obtaining all text of equation without
                                                                             // trimming
                    indexOfMacros++;
                }
                fw.write("    - type : " + typeName + "\n");
                fw.write("      name : " + equationText + "\n");
                for (int j = 0; j < equation.split("\n").length; j++) {
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
                int equationNewLines = equation.split("\n").length; // One line for UTF-8 and other for \r\n
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
                    endColumnLocationSpan = equation.split("\n")[equationNewLines].length() + 2; // \r \n
                    endCharEq = equation.length() + 1;
                }

                fw.write("      locationSpan : {start: [" + locationSpanStartEq + ", 0], end: ["
                        + (locationSpanStartEq + equationNewLines + extraLocationSpan) + ", " + endColumnLocationSpan
                        + "]}\n"); // It will always end in '\r \n'
                locationSpanStartEq = locationSpanStartEq + equationNewLines + 1;

                fw.write("      span : [" + initCharEq + ", " + (endCharEq + initCharEq + extraCharsEq) + "]\n");
                initCharEq = initCharEq + endCharEq + 1; // +1 to get into next line

                locationSpanStartEq += extraLocationSpan;
                extraLocationSpan = 0;
                initCharEq += extraCharsEq;
                extraCharsEq = 0;
            }
            reader.close();
            locationSpanStartEq++; // Because TIMESTEP ends one line earlier due to footerSpan
            fw.write("  - type : sketches\n");
            fw.write("    name: \\\\\\---/// Sketch information - do not modify anything except names\n");
            fw.write("    locationSpan : {start: [" + (locationSpanStartEq) + ", 0], end: [" + (lastLine + 1) + ", " + 2
                    + "]}\n");
            initCharEq += 2;
            fw.write("    headerSpan : [" + initCharEq + ", " + (initCharEq + 67) + "]\n"); // Sketch informations
                                                                                            // characters
            fw.write("    footerSpan : [" + (lastLine + 1) + ", 2]\n");
            fw.write("    children:\n");
            fw.write("    - type : sketch\n");
            fw.write("      name : V300  Do not put anything below this section - it will be ignored\n");
            fw.write("      locationSpan : {start: [" + (locationSpanStartEq + 1) + ", 0], end: [" + (lastLine) + ", "
                    + lastLineLength + "]}\n");
            // initCharEq+=67;
            fw.write("      span : [" + (initCharEq + 68) + ", " + (initCharEq + graphs[1].length() + 10 - 2) + "]\n");
            // 9 characters representing \\\---///, which was deleted in split(), +1 because
            // last char not readed
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
        } finally {
            return lines;
        }
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
        } finally {
            return len;
        }
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
        } finally {
            return array;
        }
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

}
