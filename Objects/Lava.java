package Objects;

public class Lava extends Object {
    public Lava(int x, int y, int w, int h) {
        super(x, y, w, h);
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