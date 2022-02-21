public class ManageLevels {
    int level = 0;
    LevelConstructor[] levels;

    public ManageLevels(String[][] levelMaps) {
        levels = new LevelConstructor[levelMaps.length];

        for(int i = 0; i < levelMaps.length; i++) {
            levels[i] = new LevelConstructor(levelMaps[i]);
        }
    }

    public LevelConstructor currentLevel() {
        return levels[level];
    }

    public void changeLevel(int newLevel) {
        level = newLevel;
    }

    public void nextLevel() {
        level++;
    }
}