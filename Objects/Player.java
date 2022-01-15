package Objects;
import MyEvents.MyKeyEvents;

public class Player extends Object {
    int gravity = 0;
    int speed = 0;
    int jumpHeight = 15;
    Boolean canJump = false;
    MyKeyEvents keyMaster = new MyKeyEvents();

    public Player(int x, int y, int w, int h) {
        super(x, y, w, h);
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

        y += gravity;
        x += speed;
    }
}