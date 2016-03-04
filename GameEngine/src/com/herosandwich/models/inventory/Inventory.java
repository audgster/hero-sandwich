package com.herosandwich.models.inventory;

import com.herosandwich.models.items.Item;
import com.herosandwich.models.items.takeableItems.TakeableItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Inventory {
    private List<TakeableItem> inventory;
    private int capacity;

    public Inventory(){
        inventory = new ArrayList();
    }

    public boolean insertItem(TakeableItem item)
    {
        if (inventory.size() == capacity)
            return false;

        inventory.add(item);
        return true;
    }

    public boolean removeItem(Item item)
    {
        return inventory.remove(item);
    }

    public List<TakeableItem> getInventory(){
        return inventory;
    }
}
