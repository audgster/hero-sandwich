package models.map.movementengine;

import models.entities.Entity;
import models.Level;
import models.items.Item;
import models.map.Tile;
import models.map.movementengine.interfaces.IMovementDirector;
import models.map.movementengine.interfaces.IMovementRulesEngine;
import util.Direction;
import util.Position;

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
    public Tile executeMovement(Entity entity, Position destinationPosition, Level level)
    {
        return level.updatePosition(entity, destinationPosition);
    }

    /*
    * in: Level, Entity, Direction
    * * * level affected, entity moved, direction moved int
    * out: Boolean
    * * * was movement successful
    * Forwards information to rules engine to check if movement is possible
    * */
    @Override
    public Position getPositionAfterMovement(Level level, Entity entity, Direction direction)
    {
        Position currentEntityPosition = level.returnCurrentPosition(entity);
        Position destinationPosition = currentEntityPosition.incrementPosition(direction);

        if(level.isValidLocation(destinationPosition)) {

            Tile tileAtDestination = level.returnTileAt(destinationPosition);

            boolean allowMovement = true;

            for (Item i : tileAtDestination.getAllItems())
            {
                allowMovement = allowMovement && i.allowMovement();
            }

            if (rulesEngine.evaluateRule(tileAtDestination, entity) && allowMovement)
                return destinationPosition;
        }

        return currentEntityPosition;
    }
}
