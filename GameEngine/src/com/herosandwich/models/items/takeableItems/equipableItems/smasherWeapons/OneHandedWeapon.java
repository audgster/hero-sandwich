package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;

import com.herosandwich.models.entity.DerivedStats;

public class OneHandedWeapon extends SmasherWeapon {
  public OneHandedWeapon(String name, DerivedStats derivedStats, int itemId){
    super(name, derivedStats, itemId);
    weaponType = SmasherWeaponType.ONE_HANDED_WEAPON;
  }

}
