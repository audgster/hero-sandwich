package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;

import com.herosandwich.models.entity.DerivedStats;

public class TwoHandedWeapon extends SmasherWeapon {
  public TwoHandedWeapon(String name, int itemId, DerivedStats dervidedStat){
    super(name, itemId, dervidedStat);
    weaponType = SmasherWeaponType.TWO_HANDED_WEAPON;
  }
}
