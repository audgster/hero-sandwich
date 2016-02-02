package models.MovementEngine.Interfaces;

import models.Entity.Entity;
import models.Level;
import util.Direction;

public interface IMovementEngine
{
    boolean executeMovement(Level level, Entity entity, Direction direction);
}
