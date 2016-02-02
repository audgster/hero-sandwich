package models.MovementEngine;

import models.entities.Entity;
import models.Level;
import models.MovementEngine.Interfaces.IMovementDirector;
import models.MovementEngine.Interfaces.IMovementEngine;
import util.Direction;

public class MovementEngine implements IMovementEngine
{
    IMovementDirector movementDirector;

    @Override
    public boolean executeMovement(Level level, Entity entity, Direction direction) {
        return false;
    }
}
