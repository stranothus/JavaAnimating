import Objects.Block;
import Objects.Player;

public class LevelConstructor {
    String[] map;
    Block[] blocks;
    Player player;

    public LevelConstructor(String[] map) {
        this.map = map;
    }

    public Boolean generate() {
        int length = 0;
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length(); x++) {
                Character c = map[y].charAt(x);

                switch(c) {
                    case '#':
                        length++;
                    break;
                }
            }
        }
        blocks = new Block[length];

        int index = 0;
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length(); x++) {
                Character c = map[y].charAt(x);

                switch(c) {
                    case '#':
                        blocks[index] = new Block(x * 20, y * 20, 20, 20);
                        index++;
                    break;
                    case 'x':
                        player = new Player(x * 20, y * 20, 20, 20);
                    break;
                }
            }
        }

        return player != null;
    }
}