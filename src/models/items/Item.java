package models.items;

import models.Level;
import models.entities.Entity;
import models.map.interactions.interfaces.IInteractionHandler;
import views.Drawable;

public abstract class Item implements IInteractionHandler, Drawable
{
    String name;

    public Item(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean executeInteraction(Entity entity)
    {
        return false;
    }

    @Override
    public boolean executeInteraction(Level level) {
        return false;
    }

    @Override
    public String getImageId() {
        return "Item_" + getName() + this.getClass().getSimpleName();
    }
}
