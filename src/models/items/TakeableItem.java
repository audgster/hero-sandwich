package models.items;

import models.entities.Entity;

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
}
