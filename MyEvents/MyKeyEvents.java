package MyEvents;

import java.awt.event.*;
import javax.swing.JComponent;

public class MyKeyEvents extends JComponent implements KeyListener {
    static Boolean[] keys = new Boolean[255];
    static {
        for(int i = 0; i < 255; i++) {
            keys[i] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public Boolean[] getKeys() {
        return keys;
    }
}