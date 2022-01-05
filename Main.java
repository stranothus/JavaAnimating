// get some imports
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    // new instances of JFrame and DisplayGraphics
    static JFrame f = new JFrameConstructor().init();
    static DisplayGraphics m = new DisplayGraphics();
    // default size is 400-400, these are the difference from that
    static double widthRatio = 1;
    static double heightRatio = 1;

    // handle resize by recalculating width and height ratios and redrawing the image
    public static void handleResize() {
        f.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent evt) {
                Component c = (Component)evt.getSource();

                widthRatio = (double)c.getWidth() / 400;
                heightRatio = (double)c.getHeight() / 400;

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

        f.add(m); // initial drawing
        handleResize(); // set up the resize handler
        This.startDrawFunction(100); // start the loop
    }
}