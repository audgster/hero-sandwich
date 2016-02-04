package models.items;

import models.entities.Entity;

public class InteractableItem extends Item {

    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
