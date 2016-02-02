package models.movementengine;

import models.entities.Entity;
import models.Level;
import models.movementengine.interfaces.IMovementDirector;
import models.movementengine.interfaces.IMovementEngine;
import util.Direction;

public class MovementEngine implements IMovementEngine
{
    IMovementDirector movementDirector;

    @Override
    public boolean executeMovement(Level level, Entity entity, Direction direction) {
        return false;
    }
}
