import models.Entity.Entity;

public abstract class InteractableItem extends Item {

    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
