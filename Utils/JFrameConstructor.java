package Utils;
import javax.swing.JFrame;

// create and return a new JFrame
public class JFrameConstructor {
    public JFrame init() {
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setResizable(true);
        f.setTitle("Java Graphic");
        f.setVisible(true);

        return f;
    }
}