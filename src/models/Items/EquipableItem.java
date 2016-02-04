package models.items;

import models.entities.Entity;

public class EquipableItem extends TakeableItem
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
