package models.items;

import models.entities.Entity;
import models.items.actions.IAction;

public class InteractableItem extends Item
{
    private IAction action;

    public InteractableItem(String name, IAction action)
    {
        super(name);

        this.action = action;
    }

    @Override
    public boolean executeInteraction(Entity entity)
    {
        return action.execute(entity);
    }
}
