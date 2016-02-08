package models.items;

import models.Level;
import models.entities.Entity;
import models.map.Tile;
import models.map.interactions.interfaces.IInteractionHandler;

import java.util.ArrayList;
import java.util.List;

public class TakeableItem extends Item
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
    public boolean executeInteraction(Level level) {
        return false;
    }

    @Override
    public String toString()
    {
        String str = getName();
        return str;
    }

    @Override
    public boolean equals(Object obj)
    {
        TakeableItem item;

        try
        {
            item = (TakeableItem) obj;
        }
        catch (ClassCastException ex)
        {
            System.out.println("[TAKEABLEITEM] Invalid cast exception");
            System.out.println("[TAKEABLEITEM] These obviously can't be equal");

            return false;
        }

        if (item == null)
            return false;

        String name1 = this.getName();
        String name2 = item.getName();

        boolean areEqual = this.getName().equals(item.getName());
        return areEqual;
    }

    @Override
    public int hashCode()
    {
        int result = 1;
        result = 31 * result + name.hashCode();
        return result;
    }
    public  List<String> getSaveState(){
      List<String> state = new ArrayList<String>();
      state.add("Name: " + getName() + " " + System.getProperty("line.separator") + " ");
      return state;
    }

}
