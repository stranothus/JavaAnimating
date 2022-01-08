import java.awt.*;

// called on a JFrame to display graphics
public class DisplayGraphics extends Canvas {
    static long frameCount = 0;
    static int playerX = 200;

    public void paint(Graphics g) {
        double widthRatio = JFrameSize.widthRatio;
        double heightRatio = JFrameSize.heightRatio;
        // some basic graphics placed using the width and height ratios so resizing doesn't ruin them
        Font Impact = new Font("Impact", Font.PLAIN, 50);
        FontMetrics metrics = g.getFontMetrics(Impact);
        String toDraw = "Hello, World!";
        int textX = (int)(200 * widthRatio) - metrics.stringWidth(toDraw) / 2;
        g.setFont(Impact); 
        g.drawString(toDraw, textX, (int)(200 * heightRatio));
        
        if(MyMouseEvents.mouseIn) {
            setBackground(new Color(255, 0, 0));
        } else {
            setBackground(new Color(255, 255, 255));
        }
        setForeground(new Color(0, 0, 0));

        g.fillOval((int)(200 * widthRatio - 12.5), (int)(200 * heightRatio + 12.5 + Math.sin(frameCount / 5) * 5), 25, 25);
        g.fillOval((int)(200 * widthRatio - 62.5), (int)(200 * heightRatio + 12.5 + Math.sin(frameCount / 5 + 33) * 5), 25, 25);
        g.fillOval((int)(200 * widthRatio + 37.5), (int)(200 * heightRatio + 12.5 + Math.sin(frameCount / 5 + 0.67) * 5), 25, 25);

        g.fillRect((int)(playerX * widthRatio - 10), (int)(75 * heightRatio), 20, 20);

        update();
    }

    public static void update() {
        // increment the frame count
        frameCount++;

        if(MyKeyEvents.keys[65] == true) {
            playerX--;
        }
        if(MyKeyEvents.keys[68] == true) {
            playerX++;
        }
    }
}