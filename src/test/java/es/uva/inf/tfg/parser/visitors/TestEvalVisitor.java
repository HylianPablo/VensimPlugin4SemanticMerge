package es.uva.inf.tfg.parser.visitors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import es.uva.inf.tfg.parser.ModelLexer;
import es.uva.inf.tfg.parser.ModelParser;

public class TestEvalVisitor {

    @Test
    public void lecturaCorrectaSimple() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/BunnyFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/BunnyFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test1EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test1EvalVisitor.yml) (get-content outputs/evalVisitorTest/test1EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/BunnyFormat.mdl --destination=Formatted/BunnyFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaEcuacionDescriptiva() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/examplesFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/examplesFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test2EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test2EvalVisitor.yml) (get-content outputs/evalVisitorTest/test2EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);

            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=InterfacesTestFiles/parser/WILIAM.mdl --destination=InterfacesTestFiles/parser/WILIAM.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");

        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }
    }

    @Test
    public void lecturaCorrectaUnderscores() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/Lookup_multi_Format.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/Lookup_multi_Format.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test3EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test3EvalVisitor.yml) (get-content outputs/evalVisitorTest/test3EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/Lookup_multi_Format.mdl --destination=Formatted/Lookup_multi_Format.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaLookup() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/test_lookups_Format.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/test_lookups_Format.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test4EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test4EvalVisitor.yml) (get-content outputs/evalVisitorTest/test4EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/test_lookups_Format.mdl --destination=Formatted/test_lookups_Format.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMacros() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/test_macro_Format.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/test_macro_Format.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test5EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test5EvalVisitor.yml) (get-content outputs/evalVisitorTest/test5EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/test_macro_Format.mdl --destination=Formatted/test_macro_Format.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaTimeStepNotLast() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/notTimeStepFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/notTimeStepFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test6EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test6EvalVisitor.yml) (get-content outputs/evalVisitorTest/test6EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);

            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/notTimeStepFormat.mdl --destination=Formatted/notTimeStepFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaConstraint() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/constraintFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/constraintFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test7EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test7EvalVisitor.yml) (get-content outputs/evalVisitorTest/test7EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/constraintFormat.mdl --destination=Formatted/constraintFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaUnchangeableConstant() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/unchangeableConstantFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/unchangeableConstantFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test8EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test8EvalVisitor.yml) (get-content outputs/evalVisitorTest/test8EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/unchangeableConstantFormat.mdl --destination=Formatted/unchangeableConstantFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaDataEquation() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/dataEquationFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/dataEquationFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test9EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test9EvalVisitor.yml) (get-content outputs/evalVisitorTest/test9EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/dataEquationFormat.mdl --destination=Formatted/dataEquationFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMultiplesGraficos() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/fallingRockFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/fallingRockFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test10EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test10EvalVisitor.yml) (get-content outputs/evalVisitorTest/test10EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);
            /*
            Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/fallingRockFormat.mdl --destination=Formatted/fallingRockFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

    @Test
    public void lecturaCorrectaMultiplesVistas() {
        try {
            CharStream charstream = CharStreams.fromFileName("Formatted/sociologyFormat.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            MainVisitor visitor = new MainVisitor();
            visitor.setInput("Formatted/sociologyFormat.mdl");
            visitor.setOutput("outputs/evalVisitorTest/test11EvalVisitor.yml");
            visitor.visit(tree);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(
                    "powershell.exe compare-object (get-content outputs/evalVisitor/test11EvalVisitor.yml) (get-content outputs/evalVisitorTest/test11EvalVisitor.yml)");
            proc.waitFor(5, TimeUnit.SECONDS);

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            String result = br.lines().collect(Collectors.joining("\n"));
            br.close();
            assertEquals("", result);

            /*Process process = Runtime.getRuntime()
                    .exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"
                            + " --source=Formatted/locominiFormat.mdl --destination=Formatted/locominiFormat.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""
                            + " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        } catch (Exception ex) {
            System.err.println("Error en el proceso de diff: " + ex.getMessage());
        }

    }

}