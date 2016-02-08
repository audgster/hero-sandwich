package models.items;

import models.Level;
import models.entities.Entity;
import models.map.Tile;
import models.map.interactions.interfaces.IInteractionHandler;
import views.Drawable;

import java.util.List;

public abstract class Item implements IInteractionHandler, Drawable
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
    public boolean executeInteraction(Level level) {
        return false;
    }

    @Override
    public String getImageId() {
        return "Item_" + getName() + this.getClass().getSimpleName();
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getDescription(){
      return description;
    }

    public List<String> getSaveState() {return null;}
}
