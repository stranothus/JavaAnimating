// get some imports
import java.awt.*;
import javax.swing.JFrame;

import MyEvents.MyKeyEvents;
import MyEvents.MyMouseEvents;
import Utils.JFrameConstructor;
import Utils.JFrameSize;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    // new instances of JFrame and DisplayGraphics
    static JFrame f = new JFrameConstructor().init();
    static DisplayGraphics m = new DisplayGraphics();
    static JFrameSize masteJFrameSize = new JFrameSize();
    // default size is 400-400, these are the difference from that

    // handle resize by recalculating width and height ratios and redrawing the image
    public static void handleResize() {
        f.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent evt) {
                Component c = (Component)evt.getSource();

                masteJFrameSize.setWidth((double)c.getWidth() / 400);
                masteJFrameSize.setHeight((double)c.getHeight() / 400);

                f.revalidate();
                f.repaint();
            }
        });
    }

    // set up a new timer and loop a new instance of DrawFunction inside
    public void startDrawFunction(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new DrawFunction(), seconds, seconds);
	}

    // create a DrawFunction which will repaint the JFrame each iteration
    class DrawFunction extends TimerTask {
        public void run() {
            f.revalidate();
            f.remove(m);
            f.add(m);
        }
    }

    // start the program
    public static void main(String[] args) {
        Main This = new Main(); // new instance of this
        MyMouseEvents mouseEvents = new MyMouseEvents(); // new instance of mouse events
        MyKeyEvents keyEvents = new MyKeyEvents(); // new instance of mouse events

        f.setFocusable(true);
        f.add(m); // initial drawing
        handleResize(); // set up the resize handler
        This.startDrawFunction(1000 / 60); // start the loop
        f.addMouseListener(mouseEvents);
        f.addKeyListener(keyEvents);
    }
}