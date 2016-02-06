package initialization;


import models.entities.Entity;
import models.map.Map;

import java.util.List;

public class Game {
    private List<Level> levels;
    //private Entity avatar;
    private int levelNumber;

    public Game() {}

    public Game(List<Level> levels, Entity avatar) {
        this.levels = levels;
        //this.avatar = avatar;
    }

    public void newGame() {
        GameFacade gameCreator = new GameFacade();
        gameCreator.createNewGame(this);
        levelNumber = 1;
        Map map = levels.get(levelNumber-1).getMap();
        map.printMap();
    }

    public void loadGame() {

    }

    public void saveGame() {

    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void setAvatar(Entity avatar) {
        //this.avatar = avatar;
    }

    public void printLevel() {
        System.out.println(levels.get(0));
    }
}
