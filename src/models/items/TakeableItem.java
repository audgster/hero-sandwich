package models.items;

import models.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class TakeableItem extends Item
{
    public TakeableItem(String name)
    {
        super(name);
    }

    public boolean executeInteraction(Entity entity)
    {
        return entity.addItem(this);
    }

  @Override
  public String toString() {
    String str = getName();
    return str;
  }

    @Override
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        state.add("\t\t\t\t" + "Name: " + name + System.getProperty("line.separator"));
        //Add action save capability
        return state;
    }
}
