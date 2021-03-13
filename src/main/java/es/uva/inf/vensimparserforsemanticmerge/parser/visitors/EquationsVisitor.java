package es.uva.inf.vensimparserforsemanticmerge.parser.visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.misc.Interval;

import es.uva.inf.vensimparserforsemanticmerge.parser.ModelParser;
import es.uva.inf.vensimparserforsemanticmerge.utils.UtilFunctions;

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
            FileWriter fw = new FileWriter(outF, StandardCharsets.UTF_8, true);//True is used to append text instead of overwritting it
            fw.flush();
            BufferedReader reader = new BufferedReader(new FileReader(input));
            reader.readLine();// UTF-8

            ArrayList<Boolean> isMacroList = UtilFunctions.checkForMacros(input);
            ArrayList<Boolean> newLinesInEquation = UtilFunctions.checkForNewLines(input);

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
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().equation().lhs().start
                                .getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().equation().lhs().stop
                                .getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        int index = ctx.start.getInputStream().getText(intervalEq).indexOf("[");
                        if (index == -1) {
                            equationText = ctx.start.getInputStream().getText(intervalEq);
                        } else {
                            equationText = ctx.start.getInputStream().getText(intervalEq).substring(0, index);
                        }
                        typeName = "equation";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().subscriptRange() != null) {
                        /*
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().subscriptRange().start
                                .getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().subscriptRange().stop
                                .getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        int index = ctx.start.getInputStream().getText(intervalEq).indexOf(":");
                        equationText = ctx.start.getInputStream().getText(intervalEq).substring(0, index);
                        */
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().subscriptRange().Id()
                                .getText();

                        typeName = "subscriptRange";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().lookupDefinition() != null) {
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().lookupDefinition()
                                .lhs().start.getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().lookupDefinition()
                                .lhs().stop.getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        equationText = ctx.start.getInputStream().getText(intervalEq);
                        typeName = "lookupDefinition";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().dataEquation() != null) {
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().dataEquation()
                                .lhs().start.getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().dataEquation()
                                .lhs().stop.getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        if (ctx.start.getInputStream().getText(intervalEq).indexOf(":") != -1) {
                            int index = ctx.start.getInputStream().getText(intervalEq).indexOf(":");
                            if (ctx.start.getInputStream().getText(intervalEq).indexOf("[") != -1) {
                                int index2 = ctx.start.getInputStream().getText(intervalEq).indexOf("[");
                                equationText = ctx.start.getInputStream().getText(intervalEq).substring(0, index2);
                            } else {
                                equationText = ctx.start.getInputStream().getText(intervalEq).substring(0, index);
                            }
                        } else if (ctx.start.getInputStream().getText(intervalEq).indexOf("[") != -1) {
                            int index = ctx.start.getInputStream().getText(intervalEq).indexOf("[");
                            equationText = ctx.start.getInputStream().getText(intervalEq).substring(0, index);
                        } else {
                            equationText = ctx.start.getInputStream().getText(intervalEq);
                        }
                        typeName = "dataEquation";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().constraint() != null) {
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().constraint().lhs().start
                                .getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().constraint().lhs().stop
                                .getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        equationText = ctx.start.getInputStream().getText(intervalEq);
                        typeName = "constraint";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition()
                            .unchangeableConstant() != null) {
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().unchangeableConstant()
                                .lhs().start.getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().unchangeableConstant()
                                .lhs().stop.getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        equationText = ctx.start.getInputStream().getText(intervalEq);
                        typeName = "unchangeableConstant";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().stringAssign() != null) {
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().stringAssign()
                                .lhs().start.getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().stringAssign()
                                .lhs().stop.getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        equationText = ctx.start.getInputStream().getText(intervalEq);
                        typeName = "stringAssign";
                    } else if (equations.get(indexOfEquations).symbolWithDocDefinition().subscriptCopy() != null) {
                        equationText = equations.get(indexOfEquations).symbolWithDocDefinition().subscriptCopy().copy
                                .toString();
                        typeName = "subscriptCopy";
                    } else {
                        int intvEq1 = equations.get(indexOfEquations).symbolWithDocDefinition().realityCheck()
                                .lhs().start.getStartIndex();
                        int intvEq2 = equations.get(indexOfEquations).symbolWithDocDefinition().realityCheck()
                                .lhs().stop.getStopIndex();
                        Interval intervalEq = new Interval(intvEq1, intvEq2);
                        equationText = ctx.start.getInputStream().getText(intervalEq);
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
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Error on equations visitor: " + ex.getMessage());
        }
    }
}