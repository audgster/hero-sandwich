package models.items;

import models.entities.Entity;

public class ConsumableItem extends TakeableItem {

    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
