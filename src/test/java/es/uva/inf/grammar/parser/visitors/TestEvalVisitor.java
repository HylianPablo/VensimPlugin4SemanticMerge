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
            assertEquals("locationSpan : {start: [1, 0], end: [132, 2]}", line);
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
            assertEquals("    locationSpan : {start: [76, 0], end: [106, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1331, 1346]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2675, 2688]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [77, 0], end: [105, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1347, 1414]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2664, 2674]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [107, 0], end: [118, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2689, 2705]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2845, 2859]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [108, 0], end: [117, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2706, 2844]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [119, 0], end: [132, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2860, 2870]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2992, 2993]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [250, 2]}", line);
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
            assertEquals("    locationSpan : {start: [148, 0], end: [217, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2574, 2589]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [5719, 5732]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [149, 0], end: [216, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [2590, 2657]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [5708, 5718]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 59)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [218, 0], end: [250, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [5733, 5775]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [5995, 5996]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [119, 2]}", line);
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
            assertEquals("    locationSpan : {start: [63, 0], end: [80, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1350, 1365]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2246, 2259]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [64, 0], end: [79, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1366, 1433]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2235, 2245]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 11)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [81, 0], end: [119, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2260, 2302]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2677, 2678]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [123, 2]}", line);
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
            assertEquals("    locationSpan : {start: [68, 0], end: [90, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1258, 1273]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2316, 2329]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [69, 0], end: [89, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1274, 1341]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2305, 2315]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 16)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [91, 0], end: [123, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2330, 2372]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2734, 2735]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [94, 2]}", line);
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
            assertEquals("    locationSpan : {start: [58, 0], end: [71, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1055, 1070]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [1646, 1659]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [59, 0], end: [70, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1071, 1138]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [1635, 1645]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 7)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [72, 0], end: [94, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1660, 1702]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [1874, 1875]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [138, 2]}", line);
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
            assertEquals("    locationSpan : {start: [82, 0], end: [112, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1477, 1492]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2821, 2834]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [83, 0], end: [111, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1493, 1560]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2810, 2820]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [113, 0], end: [124, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2835, 2851]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2991, 3005]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [114, 0], end: [123, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2852, 2990]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [125, 0], end: [138, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3006, 3016]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3138, 3139]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [129, 2]}", line);
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
            assertEquals("    locationSpan : {start: [73, 0], end: [103, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1355, 1370]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2699, 2712]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [74, 0], end: [102, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1371, 1438]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2688, 2698]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [104, 0], end: [115, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2713, 2729]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2869, 2883]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [105, 0], end: [114, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2730, 2868]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [116, 0], end: [129, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2884, 2894]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3016, 3017]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [133, 2]}", line);
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
            assertEquals("    locationSpan : {start: [77, 0], end: [107, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1384, 1399]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2728, 2741]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [78, 0], end: [106, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1400, 1467]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2717, 2727]", line);

            reader.readLine();
            reader.readLine();
            for (int i = 0; i < 4 * ((1 + 23)); i++) { //view settings + other variables
                line = reader.readLine();
            }
            //Graphs
            assertEquals("  - type : graphs", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [108, 0], end: [119, 15]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2742, 2758]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2898, 2912]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [109, 0], end: [118, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2759, 2897]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [120, 0], end: [133, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [2913, 2923]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3045, 3046]", line);
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
            assertEquals("locationSpan : {start: [1, 0], end: [135, 2]}", line);
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
            assertEquals("    locationSpan : {start: [79, 0], end: [109, 14]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1571, 1586]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [2915, 2928]", line);
            for (int i = 0; i < 3; i++) {
                line = reader.readLine();
            }
            assertEquals("      name : View 1", line);
            line = reader.readLine();
            assertEquals("      locationSpan : {start: [80, 0], end: [108, 11]}", line);
            line = reader.readLine();
            assertEquals("      headerSpan : [1587, 1654]", line);
            line = reader.readLine();
            assertEquals("      footerSpan : [2904, 2914]", line);

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
            assertEquals("    headerSpan : [2929, 2945]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3085, 3099]", line);
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("      locationSpan : {start: [111, 0], end: [120, 15]}", line);
            line = reader.readLine();
            assertEquals("      span : [2946, 3084]", line);
            line = reader.readLine();
            //Metadata
            assertEquals("  - type : metadata", line);
            line = reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [122, 0], end: [135, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [3100, 3110]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [3232, 3233]", line);
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

}