package initialization;

import models.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class GameFacade {
    public GameFacade(){}

    public void createNewGame(Game game) {
        LevelCreator levelCreator = new LevelCreator();
        Level level = levelCreator.createLevel();
        List<Level> levels = new ArrayList<Level>();
        levels.add(level);
        game.setLevels(levels);
        //game.setAvatar(new Entity());
    }

    public Game loadGame() {
        //TODO
        return null;
    }

    public void saveGame() {
        //TODO
    }
}
