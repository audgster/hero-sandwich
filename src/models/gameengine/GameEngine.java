package models.gameengine;

import models.entities.Entity;
import models.Level;
import models.map.Tile;
import models.map.interactions.interfaces.ITileInteractionDirector;
import models.map.movementengine.interfaces.IMovementDirector;
import models.gameengine.interfaces.IGameEngine;
import util.Direction;
import util.Position;

public class GameEngine implements IGameEngine
{
    private IMovementDirector movementDirector;
    private ITileInteractionDirector tileInteractionDirector;
    //private ILevelInteractionDirector levelInteractionDeveloper

    public GameEngine (IMovementDirector movementDirector, ITileInteractionDirector interactionDirector)
    {
        this.movementDirector = movementDirector;
        this.tileInteractionDirector = interactionDirector;
    }

    @Override
    public boolean changeEntityLocation(Level level, Entity entity, Direction direction)
    {
        Position currentPosition = level.returnCurrentPosition(entity);
        Position destinationPosition = movementDirector.getPositionAfterMovement(level, entity, direction);

        entity.setEntityDirection(direction);

        if (currentPosition.equals(destinationPosition))
            return false;

        Tile destinationTile = movementDirector.executeMovement(entity, destinationPosition, level);
        //trigger any level interactions

        System.out.println("[GAMEENGINE] Triggering tile interactions");
        return triggerInteraction(destinationTile, entity);
    }

    private boolean triggerInteraction(Tile tile, Entity entity)
    {
        if (!(tileInteractionDirector == null))
            return tileInteractionDirector.executeInteraction(tile, entity);
        return false;
    }

    private boolean triggerLevelInteraction(Level level, Entity entity)
    {
        return false;
    }
}
