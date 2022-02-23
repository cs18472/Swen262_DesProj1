package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class CLI extends JFrame {

    public CLI() {
        JFrame frame = new JFrame();

        frame.setSize(200, 200);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Muze Music Library");
        frame.setLayout(new GridLayout(3, 1, 0, 3));
         
        JTextArea logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setBorder(new LineBorder(Color.BLACK));

        JTextArea responseTextArea = new JTextArea();
        responseTextArea.setEditable(false);
        responseTextArea.setBorder(new LineBorder(Color.BLACK));

        JTextField commandLine = new JTextField();
        commandLine.setVisible(true);
        commandLine.setLayout(null);
        commandLine.setSize(800, 50);
        commandLine.setBorder(new LineBorder(Color.BLACK));

        commandLine.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                  String command = commandLine.getText();
                  commandLine.setText("");
                  logTextArea.setText(command);


                  if(command.equals("help")) {
                      responseTextArea.setText("type in the lowest box, and the enter key to enter query");
                  }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
        }); 


        frame.add(logTextArea);
        frame.add(responseTextArea);
        frame.add(commandLine);


        frame.setVisible(true);        
    }

    public static void main(String[] args) {
        new CLI();
    }
}
