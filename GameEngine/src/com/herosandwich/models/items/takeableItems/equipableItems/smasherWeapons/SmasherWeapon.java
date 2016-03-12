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
    public SmasherWeapon(String name, int itemId, DerivedStats derivedStats){
        super(name, itemId, derivedStats, EquipmentType.WEAPON);
        oWR = OccupationWeaponRestriction.SMASHER;
    }

    public SmasherWeaponType getWeaponType(){
        return weaponType;
    }
}
