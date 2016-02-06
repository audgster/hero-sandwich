package util;

import models.Level;
import models.entities.Entity;
import models.gameengine.interfaces.IGameEngine;

public class Game
{
    public Level currentLevel;
    Level[] levels;
    public Entity avatar;
    public IGameEngine gameEngine;
}
