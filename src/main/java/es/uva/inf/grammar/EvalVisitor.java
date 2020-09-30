package es.uva.inf.grammar;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class EvalVisitor {
    public static void main(String[] args) throws Exception {
        CharStream charstream = CharStreams.fromFileName("VensimExampleModels/LIBRO/APP_AVE/INV-WFWI.MDL");
        GrammarLexer lexer = new GrammarLexer(charstream);
        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.file();

        System.out.println(tree.toStringTree(parser));

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
    }
}
