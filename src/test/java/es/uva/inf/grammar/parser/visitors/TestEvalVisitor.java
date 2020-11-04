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
            visitor.setOutput("test1EvalVisitor.yml");
            visitor.visit(tree);

            BufferedReader reader = new BufferedReader(new FileReader("test1EvalVisitor.yml"));
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
            Process process = Runtime.getRuntime().exec("C:\\Users\\Propietario\\AppData\\Local\\semanticmerge.\\semanticmergetool.exe"+  
            " --source=VensimExampleModels/SHODOR/Bunny.mdl --destination=VensimExampleModels/SHODOR/Bunny.mdl --externalparser=\"-jar target/mvntfg-1.0-jar-with-dependencies.jar\""+
            " --virtualmachine=\"C:\\Program Files\\Java\\jdk-11.0.8\\bin\\java.exe\"");
        }catch(IOException ex){
            System.err.println("Error en la lectura del fichero: "+ex.getMessage());
        }

    }
    
}
