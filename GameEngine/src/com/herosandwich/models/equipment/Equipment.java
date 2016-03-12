package com.herosandwich.models.equipment;

import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.util.visitor.EquipmentVisitor;

import java.util.HashMap;
import java.util.Iterator;

public class Equipment {
    private HashMap<EquipmentSlots, EquipableItem> equipment;

    public Equipment(){
        equipment = new HashMap<>();
    }

    public Equipment(Equipment equipment)
    {
        this.equipment = equipment.getEquipment();
    }

    /* NOTE: We decided that insertItem will not automatically remove any Items
     * NOTE: If false is returned that means that the slots are full and one
     * must unequip first!!
     */
    public boolean insertItem(EquipableItem item)
    {
        boolean inserted = false;
        Iterator itemSlots = item.getSlotPosition();

        while (itemSlots.hasNext()){
            if (!equipment.containsKey(itemSlots.next()))
            {
                equipment.put((EquipmentSlots) itemSlots.next(), item);
                inserted = true;
                break;
            }
        }
        return inserted;
    }

    public EquipableItem removeItem(EquipmentSlots location)
    {
        EquipableItem returnItem = null;

        if (equipment.containsKey(location)){
            returnItem = equipment.get(location);
            equipment.remove(returnItem);
        }

        return returnItem;
    }

    public EquipableItem getEquipableItem(EquipmentSlots location){
        EquipableItem returnItem = null;

        if (equipment.containsKey(location))
            returnItem = equipment.get(location);

        return returnItem;
    }

    public HashMap<EquipmentSlots, EquipableItem> getEquipment()
    {
        return equipment;
    }

    public void accept(EquipmentVisitor visitor)
    {
        visitor.visitEquipment(this);
    }
}
