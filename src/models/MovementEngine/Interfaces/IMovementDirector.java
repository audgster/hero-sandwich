package models.MovementEngine.Interfaces;

import models.entities.Entity;
import models.Level;
import util.Direction;

public interface IMovementDirector
{
    boolean executeMovement(Level level, Entity entity, Direction direction);
}
