package es.uva.inf.grammar;

import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.uva.inf.grammar.parser.*;
import es.uva.inf.grammar.parser.visitors.EvalVisitor;

public class Pruebas {
   public static void main(String args[]) {

      /*
      try {
         String[] arg1 = new String[2];
         arg1[0] = "VensimExampleModels/SHODOR/FallingRockWithDrag.mdl";
         arg1[1] = "Formatted/fallingRockComment.mdl";
         Comment.main(arg1);
      } catch (IOException ex) {
         System.err.println(ex.getMessage());
      }
      */

      String[] arg2 = new String[2];
      arg2[0] = "VensimExampleModels/SHODOR/Bunny.mdl";
      arg2[1] = "TEST_FORMAT.mdl";
      Delimiter.main(arg2);

      /*
      try {
      
         CharStream charstream = CharStreams.fromFileName("Formatted/fallingRockFormat.mdl");
         ModelLexer lexer = new ModelLexer(charstream);
         ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
         ParseTree tree = parser.file();
      
         EvalVisitor visitor = new EvalVisitor();
         visitor.setInput("Formatted/fallingRockFormat.mdl");
         visitor.setOutput("OUT.yaml");
         visitor.visit(tree); // System.out.println(tree.toStringTree(parser));// USED TO DEBUG
         */

      /*
        
        JFrame frame = new JFrame("Antlr AST"); JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),
        tree); viewer.setScale(0.5); // Scale a little panel.add(viewer);
        frame.add(panel); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); frame.setVisible(true);
       
      } catch (Exception ex) {
      
      }
      */
   }
}
