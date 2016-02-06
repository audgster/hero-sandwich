package models.items;

import models.items.actions.IAction;
import models.items.actions.StatModifyAction;

public class StatModifyingOneShotItem extends OneShotItem
{
    public StatModifyingOneShotItem(String name, StatModifyAction action)
    {
        super(name, action);
    }
}
