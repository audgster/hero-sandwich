package com.herosandwich.models.items.takeableItems.equipableItems;

import com.herosandwich.models.items.takeableItems.TakeableItem;

public abstract class EquipableItem extends TakeableItem {
  public EquipableItem(String name){
    super(name);
  }

  public void equipToEntity(){
    //equips this item to Entity
  }

}
