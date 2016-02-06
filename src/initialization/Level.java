package initialization;

public class Level {
    private TestMap map;
    private int levelNumber;

    public Level(int levelNumber, TestMap map) {
        this.map = map;
        this.levelNumber = levelNumber;
    }

    public void setMap(TestMap map) {
        this.map = map;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public TestMap getMap() {
        return map;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String toString() {
        return " " + levelNumber + "\n" + map.toString();
    }
}
