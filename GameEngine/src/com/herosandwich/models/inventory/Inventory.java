package com.herosandwich.models.inventory;

import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.consumableItems.ConsumableItem;
import com.herosandwich.util.visitor.InventoryVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Inventory {
    private ArrayList<TakeableItem> inventory;
    private int capacity;
    private int size;

    public Inventory()
    {
        inventory = new ArrayList<>(12);
        capacity = 12;
        for(int i = 0; i < capacity;i++){
            inventory.add(i,new ConsumableItem("HealingSuperPotion",1));
        }
    }

    public Inventory(int capacity)
    {
        inventory = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public boolean insertItem(TakeableItem item)
    {
        if (inventory.size() == capacity)
            return false;

        inventory.add(item);
        return true;
    }

    public int getSize(){
        int size = 0;
        for(int i = 0;i < capacity;i++){
            if(inventory.get(i)!=null){
                size++;
            }
        }
        return size;
    }

    public TakeableItem removeItem(TakeableItem item)
    {
        TakeableItem removedItem = null;
        if(inventory.remove(item)){
            removedItem = item;
        }
        return removedItem;
    }

    public ArrayList<TakeableItem> getInventory(){
        return inventory;
    }
    public int getCapacity(){ return capacity; }

    public void accept(InventoryVisitor visitor)
    {
        visitor.visitInventory(this);
    }
}
