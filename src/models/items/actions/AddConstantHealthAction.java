package models.items.actions;

import models.entities.Entity;

import java.util.ArrayList;
import java.util.List;

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
