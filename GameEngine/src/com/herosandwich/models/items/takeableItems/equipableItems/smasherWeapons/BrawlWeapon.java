package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;

/**
 * Created by matthewdiaz on 3/4/16.
 */
import com.herosandwich.models.entity.DerivedStats;

public class BrawlWeapon extends SmasherWeapon {
    public BrawlWeapon(String name, int itemId, DerivedStats dervidedStat){
        super(name, itemId, dervidedStat);
        weaponType = SmasherWeaponType.BRAWL_WEAPON;
    }
}
