package com.herosandwich.models.equipment;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons.SmasherWeapon;
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
        insertItem(new EquipableItem("TheBootsOfAwesome",1, EquipmentType.BOOTS));
        insertItem(new Weapon("MagicAoeWand",3,new DerivedStats(1,1,1,1,1,1)));
        insertItem(new SmasherWeapon("SuperSayanSword",2, new DerivedStats(3,3,3,40,4,4),WeaponType.TWO_HANDED_WEAPON));

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
                    EquipmentSlots slot = (EquipmentSlots) itemSlots.next();
                    equipment.put(slot, item);
                    System.out.println("true");
                    return true;
                }
                System.out.println("false");
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
        Map<EquipmentSlots,EquipableItem> map = (Map) equipment;
        EquipableItem[] values = new EquipableItem[6];
            for(int i = 0; i < 6; i++){
                values[i] = null;
            }
        for (Map.Entry<EquipmentSlots, EquipableItem> mapEntry : map.entrySet()) {
            if(mapEntry.getKey() == EquipmentSlots.LEFT_HAND){
                values[0] = mapEntry.getValue();
            }
            else if(mapEntry.getKey() == EquipmentSlots.HEAD){
                values[1] = mapEntry.getValue();
            }
            else if(mapEntry.getKey() == EquipmentSlots.CHEST){
                values[2] = mapEntry.getValue();
            }
            else if(mapEntry.getKey() == EquipmentSlots.LEGGINGS){
                values[3] = mapEntry.getValue();
            }
            else if(mapEntry.getKey() == EquipmentSlots.FEET){
                values[4] = mapEntry.getValue();
            }
            else if(mapEntry.getKey() == EquipmentSlots.RIGHT_HAND){
                values[5] = mapEntry.getValue();
            }
        }
        return values;
    }

    public void accept(EquipmentVisitor visitor)
    {
        visitor.visitEquipment(this);
    }
}
