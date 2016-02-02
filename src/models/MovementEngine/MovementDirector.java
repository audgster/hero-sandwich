package models.movementengine;

import models.entities.Entity;
import models.Level;
import models.movementengine.interfaces.IMovementDirector;
import util.Direction;

public class MovementDirector implements IMovementDirector
{
    @Override
    public boolean executeMovement(Level level, Entity entity, Direction direction) {
        return false;
    }
}
