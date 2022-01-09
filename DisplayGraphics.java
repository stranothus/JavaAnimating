import java.awt.*;

// called on a JFrame to display graphics
public class DisplayGraphics extends Canvas {
    long frameCount = 0;
    Player player;
    String[] level = {
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        "                    ",
        " #                # ",
        " #                # ",
        " ################## ",
        "                    "
    };
    LevelConstructor levelConstructor = new LevelConstructor(level);
    Block[] blocks = levelConstructor.generate();

    public DisplayGraphics() {
        player = new Player(190, 275, 20, 20);
    }

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
        
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(0, 0, 0));

        g.fillOval((int)(200 * widthRatio - 12.5), (int)(200 * heightRatio + 12.5 + Math.sin(frameCount / 5) * 5), 25, 25);
        g.fillOval((int)(200 * widthRatio - 62.5), (int)(200 * heightRatio + 12.5 + Math.sin(frameCount / 5 + 33) * 5), 25, 25);
        g.fillOval((int)(200 * widthRatio + 37.5), (int)(200 * heightRatio + 12.5 + Math.sin(frameCount / 5 + 0.67) * 5), 25, 25);

        player.update();

        for(int i = 0; i < blocks.length; i++) {
            if(blocks[i] == null) continue;

            blocks[i].display(g);
            blocks[i].applyCollisions(player);
        }

        player.display(g);

        update();
    }

    public void update() {
        // increment the frame count
        frameCount++;
    }
}