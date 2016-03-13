package com.herosandwich.models.items.takeableItems.equipableItems.weapons;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;

/**
 * Created by matthewdiaz on 3/12/16.
 */
public class Weapon extends EquipableItem{
    protected WeaponType weaponType;

    public Weapon(String name, int itemId, DerivedStats derivedStats){
        super(name, itemId, derivedStats, EquipmentType.WEAPON);
        weaponType = WeaponType.ONE_HANDED_WEAPON;
    }

    public Weapon(String name, int itemId, DerivedStats derivedStats, WeaponType weaponType){
        super(name, itemId, derivedStats, EquipmentType.WEAPON);
        this.weaponType = weaponType;
    }


    public WeaponType getWeaponType(){
        return weaponType;
    }
}
