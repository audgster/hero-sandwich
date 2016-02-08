package models.items;

import models.Level;
import models.entities.Entity;
import models.map.Tile;
import models.map.interactions.interfaces.IInteractionHandler;
import views.Drawable;

import java.util.List;

public abstract class Item implements Drawable, IInteractionHandler
{
    protected String name;
    protected String description;

    public Item(String name)
    {
        this.name = name;
        this.description = "";
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String getImageId() {
        return "Item_" + getName() + this.getClass().getSimpleName();
    }

    public boolean allowMovement()
    {
        return true;
    }

    @Override
    public boolean executeInteraction(Entity entity, Tile tile) {
        return false;
    }

    @Override
    public boolean executeInteraction(Level level) {
        return false;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getDescription(){
      return description;
    }

    public abstract List<String> getSaveState();
}
