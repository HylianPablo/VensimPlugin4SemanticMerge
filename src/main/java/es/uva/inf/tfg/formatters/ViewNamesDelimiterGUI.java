package es.uva.inf.tfg.formatters;

// Java program to create open or 
// save dialog using JFileChooser 
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.filechooser.*;

public class ViewNamesDelimiterGUI extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Jlabel to show the files user selects 
    static JLabel l;

    private String filePath;

    // a default constructor 
    ViewNamesDelimiterGUI() {
        filePath = "";
    }

    public static void main(String args[]) {
        // frame to contains GUI elements 
        JFrame f = new JFrame("Views and delimiter addition");

        // set the size of the frame 
        f.setSize(400, 400);

        // set the frame's visibility 
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // button to open save dialog 
        JButton processButton = new JButton("Process");

        // button to open open dialog 
        JButton openButton = new JButton("Open file");

        // make an object of the class filechooser 
        ViewNamesDelimiterGUI f1 = new ViewNamesDelimiterGUI();

        // add action listener to the button to capture user 
        // response on buttons 
        processButton.addActionListener(f1);
        openButton.addActionListener(f1);

        // make a panel to add the buttons and labels 
        JPanel p = new JPanel();
        Color panelColor = new Color(224, 227, 152);
        p.setBackground(panelColor);
        //p.setLayout(null);

        // set the label to its initial value 
        l = new JLabel("no file selected", SwingConstants.CENTER);
        Dimension size = l.getPreferredSize();
        l.setBounds(50, 80, 300, size.height);

        processButton.setBounds(90, 170, 90, 50);
        openButton.setBounds(220, 170, 90, 50);
        p.setLayout(null);

        // add buttons to the frame 
        p.add(processButton);
        p.add(openButton);

        // add panel to the frame 
        p.add(l);
        f.add(p);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        // if the user presses the save button show the save dialog 
        String com = evt.getActionCommand();

        if (com.equals("Process")) {
            if (!filePath.equals("")) {
                String[] arg = new String[2];
                arg[0] = filePath;
                ComDel.main(arg);
                l.setForeground(Color.green);
                l.setText("Operation successful.");
            } else {
                l.setForeground(Color.red);
                l.setText("Please, select a file.");
            }
        }

        // if the user presses the open dialog show the open dialog 
        else {
            // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsOpenDialog function to show the save dialog 
            int r = j.showOpenDialog(null);

            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION)

            {
                // set the label to the path of the selected file
                if (j.getSelectedFile().getAbsolutePath().contains(".mdl")) {
                    String path[] = j.getSelectedFile().getAbsolutePath().split("\\\\");
                    l.setForeground(Color.black);
                    l.setText(path[path.length - 1]);
                    filePath = j.getSelectedFile().getAbsolutePath();
                } else {
                    l.setForeground(Color.red);
                    l.setText("File selected is not a Vensim file.");
                }
            }
            // if the user cancelled the operation 
            else {
                l.setForeground(Color.red);
                l.setText("The user cancelled the operation");
            }
        }
    }
}
