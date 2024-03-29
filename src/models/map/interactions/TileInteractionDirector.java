package models.map.interactions;

import models.entities.Entity;
import models.items.Item;
import models.map.areaofeffect.AreaOfEffect;
import models.map.interactions.interfaces.IInteractionHandler;
import models.map.interactions.interfaces.ITileInteractionDirector;
import models.map.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TileInteractionDirector implements ITileInteractionDirector
{
    @Override
    public boolean executeInteraction(Tile tile, Entity entity)
    {
        Collection<IInteractionHandler> handlers = new ArrayList<>();
        for (AreaOfEffect aoe : tile.getAllAoE())
        {
            handlers.add(aoe);
        }

        for (Item item : tile.getAllItems())
        {
            handlers.add(item);
        }

        boolean success = true;

        for (IInteractionHandler handler : handlers)
        {
            success = success && executeHandler(handler, entity, tile);
        }

        return success;
    }

    private boolean executeHandler(IInteractionHandler handler, Entity entity, Tile tile)
    {
        return handler.executeInteraction(entity, tile);
    }
}
