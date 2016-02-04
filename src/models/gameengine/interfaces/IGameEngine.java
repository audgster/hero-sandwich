package models.gameengine.interfaces;

import models.entities.Entity;
import models.Level;
import util.Direction;

public interface IGameEngine
{
    boolean changeEntityLocation(Level level, Entity entity, Direction direction);
}
