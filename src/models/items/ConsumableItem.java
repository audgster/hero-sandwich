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

    public boolean consume(Entity entity, Tile tile)
    {
        return action.execute(entity, tile);
    }


    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("Name: " + name + System.getProperty("line.separator") + " ");
        state.add(action.getClass().getSimpleName() + " {" + System.getProperty("line.separator") + " ");
        state.addAll(action.getSaveState());
        state.add("}" + System.getProperty("line.separator") + " ");
        return state;
    }
}
