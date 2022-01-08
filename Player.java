import java.awt.*;

public class Player {
    int x = 0;
    int y = 0;
    int w = 0;
    int h = 0;
    int gravity = 0;
    int speed = 3;
    int jumpHeight = 15;
    Boolean canJump = false;

    public Player(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void update() {
        Boolean[] keys = MyKeyEvents.keys;

        gravity += 1;

        if(keys[65]) {
            x -= speed;
        }
        if(keys[68]) {
            x += speed;
        }

        if(keys[32] && canJump) {
            gravity -= jumpHeight;
            canJump = false;
        }

        y += gravity;

        if(y > 275) {
            y = 275; 
            gravity = 0;
            canJump = true;
        }
    }

    public void display(Graphics g) {
        double widthRatio = JFrameSize.widthRatio;
        double heightRatio = JFrameSize.heightRatio;

        g.fillRect((int)(x * widthRatio - 10), (int)(y * heightRatio), w, h);
    }
}