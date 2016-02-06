package models.map.interactions.interfaces;

import models.Level;
import models.entities.Entity;

public interface IInteractionHandler
{
    boolean executeInteraction(Entity entity);

    boolean executeInteraction(Level level);
}
