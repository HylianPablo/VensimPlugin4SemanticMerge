package es.uva.inf.grammar.parser.visitors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import es.uva.inf.grammar.parser.ModelLexer;
import es.uva.inf.grammar.parser.ModelParser;

public class TestEvalVisitor {

    @Test
    public void lecturaCorrectaSimple() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/BunnyFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/BunnyFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test1EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test1EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            //File location span
            assertEquals("locationSpan : {start: [1, 0], end: [134, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            //SymbolWithDocs locationSpan + footerSpan
            assertEquals("    locationSpan : {start: [1, 0], end: [75, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1329, 1330]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [76, 0], end: [108, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1331, 1347]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2695, 2720]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [77, 0], end: [106, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1348, 1431]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2681, 2694]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [109, 0], end: [120, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2721, 2737]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2877, 2891]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [110, 0], end: [119, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2738, 2876]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [121, 0], end: [134, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2892, 2902]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3024, 3025]", line);
            reader.close();
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/BunnyFormat.mdl --destination=Formatted/BunnyFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaEcuacionDescriptiva() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/examplesFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/examplesFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test2EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test2EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [252, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [147, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [2572, 2573]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 25) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [148, 0], end: [219, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2574, 2590]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [5739, 5764]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [149, 0], end: [217, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [2591, 2674]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [5725, 5738]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 59)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [220, 0], end: [252, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [5765, 5807]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [6027, 6028]", line);
            reader.close();

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/examplesFormat.mdl --destination=Formatted/examplesFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }
    }

    @Test
    public void lecturaCorrectaUnderscores() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/Lookup_multi_Format.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/Lookup_multi_Format.mdl");
            visitor.setOutput("outputs/evalVisitor/test3EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test3EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [121, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [62, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1348, 1349]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [63, 0], end: [82, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1350, 1366]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2266, 2291]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [64, 0], end: [80, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1367, 1450]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2252, 2265]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 11)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [83, 0], end: [121, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2292, 2334]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2709, 2710]", line);
            reader.close();
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/Lookup_multi_Format.mdl --destination=Formatted/Lookup_multi_Format.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaLookup() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/test_lookups_Format.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/test_lookups_Format.mdl");
            visitor.setOutput("outputs/evalVisitor/test4EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test4EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [125, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [67, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1256, 1257]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 11) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [68, 0], end: [92, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1258, 1274]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2336, 2361]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [69, 0], end: [90, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1275, 1358]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2322, 2335]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 16)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [93, 0], end: [125, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2362, 2404]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2766, 2767]", line);
            reader.close();
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/test_lookups_Format.mdl --destination=Formatted/test_lookups_Format.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMacros() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/test_macro_Format.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/test_macro_Format.mdl");
            visitor.setOutput("outputs/evalVisitor/test5EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test5EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [96, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [57, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1053, 1054]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 9) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [58, 0], end: [73, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1055, 1071]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [1666, 1691]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [59, 0], end: [71, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1072, 1155]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [1652, 1665]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 7)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [74, 0], end: [96, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1692, 1734]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [1906, 1907]", line);
            reader.close();

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/test_macro_Format.mdl --destination=Formatted/test_macro_Format.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaTimeStepNotLast() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/notTimeStepFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/notTimeStepFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test6EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test6EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [140, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [81, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1475, 1476]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 14) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [82, 0], end: [114, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1477, 1493]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2841, 2866]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [83, 0], end: [112, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1494, 1577]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2827, 2840]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [115, 0], end: [126, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2867, 2883]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3023, 3037]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [116, 0], end: [125, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2884, 3022]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [127, 0], end: [140, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3038, 3048]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3170, 3171]", line);
            reader.close();

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/notTimeStepFormat.mdl --destination=Formatted/notTimeStepFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaConstraint() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/constraintFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/constraintFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test7EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test7EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [131, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [72, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1353, 1354]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [73, 0], end: [105, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1355, 1371]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2719, 2744]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [74, 0], end: [103, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1372, 1455]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2705, 2718]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [106, 0], end: [117, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2745, 2761]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2901, 2915]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [107, 0], end: [116, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2762, 2900]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [118, 0], end: [131, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2916, 2926]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3048, 3049]", line);
            reader.close();
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/constraintFormat.mdl --destination=Formatted/constraintFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaUnchangeableConstant() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/unchangeableConstantFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/unchangeableConstantFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test8EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test8EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [135, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [76, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1382, 1383]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [77, 0], end: [109, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1384, 1400]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2748, 2773]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [78, 0], end: [107, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1401, 1484]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2734, 2747]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [110, 0], end: [121, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2774, 2790]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2930, 2944]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [111, 0], end: [120, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2791, 2929]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [122, 0], end: [135, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2945, 2955]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3077, 3078]", line);
            reader.close();
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/unchangeableConstantFormat.mdl --destination=Formatted/unchangeableConstantFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaDataEquation() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/dataEquationFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/dataEquationFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test9EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test9EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [137, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [78, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1569, 1570]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [79, 0], end: [111, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1571, 1587]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2935, 2960]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [80, 0], end: [109, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1588, 1671]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2921, 2934]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [112, 0], end: [123, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2961, 2977]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3117, 3131]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [113, 0], end: [122, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2978, 3116]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [124, 0], end: [137, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3132, 3142]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3264, 3265]", line);
            reader.close();
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/dataEquationFormat.mdl --destination=Formatted/dataEquationFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMultiplesGraficos() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/fallingRockFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/fallingRockFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test10EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test10EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [175, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [75, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1206, 1207]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [76, 0], end: [116, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1208, 1224]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2837, 2862]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [77, 0], end: [114, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1225, 1308]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2823, 2836]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 29)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [117, 0], end: [151, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2863, 2879]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3291, 3305]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            //G1
            assertEquals("      locationSpan : {start: [118, 0], end: [129, 2]}", line);
            line = reader.readLine();
            assertEquals("      span : [2880, 3018]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            //G2
            assertEquals("      locationSpan : {start: [130, 0], end: [139, 2]}", line);
            line = reader.readLine();
            assertEquals("      span : [3019, 3139]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            //G3
            assertEquals("      locationSpan : {start: [140, 0], end: [150, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [3140, 3290]", line);

            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [152, 0], end: [175, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3306, 3316]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3477, 3478]", line);
            reader.close();

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/fallingRockFormat.mdl --destination=Formatted/fallingRockFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMultiplesVistas() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/sociologyFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("Formatted/sociologyFormat.mdl");
            visitor.setOutput("outputs/evalVisitor/test11EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test11EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [154, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [77, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1415, 1416]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            //Sketches
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [78, 0], end: [116, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1417, 1433]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3212, 3237]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [79, 0], end: [105, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1434, 1517]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2779, 2792]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 20)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            line = reader.readLine();
            assertEquals("      name : View 2", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [106, 0], end: [114, 14]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [2793, 2876]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [3198, 3211]", line);
            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 3)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [117, 0], end: [130, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3238, 3254]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3420, 3434]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [118, 0], end: [129, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [3255, 3419]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [131, 0], end: [154, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3435, 3445]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3609, 3610]", line);
            reader.close();

            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/climateFormat.mdl --destination=Formatted/climateFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");

        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

}