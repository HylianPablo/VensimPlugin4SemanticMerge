package es.uva.inf.vensimparserforsemanticmerge.formatters;

import javax.imageio.ImageIO;
// Java program to create open or 
// save dialog using JFileChooser 
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Color;

import javax.swing.filechooser.*;

public class ViewNamesDelimiterGUI extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Jlabel to show the files user selects
    static JLabel l;
    static JLabel auxL;

    static JLabel infoProcess;

    // button to open save dialog
    static JButton processButton = new JButton("Process");

    // button to open open dialog
    static JButton openButton = new JButton("Open file");

    // button to return to initial state
    static JButton cancelButton = new JButton("Cancel");

    // button to show absolute path
    static JButton pathButton = new JButton("Show absolute path");

    private String filePath;
    private String shortPath;
    private boolean absolutePathState = false;

    private AdderController controller;

    private static String FONT = "Sans Serif";

    // a default constructor
    ViewNamesDelimiterGUI() {
        filePath = "";
        shortPath = "";
        controller = new AdderController(this);
    }

    private boolean checkFile(String filepath) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(filepath)), StandardCharsets.UTF_8);
            if (text.contains("<[VIEWS START]>") || text.contains("<[VIEW START]>") || text.contains("<[VIEW END]>")
                    || text.contains("<[VIEWS END]>") || text.contains("<[GRAPH START]>")
                    || text.contains("<[GRAPH END]>")) {
                return false;
            }
        } catch (IOException ex) {
            System.err.println("File could not be read");
        }
        return true;
    }

    public static void main(String args[]) {
        // frame to contains GUI elements
        JFrame f = new JFrame("Add view names and delimiters");

        // set the size of the frame
        f.setSize(600, 400);

        // set favicon
        try {
            File here = new File(".");
            String pathHere = here.getAbsolutePath();
            File imageFile = new File(pathHere.substring(0, pathHere.length() - 1) + "resources/faviconAdder.png");
            BufferedImage image = ImageIO.read(imageFile);
            f.setIconImage(image);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        // set the frame's visibility
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make an object of the class filechooser
        ViewNamesDelimiterGUI f1 = new ViewNamesDelimiterGUI();

        // add action listener to the button to capture user
        // response on buttons
        processButton.addActionListener(f1);
        openButton.addActionListener(f1);
        cancelButton.addActionListener(f1);
        pathButton.addActionListener(f1);

        // make a panel to add the buttons and labels
        JPanel p = new JPanel();
        // p.setLayout(null);

        // set the label to its initial value
        l = new JLabel("no file selected", SwingConstants.CENTER);
        l.setFont(new Font(FONT, Font.PLAIN, 28));
        auxL = new JLabel("", SwingConstants.CENTER);
        auxL.setFont(new Font(FONT, Font.PLAIN, 12));
        infoProcess = new JLabel(
                "The process button will add both delimiters used to parse the file and view names to equations.",
                SwingConstants.CENTER);

        Dimension size = l.getPreferredSize();
        l.setBounds(50, 50, 500, size.height);
        auxL.setBounds(50, 70, 500, size.height);
        auxL.setForeground(Color.black);
        infoProcess.setBounds(20, 120, 540, size.height);

        processButton.setBounds(190, 170, 90, 50);
        processButton.setVisible(false);

        openButton.setBounds(250, 170, 90, 50);

        cancelButton.setBounds(320, 170, 90, 50);
        cancelButton.setVisible(false);

        pathButton.setBounds(200, 260, 200, 20);
        pathButton.setVisible(false);

        p.setLayout(null);

        // add buttons to the frame
        p.add(processButton);
        p.add(openButton);
        p.add(cancelButton);
        p.add(pathButton);

        // add panel to the frame
        p.add(l);
        p.add(auxL);
        p.add(infoProcess);
        infoProcess.setVisible(false);
        f.add(p);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void openAction() {
        l.setFont(new Font(FONT, Font.PLAIN, 28));
        // create an object of JFileChooser class
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("VENSIM FILES", "mdl");
        j.setFileFilter(filter);

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            // set the label to the path of the selected file
            l.setFont(new Font(FONT, Font.PLAIN, 28));
            if (j.getSelectedFile().getAbsolutePath().contains(".mdl")) {
                filePath = j.getSelectedFile().getAbsolutePath();
                if (checkFile(filePath)) {
                    String path[] = j.getSelectedFile().getAbsolutePath().split("\\\\");
                    shortPath = path[path.length - 1];
                    l.setForeground(Color.black);
                    l.setText(path[path.length - 1]);
                    auxL.setText("");
                    openButton.setVisible(false);
                    processButton.setVisible(true);
                    cancelButton.setVisible(true);
                    pathButton.setVisible(true);
                    infoProcess.setVisible(true);
                } else {
                    l.setForeground(Color.red);
                    l.setText("Vensim file is not valid.");
                    auxL.setText("");
                }
            } else {
                l.setForeground(Color.red);
                l.setText("File selected is not a Vensim file.");
                auxL.setText("");
            }
        }
        // if the user cancelled the operation
        else {
            l.setForeground(Color.red);
            l.setText("The user cancelled the operation");
            auxL.setText("");
        }
    }

    public void processAction() {
        if (checkFile(filePath)) {
            l.setFont(new Font(FONT, Font.PLAIN, 28));
            String[] arg = new String[2];
            arg[0] = filePath;
            controller.processFile(arg);
            Color greenColor = new Color(26, 110, 16);
            l.setForeground(greenColor);
            l.setText("Operation successful.");
            auxL.setText("");

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                        l.setText(shortPath);
                        l.setFont(new Font(FONT, Font.PLAIN, 28));
                        l.setForeground(Color.black);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                    return;
                }
            });

        } else {
            l.setForeground(Color.red);
            l.setText("Vensim file is not valid.");
            auxL.setText("");
        }
    }

    public void cancelAction() {
        l.setFont(new Font(FONT, Font.PLAIN, 28));
        l.setForeground(Color.black);
        l.setText("No file selected.");
        auxL.setText("");
        absolutePathState = false;
        processButton.setVisible(false);
        cancelButton.setVisible(false);
        pathButton.setVisible(false);
        openButton.setVisible(true);
        infoProcess.setVisible(false);
    }

    public void pathAction() {
        l.setForeground(Color.black);
        if (!absolutePathState) {
            l.setFont(new Font(FONT, Font.PLAIN, 12));
            pathButton.setText("Show name without name");
            if (filePath.length() > 70) {
                String part1 = filePath.substring(0, 70);
                String part2 = filePath.substring(70, filePath.length());
                l.setText(part1);
                auxL.setText(part2);
            } else {
                l.setText(filePath);
                auxL.setText("");
            }
            absolutePathState = true;
        } else {
            l.setFont(new Font(FONT, Font.PLAIN, 28));
            pathButton.setText("Show absolute path");
            l.setText(shortPath);
            auxL.setText("");
            absolutePathState = false;
        }
    }

    public void actionPerformed(ActionEvent evt) {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();
        controller.checkAction(com);
    }
}
