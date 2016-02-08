package models.items;

import models.entities.Entity;
import models.items.actions.IAction;
import models.map.Tile;

import java.util.ArrayList;
import java.util.List;

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
