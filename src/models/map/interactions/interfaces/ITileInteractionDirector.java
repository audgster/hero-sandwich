package models.map.interactions.interfaces;

import models.entities.Entity;
import models.map.Tile;

public interface ITileInteractionDirector
{
    boolean executeInteraction(Tile tile, Entity entity);
}
