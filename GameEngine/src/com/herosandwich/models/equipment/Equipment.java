package com.herosandwich.models.equipment;

import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.util.visitor.EquipmentVisitor;

import java.util.Collection;
import java.util.Collections;
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
        Iterator itemSlots = item.getSlotPosition();

        if((item.getEquipmentType() == EquipmentType.WEAPON) || (item.getEquipmentType() == EquipmentType.SHIELD)){
            Weapon weaponOnRightHand = (Weapon) getEquipableItem(EquipmentSlots.RIGHT_HAND);
            Weapon weaponOnLeftHand = (Weapon) getEquipableItem(EquipmentSlots.LEFT_HAND);
            //if character has a Two_handed_weapon equipped then you can't add another weapon type
            //character must first remove weapon from equipment
            if(weaponOnRightHand != null && weaponOnRightHand.getWeaponType() == WeaponType.TWO_HANDED_WEAPON){
                 return false;
            }
            if(weaponOnLeftHand != null && weaponOnLeftHand.getWeaponType() == WeaponType.TWO_HANDED_WEAPON){
                return false;
            }

            if(((Weapon)item).getWeaponType() == WeaponType.TWO_HANDED_WEAPON){
                if(weaponOnRightHand == null && weaponOnLeftHand == null){
                    EquipmentSlots slot = (EquipmentSlots) itemSlots.next();
                    equipment.put(slot, item);
                    return true;
                }
                return false;
            }
        }
        while (itemSlots.hasNext()){
            EquipmentSlots slot = (EquipmentSlots) itemSlots.next();
            if (!equipment.containsKey(slot))
            {
                equipment.put(slot, item);
                return true;
            }
        }
        return false;
    }

    public EquipableItem removeItem(EquipmentSlots location)
    {
        EquipableItem returnItem = null;

        if (equipment.containsKey(location)){
            returnItem = equipment.get(location);
            equipment.remove(location);
        }

        return returnItem;
    }

    public EquipableItem removeItem(EquipableItem item)
    {
        if (equipment.containsValue(item)){
            equipment.values().removeAll(Collections.singleton(item));
            System.out.println(equipment.size());
            return item;
        }

        return null;
    }

    public int getEquipmentSize(){
        return equipment.size();
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

    public EquipableItem[] getEquipmentArray(){
        return (EquipableItem[]) equipment.values().toArray(); // returns an array of all the EquipableItems in Equipment
    }

    public void accept(EquipmentVisitor visitor)
    {
        visitor.visitEquipment(this);
    }
}
