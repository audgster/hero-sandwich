package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;

import com.herosandwich.models.entity.DerivedStats;

public class TwoHandedWeapon extends SmasherWeapon {
  public TwoHandedWeapon(String name, DerivedStats dervidedStat, int itemId){
    super(name, dervidedStat, itemId);
    weaponType = SmasherWeaponType.TWO_HANDED_WEAPON;
  }
}
