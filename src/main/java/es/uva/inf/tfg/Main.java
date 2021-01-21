package es.uva.inf.tfg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import es.uva.inf.tfg.parser.*;
import es.uva.inf.tfg.parser.visitors.*;

//import es.uva.inf.grammar.utilities.JsonSymbolTableBuilder;
//import es.uva.inf.grammar.utilities.SymbolTableGenerator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try (PrintWriter out = new PrintWriter(args[1])) {
            out.println("READY");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        String firstFile = scanner.nextLine();
        String firstEncoding = scanner.nextLine();
        String firstFileOutput = scanner.nextLine();
        parseFile(firstFile, firstFileOutput, 1);
        System.out.println("OK");

        String secondFile = scanner.nextLine();
        String secondEncoding = scanner.nextLine();
        String secondFileOutput = scanner.nextLine();
        parseFile(secondFile, secondFileOutput, 2);
        System.out.println("OK");

        String end = scanner.nextLine();
        scanner.close();
        if (end.equals("end")) {
            return;
        }
    }

    private static void parseFile(String input, String output, int n) {
        try {
            String module = input;
            String content = new String(Files.readAllBytes(Paths.get(module)), StandardCharsets.UTF_8);

            CharStream charstream = CharStreams.fromFileName(module);
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            // System.out.println(tree.toStringTree(parser));// USED TO DEBUG

            // GUI
            /*
             * JFrame frame = new JFrame("Antlr AST"); JPanel panel = new JPanel();
             * TreeViewer viewer = new TreeViewer(Arrays.asList(
             * parser.getRuleNames()),tree); viewer.setScale(0.5); // Scale a little
             * panel.add(viewer); frame.add(panel);
             * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.pack();
             * frame.setVisible(true);
             */

            MainVisitor evalVisitor = new MainVisitor();
            evalVisitor.setInput(module);
            evalVisitor.setOutput(output);
            evalVisitor.visit(tree);
        } catch (ParseCancellationException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected static ModelParser.FileContext getParseTree(String file_content) {
        ModelLexer lexer = new ModelLexer(CharStreams.fromString(file_content));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ModelParser parser = new ModelParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new VensimErrorListener());

        return parser.file();
    }
}
