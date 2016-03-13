package com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.util.visitor.ItemVisitor;


/**
 * Created by matthewdiaz on 3/4/16.
 */

public abstract class SmasherWeapon extends Weapon {
    public SmasherWeapon(String name, int itemId, DerivedStats derivedStats){
        super(name, itemId, derivedStats);
        oWR = OccupationWeaponRestriction.SMASHER;
        weaponType = WeaponType.BRAWL_WEAPON;
    }

    public SmasherWeapon(String name, int itemId, DerivedStats derivedStats, WeaponType wType){
        super(name, itemId, derivedStats);
        oWR = OccupationWeaponRestriction.SMASHER;
        weaponType = wType;
    }

    public void accept(ItemVisitor visitor){
        visitor.visitSmasherWeapon(this);
    }
}
