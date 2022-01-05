import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static JFrame f = new JFrameConstructor().init();
    static DisplayGraphics m = new DisplayGraphics();
    static double widthRatio = 1;
    static double heightRatio = 1;

    public static void draw() {
        f.add(m);
    }

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

    public void startDrawFunction(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new DrawFunction(), seconds, seconds);
	}

    class DrawFunction extends TimerTask {
        public void run() {
            f.revalidate();
            f.remove(m);
            f.add(m);
        }
    }

    public static void main(String[] args) {
        Main This = new Main();

        draw();
        handleResize();
        This.startDrawFunction(100);
    }
}