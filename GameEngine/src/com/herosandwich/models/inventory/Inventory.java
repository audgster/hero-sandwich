package com.herosandwich.models.inventory;

import com.herosandwich.models.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Inventory {
    private List<Item> inventory;

    public Inventory(){
        inventory = new ArrayList();
    }

    public void insertItem(Item item){
        inventory.add(item);
    }

    public boolean removeItem(Item item){
        return inventory.remove(item);
    }

    public List<Item> getInventory(){
        return inventory;
    }
}
