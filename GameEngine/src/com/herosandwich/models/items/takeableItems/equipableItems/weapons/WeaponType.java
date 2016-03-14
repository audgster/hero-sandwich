package com.herosandwich.models.items.takeableItems.equipableItems.weapons;

/**
 * Created by matthewdiaz on 3/11/16.
 */
public enum WeaponType {
    ONE_HANDED_WEAPON,
    TWO_HANDED_WEAPON,
    BRAWL,
    RANGED_WEAPON;

    public String convertToString(WeaponType weaponType){
        switch (weaponType){
            case ONE_HANDED_WEAPON:
                return "one_handed_weapon";
            case TWO_HANDED_WEAPON:
                return "two_handed_weapon";
            case BRAWL:
                return "brawl";
            case RANGED_WEAPON:
                return "range_weapon";
            default:
                throw new IllegalArgumentException();
        }
    }
}
