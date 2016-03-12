package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;

/**
 * Created by matthewdiaz on 3/4/16.
 */
import com.herosandwich.models.entity.DerivedStats;

public class BrawlWeapon extends SmasherWeapon {
    public BrawlWeapon(String name, DerivedStats dervidedStat, int itemId){
        super(name, dervidedStat, itemId);
        weaponType = SmasherWeaponType.BRAWL_WEAPON;
    }
}
