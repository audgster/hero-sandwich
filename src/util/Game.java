package util;

import initialization.AvatarCreator;
import initialization.GameFacade;
import initialization.GameLoader;
import models.Level;
import models.entities.Entity;
import models.entities.Smasher;
import models.gameengine.interfaces.IGameEngine;
import models.gameengine.interfaces.IGameEngineInitializer;
import models.map.Map;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    private int currentLevel;
    List<Level> levels;
    private Entity avatar;
    private IGameEngine gameEngine;
    private Position startPosition = new Position(5,5);

    public Game(IGameEngineInitializer initializer) {
        this.gameEngine = initializer.initialize();
        levels = new ArrayList<>();
        avatar =  new Entity();
        //avatar.getSaveState();
        currentLevel = -1;
    }

    public Game(List<Level> levels, Entity avatar)
    {
        this.levels = levels;
        initializeAvatar(avatar);
    }

    public void newGame() {
        GameFacade gameCreator = new GameFacade();
        gameCreator.createNewGame(this);
        currentLevel = 1;
        Map map = levels.get(currentLevel-1).getMap();
        //map.printMap();
        //map.printAoes();
        //map.printItems();
    }

    public void loadGame() {
        GameLoader gameLoader = new GameLoader(new File("initialization/saveFile.txt"));
        this.avatar = gameLoader.parseFile();
        GameFacade gameCreator = new GameFacade();
        gameCreator.createNewGame(this);
        currentLevel = 1;
    }

    public void saveGame() {
        AvatarCreator ac = new AvatarCreator();
        ac.setName("Brandon");
        ac.setOccupation(new Smasher());
        Entity avatar = ac.vendCustomEntity();
        avatar.gainXp(67);
        avatar.loseLife();
        avatar.loseLife();
        List<String> state = avatar.getSaveState();
        //You wrote some stuff in Map for state gathering... go finish it


        try {
            PrintWriter writer = new PrintWriter(new File("initialization/saveFile.txt"));
           for(String val : state) {
                writer.print(val);
            }
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
        return levels.get(currentLevel-1);
    }

    public Entity getAvatar()
    {
        return avatar;
    }

    public IGameEngine getGameEngine()
    {
        return gameEngine;
    }

    public Level getLevel(){
        return levels.get(currentLevel-1);
    }

    public void initializeAvatar(Entity avatar){
        this.avatar = avatar;
        getCurrentLevel().addEntity(avatar, startPosition);
    }
}
