package initialization;


import models.entities.Entity;

import java.util.List;

public class Game {
    private List<Level> levels;
    //private Entity avatar;

    public Game() {}

    public Game(List<Level> levels, Entity avatar) {
        this.levels = levels;
        //this.avatar = avatar;
    }

    public void newGame() {
        GameFacade gameCreator = new GameFacade();
        gameCreator.createNewGame(this);
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
