package models.items;

import models.items.actions.StatModifyAction;

public class StatModifyingConsumableItem extends ConsumableItem
{
    public StatModifyingConsumableItem(String name, StatModifyAction action)
    {
        super(name, action);
    }
}
