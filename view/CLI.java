package view;

import java.awt.*;
import javax.swing.*;

public class CLI extends JFrame {

    private Listener key;

    public CLI() {
        JFrame frame = new JFrame();

        frame.setSize(200, 200);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Muze Music Library");

        
        JTextField commandLine = new JTextField();
        commandLine.setVisible(true);
        commandLine.setLayout(null);
        commandLine.setSize(800, 50);
        commandLine.addKeyListener( key );

        frame.add(commandLine, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CLI();
    }
}
