package com.herosandwich.models.items.takeableItems.equipableItems;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public abstract class EquipableItem extends TakeableItem {
  protected DerivedStats derivedStats;

  public EquipableItem(String name, DerivedStats derivedStat){
    super(name);
    derivedStats = derivedStat;
  }

  //will increase players stats
  public void statModifierOnEquip(Entity entity){

  }

}
