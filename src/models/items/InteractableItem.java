package models.items;

import models.entities.Entity;
import models.items.actions.IAction;
import models.map.Tile;

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
    public boolean executeInteraction(Entity entity, Tile tile)
    {
        return action.execute(entity);
    }

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("Name: " + name + System.getProperty("line.separator") + " ");
        state.add(action.getClass().getSimpleName() + " {" + System.getProperty("line.separator") + " ");
        state.addAll(action.getSaveState());
        state.add("}" + System.getProperty("line.separator") + " ");
        return state;
    }
}
