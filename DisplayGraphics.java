import java.awt.*;

// called on a JFrame to display graphics
public class DisplayGraphics extends Canvas {
    static double widthRatio = 1;
    static double heightRatio = 1;
    static long frameCount = 0;

    public void paint(Graphics g) {
        // some basic graphics placed using the width and height ratios to resizing doesn't ruin them
        g.drawString("Hello", (int)(40 * widthRatio + frameCount), (int)(40 * heightRatio));
        setBackground(Color.WHITE);
        g.fillRect((int)(130 * widthRatio), (int)(30 * heightRatio), (int)(100 * widthRatio), (int)(80 * heightRatio));
        g.drawOval((int)(30 * widthRatio), (int)(130 * heightRatio), (int)(50 * widthRatio), (int)(60 * heightRatio));
        setForeground(Color.RED);
        g.fillOval((int)(130 * widthRatio), (int)(130 * heightRatio), (int)(50 * widthRatio), (int)(60 * heightRatio));
        g.drawArc((int)(30 * widthRatio), (int)(200 * heightRatio), (int)(40 * widthRatio), (int)(50 * heightRatio), 90, 60);
        g.fillArc((int)(30 * widthRatio), (int)(130 * heightRatio), (int)(40 * widthRatio), (int)(50 * heightRatio), 180, 40);

        // increment the frame count
        frameCount++;
    }
}