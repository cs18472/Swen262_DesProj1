package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CLI{

    public CLI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(200, 200);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Muze Music Library");

        panel.setLayout(null);
        JLabel title = new JLabel();
        title.setLayout(null);
        title.setText("Muze Music Library");
        panel.add(title);
        
        JTextField commandLine = new JTextField();
        commandLine.setVisible(true);
        commandLine.setLayout(null);
        commandLine.setSize(800, 50);

        frame.add(commandLine, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CLI();
    }
}
