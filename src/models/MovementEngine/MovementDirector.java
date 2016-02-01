package models.MovementEngine;

import models.Entity;
import models.Level;
import models.MovementEngine.Interfaces.IMovementDirector;
import util.Direction;

public class MovementDirector implements IMovementDirector
{
    @Override
    public boolean executeMovement(Level level, Entity entity, Direction direction) {
        return false;
    }
}
