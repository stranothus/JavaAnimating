package Objects;
import MyEvents.MyKeyEvents;
import java.awt.*;
import Utils.JFrameSize;

public class Player extends GameObject {
    static JFrameSize masterJFrameSize = new JFrameSize();
    int gravity = 0;
    int speed = 0;
    int jumpHeight = 15;
    int originalX;
    int originalY;
    int pastX = 0;
    int pastY = 0;
    Boolean canJump = false;
    MyKeyEvents keyMaster = new MyKeyEvents();
    Color color = new Color(0, 0, 255);

    public Player(int x, int y, int w, int h) {
        super(x, y, w, h);

        originalX = x;
        originalY = y;
    }

    public void display(Graphics g) {
        double widthRatio = masterJFrameSize.getWidth();
        double heightRatio = masterJFrameSize.getHeight();

        g.setColor(color);
        g.fillRect((int)(x * widthRatio - 10), (int)(y * heightRatio), w, h);
    }

    public void update() {
        Boolean[] keys = keyMaster.getKeys();
        
        speed = 0;
        gravity += 1;

        if(keys[65]) {
            speed -= 3;
        }
        if(keys[68]) {
            speed += 3;
        }

        if(keys[32] && canJump) {
            gravity -= jumpHeight;
            canJump = false;
        }

        pastY = y;
        pastX = x;
        y += gravity;
        x += speed;
    }

    public void die() {
        x = originalX;
        y = originalY;
        gravity = 0;
        speed = 0;
        canJump = false;
    }
}