package models.map.interactions;

import models.entities.Entity;
import models.map.interactions.interfaces.IInteractionHandler;
import models.map.interactions.interfaces.ITileInteractionDirector;
import models.map.Tile;

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
