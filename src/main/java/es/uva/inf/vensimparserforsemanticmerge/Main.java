package es.uva.inf.vensimparserforsemanticmerge;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import es.uva.inf.vensimparserforsemanticmerge.parser.*;
import es.uva.inf.vensimparserforsemanticmerge.parser.visitors.*;

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
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try (PrintWriter outt = new PrintWriter(args[1])) {
            outt.println("READY");
            outt.close();
            outt.flush();

            Scanner scanner = new Scanner(System.in);

            do {
                String firstFile = scanner.nextLine();
                if (firstFile.equals("end")) {
                    return;
                }
                String firstEncoding = scanner.nextLine();
                String firstFileOutput = scanner.nextLine();
                parseFile(firstFile, firstFileOutput);
                System.out.println("OK");
            } while (scanner.hasNext());

            scanner.close();
            String end = scanner.nextLine();
            if (end.equals("end")) {
                return;
            }
            /*
            String secondFile = scanner.nextLine();
            String secondEncoding = scanner.nextLine();
            String secondFileOutput = scanner.nextLine();
            parseFile(secondFile, secondFileOutput);
            System.out.println("OK");
            
            
            String end = scanner.nextLine();
            scanner.close();
            if (end.equals("end")) {
                return;
            }
            */
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void parseFile(String input, String output) {
        try {
            String module = input;

            CharStream charstream = CharStreams.fromFileName(module);
            ModelLexer lexer = new ModelLexer(charstream);
            ModelParser parser = new ModelParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.file();

            //System.out.println(tree.toStringTree(parser));// USED TO DEBUG

            // GUI
            /*
            JFrame frame = new JFrame("Antlr AST");
            JPanel panel = new JPanel();
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(0.5); // Scale a little
            panel.add(viewer);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
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

}
