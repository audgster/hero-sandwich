package util;

import initialization.GameFacade;
import models.Level;
import models.entities.Entity;
import models.gameengine.interfaces.IGameEngine;
import models.gameengine.interfaces.IGameEngineInitializer;
import models.map.Map;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private int currentLevel;
    List<Level> levels;
    private Entity avatar;
    private IGameEngine gameEngine;

    public Game(IGameEngineInitializer initializer) {
        this.gameEngine = initializer.initialize();
        levels = new ArrayList<>();
        avatar = null;
        currentLevel = -1;
    }

    public Game(List<Level> levels, Entity avatar)
    {
        this.levels = levels;
        this.avatar = avatar;
    }

    public void newGame() {
        GameFacade gameCreator = new GameFacade();
        gameCreator.createNewGame(this);
        currentLevel = 1;
        Map map = levels.get(currentLevel-1).getMap();
        map.printMap();
        map.printAoes();
        map.printItems();
    }

    public void loadGame() {

    }

    public void saveGame() {

    }

    public void setLevels(List<Level> levels)
    {
        this.levels = levels;
    }

    public void setAvatar(Entity avatar)
    {
        this.avatar = avatar;
    }

    public void printCurrentLevel()
    {
        System.out.println(getCurrentLevel());
    }

    public Level getCurrentLevel()
    {
        return levels.get(currentLevel);
    }

    public Entity getAvatar()
    {
        return avatar;
    }

    public IGameEngine getGameEngine()
    {
        return gameEngine;
    }
}
