package com.herosandwich.models.equipment;

import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.util.visitor.EquipmentVisitor;

import java.util.HashMap;

public class Equipment {
    private HashMap<EquipmentSlots, EquipableItem> equipment;

    public Equipment(){
        equipment = new HashMap<>();
    }

    public Equipment(Equipment equipment)
    {
        this.equipment = equipment.getEquipment();
    }

    public TakeableItem insertItem(EquipableItem item)
    {
        //item.getLocation;
        // TODO logic for checking to see if a weapon can be put in that slot
        TakeableItem returnItem = null;

//        if (equipment.containsKey(location))
//        {
//            returnItem = equipment.get(location);
//            equipment.remove(location);
//        }
//        equipment.put(location, item);

        return returnItem;
    }

    public TakeableItem removeItem(EquipmentSlots location)
    {
        TakeableItem returnItem = null;

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
