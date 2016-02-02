package models.Map.Interactions.Interfaces;

import models.Entity.Entity;
import models.Map.Tile;

public interface ITileInteractionDirector
{
    boolean executeInteraction(Tile tile, Entity entity);
}
