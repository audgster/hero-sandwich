package models.Items;

import models.Entity.Entity;

public class ConsumableItem extends Item {

    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }

    @Override
    public boolean isObstacle() {
        return false;
    }
}
