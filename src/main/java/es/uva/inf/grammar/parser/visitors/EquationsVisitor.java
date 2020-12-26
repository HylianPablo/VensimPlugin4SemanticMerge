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

import es.uva.inf.grammar.parser.ModelParser;

public class EquationsVisitor {

    private ModelParser.FileContext ctx;
    private int initCharEq;
    private int locationSpanStartEq;
    private String input;
    private String output;

    public EquationsVisitor(ModelParser.FileContext ctx, int initCharEq, int locationSpanStartEq, String input,
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
            List<ModelParser.SymbolWithDocContext> equations = ctx.model().symbolWithDoc();
            List<ModelParser.MacroDefinitionContext> macros = ctx.model().macroDefinition();

            int macrosListLen = 0;
            if (macros != null) {
                macrosListLen = macros.size();
            }

            File outF = new File(output);
            FileWriter fw = new FileWriter(outF, true);//True is used to append text instead of overwritting it
            fw.flush();
            BufferedReader reader = new BufferedReader(new FileReader(input));
            reader.readLine();// UTF-8

            ArrayList<Boolean> isMacroList = checkForMacros(input);
            ArrayList<Boolean> newLinesInEquation = checkForNewLines(input);

            int indexOfEquations = 0;
            int indexOfMacros = 0;
            int extraLocationSpan = 0;
            int extraCharsEq = 0;

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
                boolean markBeforeControlParams = false;
                if (equationFollowingLines.contains("\t.Control")) {
                    markBeforeControlParams = true;
                    extraLocationSpan = 6;
                    extraCharsEq = 167; // Added in order to match Control Delimiter Characters
                }
                int endCharEq;
                int endColumnLocationSpan = 2;
                int equationNewLines = equation.split("\n").length; // One line for UTF-8 and other for \n //Antes dividia en \r\n
                String[] equationLines = equation.split("\n");
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
                    if ((equationLines[equationLines.length - 1].contains("~~|")
                            || equationLines[equationLines.length - 1].contains("<[DESCRIPTION]>:|"))
                            && !markBeforeControlParams) {
                        equationNewLines--;
                        endCharEq = equation.length() + 1;
                        endColumnLocationSpan = equationLines[equationLines.length - 1].length() + 2; // \r\n
                    } else {
                        endCharEq = equation.length() + 3; // \r \n + last \n that is not read by equation
                    }
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
                markBeforeControlParams = false;
            }
            fw.flush();
            fw.close();
            reader.close();
            locationSpanStartEq++; // Because TIMESTEP ends one line earlier due to footerSpan
        } catch (Exception ex) {
            System.err.println("Error en el visitor de las ecuaciones");
        }
    }

    private ArrayList<Boolean> checkForMacros(String input) {
        ArrayList<Boolean> array = new ArrayList<>();
        try {
            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
            String[] noControl = text.split("\\\\\\---", 2);
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

    private ArrayList<Boolean> checkForNewLines(String input) {
        ArrayList<Boolean> array = new ArrayList<>();
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
}