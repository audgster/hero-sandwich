package models.items;

import models.entities.Entity;
import models.items.actions.IAction;

public abstract class OneShotItem extends Item
{
    IAction action;

    public OneShotItem(String name, IAction action)
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
