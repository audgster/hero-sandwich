package com.herosandwich.models.equipment;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.util.visitor.EquipmentVisitor;

import java.util.*;

public class Equipment {
    private HashMap<EquipmentSlots, EquipableItem> equipment;

    public Equipment(){
        equipment = new HashMap<>();
        //test();
    }

    //Please delete at the end!!!!
    private void test(){
        //insertItem(new EquipableItem("TheBootsOfAwesome",1, EquipmentType.BOOTS));
        //insertItem(new Weapon("MagicAoeWand",3,new DerivedStats(1,1,1,1,1,1)));
        //insertItem(new SmasherWeapon("SuperSayanSword",2, new DerivedStats(3,3,3,40,4,4),WeaponType.TWO_HANDED_WEAPON));
        insertItem(new SneakWeapon("TheBootsOfAwesome",2,new DerivedStats(3,3,3,40,4,4),WeaponType.RANGED_WEAPON));
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
        List<EquipmentSlots> itemAllowableSlots = item.getAllowableSlotPositions();
        EquipmentSlots firstAllowableSlot = itemAllowableSlots.get(0);
        EquipmentType itemEquipmentType = item.getEquipmentType();

        if((itemEquipmentType == EquipmentType.WEAPON) || (itemEquipmentType == EquipmentType.SHIELD)){
            EquipableItem itemOnRightHand = getEquipableItem(EquipmentSlots.RIGHT_HAND);
            EquipableItem itemOnLeftHand = getEquipableItem(EquipmentSlots.LEFT_HAND);

            //easy checks. The first if statement is the only time you can insert a two-handed weapon
            if(itemOnRightHand == null && itemOnLeftHand == null){
                equipment.put(firstAllowableSlot, item);
                return true;//if left and right arm are both empty insert EquipableItem
            }else if(itemOnRightHand != null && itemOnLeftHand != null){
                return false;//if both right & left arm are occupied you can't insert anything
            }

            /* Check if item that you want to insert is a two-handed weapon
             * at this point in the code it means that one of the characters hands
             * is equipped. therefore return false
             */
            if((item.getEquipmentType() == EquipmentType.WEAPON) &&
                    (((Weapon)item).getWeaponType() == WeaponType.TWO_HANDED_WEAPON) ){
                return false;
            }

            //checking for two-handed weapons equipped on either arm of the character
            if(itemOnRightHand != null){
                if((itemOnRightHand.getEquipmentType() == EquipmentType.WEAPON) &&
                        (((Weapon)itemOnRightHand).getWeaponType() == WeaponType.TWO_HANDED_WEAPON)){
                    return false;
                }
            }else if(itemOnLeftHand != null){
                if((itemOnLeftHand.getEquipmentType() == EquipmentType.WEAPON) &&
                        (((Weapon)itemOnLeftHand).getWeaponType() == WeaponType.TWO_HANDED_WEAPON)){
                    return false;
                }
            }
        }
         // After passing all of the checks just inserts into available slot!
        for(EquipmentSlots slot: itemAllowableSlots) {
            if (!equipment.containsKey(slot))
            {
                equipment.put(slot, item);
                return true;
            }
        }
        //if no available slots return false
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
            return item;
        }

        return null;
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
        EquipableItem[] values = new EquipableItem[6];
        EquipmentSlots[] slots = {EquipmentSlots.LEFT_HAND, EquipmentSlots.HEAD, EquipmentSlots.CHEST,
                                  EquipmentSlots.LEGGINGS, EquipmentSlots.FEET, EquipmentSlots.RIGHT_HAND};

        for(int i = 0; i < values.length; i++){
            values[i] = equipment.get(slots[i]);
        }

        return values;
    }

    public int getEquipmentSize(){
        return equipment.size();
    }

    public void accept(EquipmentVisitor visitor)
    {
        visitor.visitEquipment(this);
    }
}
