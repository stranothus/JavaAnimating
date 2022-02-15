package Objects;

public class Block extends GameObject {
    public Block(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void applyCollisions(Player p) {
        if(p.x < x + w && p.x + p.w > x && p.y < y + h && p.y + p.h > y) {
            if(p.pastX < x + w && p.pastX + p.w > x && p.y < y + h && p.y + p.h > y) {
                if(p.gravity > 0) {
                    p.y = y - p.h;
                    p.gravity = 0;
                    p.canJump = true;
                } else {
                    p.y = y + h;
                    p.gravity = 1;
                }
            }

            if(p.x < x + w && p.x + p.w > x && p.pastY < y + h && p.pastY + p.h > y) {
                if(p.speed > 0) {
                    p.x = x - p.w;
                } else if(p.speed < 0) {
                    p.x = x + w;
                }
                
                p.speed = 0;
            }
        }
    }
}