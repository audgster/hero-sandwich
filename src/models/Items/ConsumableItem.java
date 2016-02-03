package models.items;

import models.entities.Entity;

public class ConsumableItem extends Item {

    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
    
    public boolean isObstacle() {
        return false;
    }
}
