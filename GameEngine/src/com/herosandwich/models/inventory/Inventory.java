package com.herosandwich.models.inventory;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.Item;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.consumableItems.ConsumableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.util.visitor.InventoryVisitor;
import com.herosandwich.util.visitor.ItemVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Inventory {
    private ArrayList<TakeableItem> inventory;
    private int capacity;

    public Inventory() {
        inventory = new ArrayList<>(12);
        capacity = 12;
        for(int i = 0; i < capacity;i++){
            inventory.add(i,null);
        }
        inventory.add(0,new ConsumableItem("HealingSuperPotion",1));
        inventory.add(1,new TakeableItem("MagicAoeWand",1));
        inventory.add(2,new ConsumableItem("MediocreHealingPotion",1));
        inventory.add(3, new Weapon("SuperSayanSword",1,new DerivedStats(1,1,1,1,1,1)));
        inventory.add(4,new EquipableItem("TheBootsOfAwesome",1, EquipmentType.BOOTS));
    }

    public Inventory(int capacity) {
        inventory = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public boolean insertItem(TakeableItem item) {
        if (getSize() == capacity)
            return false;
        if(item != null){
            inventory.add(item);
        }
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

    public TakeableItem removeItem(TakeableItem item) {
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

    public void acceptItemVisitor(ItemVisitor iVisitor){
        for(Item item: inventory){
            item.accept(iVisitor);
        }
    }
}
