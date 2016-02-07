package models.items;

import models.entities.Entity;
import models.items.actions.IAction;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("\t\t\t\t" + "Name: " + name + System.getProperty("line.separator"));
        //Add action save capability
        return state;
    }
}
