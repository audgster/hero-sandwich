package models.items;

import models.entities.Entity;
import models.items.actions.IAction;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("\t\t\t\t" + "Name: " + name + System.getProperty("line.separator"));
        state.add("\t\t\t\t" + action.getClass().getSimpleName() + " {" + System.getProperty("line.separator"));
        state.addAll(action.getSaveState());
        state.add("\t\t\t\t}" + System.getProperty("line.separator"));
        return state;
    }
}
