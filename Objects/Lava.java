package Objects;
import java.awt.*;
import Utils.JFrameSize;

public class Lava extends GameObject {
    static JFrameSize masterJFrameSize = new JFrameSize();
    Color color = new Color(255, 0, 0);

    public Lava(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void display(Graphics g) {
        double widthRatio = masterJFrameSize.getWidth();
        double heightRatio = masterJFrameSize.getHeight();

        g.setColor(color);
        g.fillRect((int)(x * widthRatio - 10), (int)(y * heightRatio), w, h);
    }

    private Boolean colliding(Player p) {
        return p.x < x + w && p.x + p.w > x && p.y < y + h && p.y +p.h > y;
    }

    public void applyCollisions(Player p) {
        if(colliding(p)) {
            p.die();
        }
    }
}