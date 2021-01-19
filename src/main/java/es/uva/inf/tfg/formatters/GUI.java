package es.uva.inf.tfg.formatters;

// Java program to create open or 
// save dialog using JFileChooser 
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class GUI extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Jlabel to show the files user selects 
    static JLabel l;

    private String filePath;

    // a default constructor 
    GUI() {
        filePath = "";
    }

    public static void main(String args[]) {
        // frame to contains GUI elements 
        JFrame f = new JFrame("Delimiter eraser");

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
        GUI f1 = new GUI();

        // add action listener to the button to capture user 
        // response on buttons 
        processButton.addActionListener(f1);
        openButton.addActionListener(f1);

        // make a panel to add the buttons and labels 
        JPanel p = new JPanel();
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
            String[] arg = new String[2];
            arg[0] = filePath;
            arg[1] = filePath + "GUI";
            NoDelimiters.main(arg);
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
                String path[] = j.getSelectedFile().getAbsolutePath().split("\\\\");
                l.setText(path[path.length - 1]);
                filePath = j.getSelectedFile().getAbsolutePath();
            }
            // if the user cancelled the operation 
            else
                l.setText("The user cancelled the operation");
        }
    }
}
