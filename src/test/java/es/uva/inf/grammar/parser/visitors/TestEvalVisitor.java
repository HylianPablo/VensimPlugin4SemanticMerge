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
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SHODOR/Bunny.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SHODOR/Bunny.mdl");
            visitor.setOutput("outputs/evalVisitor/test1EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test1EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [128, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [75, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1065, 1066]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [76, 0], end: [128, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1067, 1134]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [128, 2]", line);
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            }
            assertEquals("      span : [1135, 2665]", line);
            reader.close();
            /*
             * Process process = Runtime.getRuntime().exec(
             * "C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+
             * " --source=VensimExampleModels/SHODOR/Bunny.mdl --destination=VensimExampleModels/SHODOR/Bunny.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
             * +
             * " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
             */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaEcuacionDescriptiva() {
        try {
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SHODOR/examples.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SHODOR/examples.mdl");
            visitor.setOutput("outputs/evalVisitor/test2EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test2EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [245, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [146, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1910, 1911]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 25) + 1; i++) {
                line = reader.readLine();
            }
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [147, 0], end: [245, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1912, 1979]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [245, 2]", line);
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            }
            assertEquals("      span : [1980, 5270]", line);
            reader.close();
            /*
             * Process process = Runtime.getRuntime().exec(
             * "C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+
             * " --source=VensimExampleModels/SHODOR/examples.mdl --destination=VensimExampleModels/SHODOR/examples.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
             * +
             * " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
             */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }
    }

    @Test
    public void lecturaCorrectaUnderscores() {
        try {
            CharStream charstream = CharStreams
                    .fromFileName("VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl");
            visitor.setOutput("outputs/evalVisitor/test3EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test3EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [115, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [62, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1249, 1250]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 13) + 1; i++) {
                line = reader.readLine();
            }
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [63, 0], end: [115, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1251, 1318]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [115, 2]", line);
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            }
            assertEquals("      span : [1319, 2515]", line);
            reader.close();

            /*
             * Process process = Runtime.getRuntime().exec(
             * "C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+
             * " --source=VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl --destination=VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
             * +
             * " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
             */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaLookup() {
        try {
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SDXorg/test_lookups_funcnames.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SDXorg/test_lookups_funcnames.mdl");
            visitor.setOutput("outputs/evalVisitor/test4EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test4EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [119, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [67, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1025, 1026]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 11) + 1; i++) {
                line = reader.readLine();
            }
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [68, 0], end: [119, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1027, 1094]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [119, 2]", line);
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            }
            assertEquals("      span : [1095, 2440]", line);
            reader.close();

            /*
             * Process process = Runtime.getRuntime().exec(
             * "C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+
             * " --source=VensimExampleModels/SDXorg/test_lookups_funcnames.mdl --destination=VensimExampleModels/SDXorg/test_lookups_funcnames.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
             * +
             * " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
             */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMacros() {
        try {
            CharStream charstream = CharStreams
                    .fromFileName("VensimExampleModels/SDXorg/test_macro_cross_reference.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SDXorg/test_macro_cross_reference.mdl");
            visitor.setOutput("outputs/evalVisitor/test5EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test5EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [90, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [57, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [987, 988]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 9) + 1; i++) {
                line = reader.readLine();
            }
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [58, 0], end: [90, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [989, 1056]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [90, 2]", line);
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            }
            assertEquals("      span : [1057, 1745]", line);
            reader.close();

            /*
             * Process process = Runtime.getRuntime().exec(
             * "C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+
             * " --source=VensimExampleModels/SDXorg/test_macro_cross_reference.mdl --destination=VensimExampleModels/SDXorg/test_macro_cross_reference.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
             * +
             * " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
             */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaTimeStepNotLast() {
        try {
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SHODOR/notTimeStep.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SHODOR/notTimeStep.mdl");
            visitor.setOutput("outputs/evalVisitor/test6EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test6EvalVisitor.yml"));
            String line = null;
            for (int i = 0; i < 4; i++) {
                line = reader.readLine();
            }
            assertEquals("locationSpan : {start: [1, 0], end: [134, 2]}", line);
            for (int i = 0; i < 6; i++) {
                line = reader.readLine();
            }
            assertEquals("    locationSpan : {start: [1, 0], end: [81, 2]}", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    footerSpan : [1211, 1212]", line);
            reader.readLine();
            for (int i = 0; i < (4 * 14) + 1; i++) {
                line = reader.readLine();
            }
            assertEquals("  - type : sketches", line);
            reader.readLine();
            line = reader.readLine();
            assertEquals("    locationSpan : {start: [82, 0], end: [134, 2]}", line);
            line = reader.readLine();
            assertEquals("    headerSpan : [1213, 1280]", line);
            line = reader.readLine();
            assertEquals("    footerSpan : [134, 2]", line);
            for (int i = 0; i < 5; i++) {
                line = reader.readLine();
            }
            assertEquals("      span : [1281, 2811]", line);
            reader.close();

            /*
             * Process process = Runtime.getRuntime().exec(
             * "C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+
             * " --source=VensimExampleModels/SHODOR/notTimeStep.mdl --destination=VensimExampleModels/SHODOR/notTimeStep.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
             * +
             * " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
             */
        } catch (IOException ex) {
            System.err.println("Error en la lectura del fichero: " + ex.getMessage());
        }

    }

}
