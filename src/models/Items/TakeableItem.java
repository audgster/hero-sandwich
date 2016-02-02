package models.items;

import models.entities.Entity;

public abstract class TakeableItem extends Item
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }

    @Override
    public boolean isObstacle() {
        return false;
    }
}
