package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // call some methods

        // print invalid command in the beginning, update more about command in the future.
        System.out.println("invalid command");
    }
}
