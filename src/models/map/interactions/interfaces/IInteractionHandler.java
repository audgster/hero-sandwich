package models.map.interactions.interfaces;

import models.Level;
import models.entities.Entity;
import models.map.Tile;

public interface IInteractionHandler
{
    boolean executeInteraction(Entity entity, Tile tile);

    boolean executeInteraction(Level level);
}
