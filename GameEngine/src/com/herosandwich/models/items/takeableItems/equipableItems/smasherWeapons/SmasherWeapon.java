package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;

/**
 * Created by matthewdiaz on 3/4/16.
 */

public abstract class SmasherWeapon extends EquipableItem {
    protected SmasherWeaponType weaponType;
    public SmasherWeapon(String name, DerivedStats derivedStats, int itemId){
        super(name, derivedStats, itemId);
        oWR = OccupationWeaponRestriction.SMASHER;
        equipmentType = EquipmentType.WEAPON;
        allowableSlots.add(EquipmentSlots.LEFTHAND);
        allowableSlots.add(EquipmentSlots.RIGHTHAND);
    }

    public SmasherWeaponType getWeaponType(){
        return weaponType;
    }
}
