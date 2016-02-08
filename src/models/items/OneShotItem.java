package models.items;

import models.entities.Entity;
import models.items.actions.IAction;
import models.map.Tile;

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
    public boolean executeInteraction(Entity entity, Tile tile)
    {
        action.execute(entity);
        tile.removeItem(this);

        return true;
    }

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("Name: " + name + System.getProperty("line.separator") + " ");
        //Add action save capability
        return state;
    }
}
