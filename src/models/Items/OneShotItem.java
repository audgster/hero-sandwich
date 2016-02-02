package models.Items;

import models.Entity.Entity;

public abstract class OneShotItem extends Item{

    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }

}
