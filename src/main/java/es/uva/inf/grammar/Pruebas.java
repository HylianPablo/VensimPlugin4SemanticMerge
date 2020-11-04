package es.uva.inf.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.uva.inf.grammar.parser.*;
import es.uva.inf.grammar.parser.visitors.EvalVisitor;

public class Pruebas {
   public static void main(String args[]) {
      try {
         CharStream charstream = CharStreams.fromFileName("VensimExampleModels/SHODOR/Bunny.mdl");
         ModelLexer lexer = new ModelLexer(charstream);
         ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
         ParseTree tree = parser.file();

         EvalVisitor visitor = new EvalVisitor();
         visitor.setInput("VensimExampleModels/SHODOR/Bunny.mdl");
         visitor.setOutput("outputs/evalVisitor/test1EvalVisitor.yml");
         visitor.visit(tree);
      } catch (IOException ex) {

      }
   }
}
