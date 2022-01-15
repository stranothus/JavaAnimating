package Objects;

public class Block extends Object {
    public Block(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    private Boolean colliding(Player p) {
        return p.x < x + w && p.x + p.w > x && p.y < y + h && p.y +p.h > y;
    }

    public void applyCollisions(Player p) {
        if(colliding(p)) {
            p.x -= p.speed;

            if(colliding(p)) {
                if(p.gravity > 0) {
                    p.y = y - p.h;
                    p.gravity = 0;
                    p.canJump = true;
                } else {
                    p.y = y + h;
                    p.gravity = 1;
                }
            }
            
            p.x += p.speed;
            p.y -= p.gravity;

            if(colliding(p)) {
                if(p.speed > 0) {
                    p.x = x - p.w;
                } else {
                    p.x = x + w;
                }
                
                p.speed = 0;
            }

            p.y += p.gravity;
        }
    }
}