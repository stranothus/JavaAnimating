import java.awt.*;

// called on a JFrame to display graphics
public class DisplayGraphics extends Canvas {
    static long frameCount = 0;

    public void paint(Graphics g) {
        double widthRatio = JFrameSize.widthRatio;
        double heightRatio = JFrameSize.heightRatio;
        // some basic graphics placed using the width and height ratios so resizing doesn't ruin them
        g.setFont(new Font("TimesRoman", Font.PLAIN, (int)frameCount)); 
        g.drawString("Hello", (int)(40 * widthRatio), (int)(40 * heightRatio));

        // increment the frame count
        frameCount++;
    }
}