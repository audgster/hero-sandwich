package com.herosandwich.models.items.takeableItems.consumableItems;

import com.herosandwich.models.items.takeableItems.TakeableItem;

public class ConsumableItem extends TakeableItem {
  public ConsumableItem(String name, int itemId){
    super(name, itemId);
  }

  public void consume(){
    //consume an item when avatar chooses it from inventory
  }
}
