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
    private ITileInteractionDirector interactionDirector;

    public GameEngine (IMovementDirector movementDirector, ITileInteractionDirector interactionDirector)
    {
        this.movementDirector = movementDirector;
        this.interactionDirector = interactionDirector;
    }

    @Override
    public boolean changeEntityLocation(Level level, Entity entity, Direction direction)
    {
        Position destinationPosition = movementDirector.getPositionAfterMovement(level, entity, direction);
        Tile destinationTile = movementDirector.executeMovement(entity, destinationPosition, level);
        return triggerInteraction(destinationTile, entity);
    }

    private boolean triggerInteraction(Tile tile, Entity entity) {
        //kick off tile Interaction Director
        return false;
    }
}
