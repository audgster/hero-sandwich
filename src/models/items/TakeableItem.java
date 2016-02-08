package models.items;

import models.entities.Entity;
import models.map.Tile;

import java.util.ArrayList;
import java.util.List;

public abstract class TakeableItem extends Item
{
    public TakeableItem(String name)
    {
        super(name);
    }

    public boolean executeInteraction(Entity entity, Tile tile)
    {
        if (entity.addItem(this))
        {
            tile.removeItem(this);
            return true;
        }

        return false;
    }

  @Override
  public String toString() {
    String str = getName();
    return str;
  }

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("Name: " + name + System.getProperty("line.separator") + " ");
        //Add action save capability
        return state;
    }
}
