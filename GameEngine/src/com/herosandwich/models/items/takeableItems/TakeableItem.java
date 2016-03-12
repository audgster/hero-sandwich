package com.herosandwich.models.items.takeableItems;

import com.herosandwich.models.items.Item;

public class TakeableItem extends Item {
    public TakeableItem(String name, int itemId){
      super(name, itemId);
  }

    public String getAction(){return "";}
}
