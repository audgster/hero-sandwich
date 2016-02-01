package models.MovementEngine;

import models.Entity;
import util.Direction;

public interface IMovementEngine
{
    boolean executeMovement(Entity entity, Direction direction);
}
