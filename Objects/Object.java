package Objects;
import java.awt.*;

import Utils.JFrameSize;

public class Object {
    static JFrameSize masteJFrameSize = new JFrameSize();
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    Color color = new Color(0, 0, 0);

    public Object(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void display(Graphics g) {
        double widthRatio = masteJFrameSize.getWidth();
        double heightRatio = masteJFrameSize.getHeight();

        g.setColor(color);
        g.fillRect((int)(x * widthRatio - 10), (int)(y * heightRatio), w, h);
    }
}