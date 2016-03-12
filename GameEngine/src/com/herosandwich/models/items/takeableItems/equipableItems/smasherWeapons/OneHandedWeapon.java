package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;

import com.herosandwich.models.entity.DerivedStats;

public class OneHandedWeapon extends SmasherWeapon {
  public OneHandedWeapon(String name, int itemId, DerivedStats derivedStats){
    super(name, itemId, derivedStats);
    weaponType = SmasherWeaponType.ONE_HANDED_WEAPON;
  }

}
