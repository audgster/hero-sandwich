package models.gameengine;

import models.entities.Entity;
import models.Level;
import models.map.interactions.interfaces.ITileInteractionDirector;
import models.map.movementengine.interfaces.IMovementDirector;
import models.gameengine.interfaces.IGameEngine;
import util.Direction;

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
        if (movementDirector.verifyEntityCanMove(level, entity, direction))
            if(movementDirector.executeMovement(level, entity, direction))
                return triggerInteraction(level, entity, direction);
        return false;
    }

    private boolean triggerInteraction(Level level, Entity entity, Direction direction) {return false;};
}
