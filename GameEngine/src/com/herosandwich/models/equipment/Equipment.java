package com.herosandwich.models.equipment;

import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.util.visitor.EquipmentVisitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Equipment {
    private HashMap<EquipmentSlots, EquipableItem> equipment;

    public Equipment(){
        equipment = new HashMap<>();
        test();
    }

    private void test(){

        //insertItem(new EquipableItem("TheBootsOfAwesome",1, EquipmentType.BOOTS));
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

        if(item.getEquipmentType() == EquipmentType.WEAPON){
            if(((Weapon)item).getWeaponType() == WeaponType.TWO_HANDED_WEAPON){
                if(getEquipableItem(EquipmentSlots.RIGHT_HAND) == null
                        && getEquipableItem(EquipmentSlots.LEFT_HAND) == null){
                    equipment.put((EquipmentSlots) itemSlots.next(), item);
                    return true;
                }
                return false;
            }
        }
        while (itemSlots.hasNext()){
            if (!equipment.containsKey(itemSlots.next()))
            {
                equipment.put((EquipmentSlots) itemSlots.next(), item);
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

    public EquipableItem[] getEquipmentArray(){
        Map<EquipmentType,EquipableItem> map = (Map) equipment;
        EquipableItem[] values = new EquipableItem[6];
            for(int i = 0; i < 6; i++){
                values[i] = null;
            }
        int index = 0;
        for (Map.Entry<EquipmentType, EquipableItem> mapEntry : map.entrySet()) {
            values[index] = mapEntry.getValue();
            index++;
        }
        System.out.println(index);
        return values;
    }

    public void accept(EquipmentVisitor visitor)
    {
        visitor.visitEquipment(this);
    }
}
