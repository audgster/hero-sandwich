package models.Map.Interactions;

import models.Entity.Entity;
import models.Map.Interactions.Interfaces.IInteractionHandler;
import models.Map.Interactions.Interfaces.ITileInteractionDirector;
import models.Map.Tile;

import java.util.List;

public class TileInteractionDirector implements ITileInteractionDirector
{
    List<IInteractionHandler> tileInteractionHandlers;

    @Override
    public boolean executeInteraction(Tile tile, Entity entity)
    {
        return false;
    }
}
