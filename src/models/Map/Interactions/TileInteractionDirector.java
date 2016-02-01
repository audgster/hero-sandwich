package models.Map.Interactions;

import models.Entity;
import models.Map.Interactions.Interfaces.ITileInteractionDirector;
import models.Map.Tile;

public class TileInteractionDirector implements ITileInteractionDirector
{


    @Override
    public boolean executeInteraction(Tile tile, Entity entity)
    {
        return false;
    }
}
