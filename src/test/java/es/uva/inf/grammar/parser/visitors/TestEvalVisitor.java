package es.uva.inf.grammar.parser.visitors;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.uva.inf.grammar.MainBazaco;
import es.uva.inf.grammar.parser.ModelLexer;
import es.uva.inf.grammar.parser.ModelParser;
import es.uva.inf.grammar.parser.visitors.EvalVisitor;

public class TestEvalVisitor {

    @Test
    public void lecturaCorrectaSimple(){
        try{
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SHODOR/Bunny.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SHODOR/Bunny.mdl");
            visitor.setOutput("outputs/evalVisitor/test1EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test1EvalVisitor.yml"));
            String line=null;
            for(int i = 0; i<4; i++){
                line=reader.readLine();
            }
            assertEquals(line,"locationSpan : {start: [1, 0], end: [128, 2]}");
            for(int i = 0; i<6; i++){
                line=reader.readLine();
            }
            assertEquals(line,"    locationSpan : {start: [1, 0], end: [75, 2]}");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [1065, 1066]");
            reader.readLine();
            for(int i=0; i<(4*13)+1;i++){
                line=reader.readLine();
            }
            assertEquals(line,"  - type : sketches");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    locationSpan : {start: [76, 0], end: [128, 2]}");
            line = reader.readLine();
            assertEquals(line,"    headerSpan : [1067, 1134]");
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [128, 2]");
            for(int i = 0; i<5; i++){
                line=reader.readLine();
            }
            assertEquals(line,"      span : [1135, 2665]");
            reader.close();
            /*
            Process process = Runtime.getRuntime().exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+  
            " --source=VensimExampleModels/SHODOR/Bunny.mdl --destination=VensimExampleModels/SHODOR/Bunny.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""+
            " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        }catch(IOException ex){
            System.err.println("Error en la lectura del fichero: "+ex.getMessage());
        }

    }
    
    
    @Test
    public void lecturaCorrectaEcuacionDescriptiva(){
        try{
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SHODOR/examples.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SHODOR/examples.mdl");
            visitor.setOutput("outputs/evalVisitor/test2EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test2EvalVisitor.yml"));
            String line=null;
            for(int i = 0; i<4; i++){
                line=reader.readLine();
            }
            assertEquals(line,"locationSpan : {start: [1, 0], end: [245, 2]}");
            for(int i = 0; i<6; i++){
                line=reader.readLine();
            }
            assertEquals(line,"    locationSpan : {start: [1, 0], end: [146, 2]}");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [1910, 1911]");
            reader.readLine();
            for(int i=0; i<(4*25)+1;i++){
                line=reader.readLine();
            }
            assertEquals(line,"  - type : sketches");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    locationSpan : {start: [147, 0], end: [245, 2]}");
            line = reader.readLine();
            assertEquals(line,"    headerSpan : [1912, 1979]");
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [245, 2]");
            for(int i = 0; i<5; i++){
                line=reader.readLine();
            }
            assertEquals(line,"      span : [1980, 5270]");
            reader.close();
            /*
            Process process = Runtime.getRuntime().exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+  
            " --source=VensimExampleModels/SHODOR/examples.mdl --destination=VensimExampleModels/SHODOR/examples.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""+
            " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        }catch(IOException ex){
            System.err.println("Error en la lectura del fichero: "+ex.getMessage());
        }
    }
    
        @Test
    public void lecturaCorrectaUnderscores(){
        try{
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl");
            visitor.setOutput("outputs/evalVisitor/test3EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test3EvalVisitor.yml"));
            String line=null;
            for(int i = 0; i<4; i++){
                line=reader.readLine();
            }
            assertEquals(line,"locationSpan : {start: [1, 0], end: [115, 2]}");
            for(int i = 0; i<6; i++){
                line=reader.readLine();
            }
            assertEquals(line,"    locationSpan : {start: [1, 0], end: [62, 2]}");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [1249, 1250]");
            reader.readLine();
            for(int i=0; i<(4*13)+1;i++){
                line=reader.readLine();
            }
            assertEquals(line,"  - type : sketches");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    locationSpan : {start: [63, 0], end: [115, 2]}");
            line = reader.readLine();
            assertEquals(line,"    headerSpan : [1251, 1318]");
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [115, 2]");
            for(int i = 0; i<5; i++){
                line=reader.readLine();
            }
            assertEquals(line,"      span : [1319, 2515]");
            reader.close();
            
            /*
            Process process = Runtime.getRuntime().exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+  
            " --source=VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl --destination=VensimExampleModels/CLOUD/Lookup_multidimensional_model.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""+
            " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        }catch(IOException ex){
            System.err.println("Error en la lectura del fichero: "+ex.getMessage());
        }

    }

        @Test
    public void lecturaCorrectaLookup(){
        try{
            CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SDXorg/test_lookups_funcnames.mdl");
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            EvalVisitor visitor = new EvalVisitor();
            visitor.setInput("VensimExampleModels/SDXorg/test_lookups_funcnames.mdl");
            visitor.setOutput("outputs/evalVisitor/test4EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("outputs/evalVisitor/test4EvalVisitor.yml"));
            String line=null;
            for(int i = 0; i<4; i++){
                line=reader.readLine();
            }
            assertEquals(line,"locationSpan : {start: [1, 0], end: [119, 2]}");
            for(int i = 0; i<6; i++){
                line=reader.readLine();
            }
            assertEquals(line,"    locationSpan : {start: [1, 0], end: [67, 2]}");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [1025, 1026]");
            reader.readLine();
            for(int i=0; i<(4*11)+1;i++){
                line=reader.readLine();
            }
            assertEquals(line,"  - type : sketches");
            reader.readLine();
            line = reader.readLine();
            assertEquals(line,"    locationSpan : {start: [68, 0], end: [119, 2]}");
            line = reader.readLine();
            assertEquals(line,"    headerSpan : [1027, 1094]");
            line = reader.readLine();
            assertEquals(line,"    footerSpan : [119, 2]");
            for(int i = 0; i<5; i++){
                line=reader.readLine();
            }
            assertEquals(line,"      span : [1095, 2440]");
            reader.close();
            
            /*
            Process process = Runtime.getRuntime().exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+  
            " --source=VensimExampleModels/SDXorg/test_lookups_funcnames.mdl --destination=VensimExampleModels/SDXorg/test_lookups_funcnames.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""+
            " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
            */
        }catch(IOException ex){
            System.err.println("Error en la lectura del fichero: "+ex.getMessage());
        }

    }
    
}
