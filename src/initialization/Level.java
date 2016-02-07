package initialization;

import models.map.Map;

public class Level {
    private Map map;
    private int levelNumber;

    public Level(int levelNumber, Map map) {
        this.map = map;
        this.levelNumber = levelNumber;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Map getMap() {
        return map;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String toString() {
        return " " + levelNumber + "\n" + map.toString();
    }
}
