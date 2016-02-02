package models.items;

import models.entities.Entity;

public abstract class TakeableItem extends Item
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }

<<<<<<< HEAD
=======
    @Override
    public boolean isObstacle() {
        return false;
    }
>>>>>>> 727a14ddc8c3b9dbebd81d59a052e64f638aaf17
}
