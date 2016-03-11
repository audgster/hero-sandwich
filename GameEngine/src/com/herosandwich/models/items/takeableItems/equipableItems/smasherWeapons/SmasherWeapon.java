package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;

/**
 * Created by matthewdiaz on 3/4/16.
 */

public abstract class SmasherWeapon extends EquipableItem {
    //protected OcupationWeaponType weaponClass
    public SmasherWeapon(String name, DerivedStats dervidedStat, int itemId){
        super(name, dervidedStat, itemId);
        oWR = OccupationWeaponRestriction.SMASHER;
    }
}
