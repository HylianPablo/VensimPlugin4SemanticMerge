package es.uva.inf.tfg;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.uva.inf.tfg.formatters.*;
import es.uva.inf.tfg.parser.*;
import es.uva.inf.tfg.parser.visitors.MainVisitor;

public class Pruebas {
   public static void main(String args[]) {

      try {
         String[] arg1 = new String[2];
         arg1[0] = "VensimExampleModels/SHODOR/Bunny.mdl";
         arg1[1] = "Formatted/BunnyComment.mdl";
         Comment.main(arg1);
      } catch (IOException ex) {
         System.err.println(ex.getMessage());
      }

      String[] arg2 = new String[2];
      arg2[0] = "Formatted/BunnyComment.mdl";
      arg2[1] = "Formatted/BunnyFormat.mdl";
      Delimiter.main(arg2);

      try {

         CharStream charstream = CharStreams.fromFileName("Formatted/BunnyFormat.mdl", StandardCharsets.UTF_8);
         ModelLexer lexer = new ModelLexer(charstream);
         ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
         ParseTree tree = parser.file();

         MainVisitor visitor = new MainVisitor();
         visitor.setInput("Formatted/BunnyFormat.mdl");
         visitor.setOutput("OUT.yaml");
         visitor.visit(tree);
         //System.out.println(tree.toStringTree(parser));// USED TO DEBUG
         /*
         JFrame frame = new JFrame("Antlr AST");
         JPanel panel = new JPanel();
         TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
         viewer.setScale(0.5); // Scale a little panel.add(viewer);
         frame.add(panel);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
         */

      } catch (Exception ex) {
         ex.printStackTrace();
         System.err.println(ex.getMessage());
      }

      String[] arg3 = new String[2];
      arg3[0] = "Formatted/BunnyFormat.mdl";
      arg3[1] = "Formatted/RestoredBunny.mdl";
      NoDelimiters.main(arg3);

   }
}
