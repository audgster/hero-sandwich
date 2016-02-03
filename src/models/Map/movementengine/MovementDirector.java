package models.map.movementengine;

import models.entities.Entity;
import models.Level;
import models.map.movementengine.interfaces.IMovementDirector;
import models.map.movementengine.interfaces.IMovementRulesEngine;
import util.Direction;

public class MovementDirector implements IMovementDirector
{
    private IMovementRulesEngine rulesEngine;

    public MovementDirector(IMovementRulesEngine rulesEngine)
    {
        this.rulesEngine = rulesEngine;
    }

    /*
    * in: Level, Entity, Direction
    * * * level affected, entity moved, direction moved int
    * out: Boolean
    * * * was movement successful
    * Updates location and triggers interactions
    * */
    @Override
    public boolean executeMovement(Level level, Entity entity, Direction direction) {
        return false;
    }

    /*
    * in: Level, Entity, Direction
    * * * level affected, entity moved, direction moved int
    * out: Boolean
    * * * was movement successful
    * Forwards information to rules engine to check if movement is possible
    * */
    @Override
    public boolean verifyEntityCanMove(Level level, Entity entity, Direction direction) {
        return false;
    }
}
