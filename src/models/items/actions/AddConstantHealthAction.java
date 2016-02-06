package models.items.actions;

import models.entities.Entity;

public class AddConstantHealthAction extends StatModifyAction
{
    public AddConstantHealthAction(int baseHealthIncrease)
    {
        super(baseHealthIncrease);
    }

    @Override
    public boolean execute(Entity entity)
    {
        entity.healDamage(getModificationAmount());

        return true;
    }
}
