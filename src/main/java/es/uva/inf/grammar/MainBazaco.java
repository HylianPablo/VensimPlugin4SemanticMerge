package es.uva.inf.grammar;

import es.uva.inf.grammar.parser.*;
import es.uva.inf.grammar.parser.visitors.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import es.uva.inf.grammar.utilities.JsonSymbolTableBuilder;
import es.uva.inf.grammar.utilities.SymbolTableGenerator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainBazaco {
   public static void main(String args[]){
       try {
            String module = "VensimExampleModels/SHODOR/Bunny.mdl";
            String content = new String(Files.readAllBytes(Paths.get(module)),StandardCharsets.UTF_8);

            JsonSymbolTableBuilder jsonBuilder = new JsonSymbolTableBuilder();

            ModelParser.FileContext root = getParseTree(content);


            SymbolTable table = SymbolTableGenerator.getSymbolTable(root);
            jsonBuilder.addSymbolTable(module,table);

            SymbolTable dbTable = null;

            VensimVisitorContext visitorContext = new VensimVisitorContext(root, table, dbTable);

            generateJsonOutput(jsonBuilder);

            /*
            for(Symbol symbol:table.getSymbols()){
                System.out.println(symbol);
            }
            */

            CharStream charstream = CharStreams.fromFileName(module);
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            //System.out.println(tree.toStringTree(parser));// USED TO DEBUG

            //GUI
            /*
            JFrame frame = new JFrame("Antlr AST");
            JPanel panel = new JPanel();
            TreeViewer viewer = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
            viewer.setScale(0.5); // Scale a little
            panel.add(viewer);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            */

            
            EvalVisitor evalVisitor = new EvalVisitor();
            evalVisitor.setInput(module);
            evalVisitor.setOutput("YAML.yaml");
            evalVisitor.visit(tree);
            

        }catch (ParseCancellationException e){
            e.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
   }

   protected static void generateJsonOutput(JsonSymbolTableBuilder jsonBuilder) {
       JsonArray symbolTable =  jsonBuilder.build();

        try {

            File file = new File("symbolTable.json");
            JsonWriter writer = Json.createWriter(new FileOutputStream(file));
            writer.writeArray(symbolTable);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected static ModelParser.FileContext getParseTree(String file_content){
        ModelLexer lexer = new ModelLexer(CharStreams.fromString(file_content));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ModelParser parser = new ModelParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new VensimErrorListener());

        return parser.file();
    }
}
