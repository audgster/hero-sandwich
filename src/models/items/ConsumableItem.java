package models.items;

import models.entities.Entity;
import models.items.actions.IAction;

public class ConsumableItem extends TakeableItem
{
    IAction action;

    public ConsumableItem(String name, IAction action)
    {
        super(name);

        this.action = action;
    }

    public boolean consume(Entity entity)
    {
        return action.execute(entity);
    }
}
