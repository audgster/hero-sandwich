package com.herosandwich.models.items.takeableItems;

import com.herosandwich.models.items.Item;

public class TakeableItem extends Item {
  public TakeableItem(String name, int itemId){
      super(name, itemId);
  }

  public void getPickedUp(){
      // Item gets picked and added to inventory
      // when Entity walks over it
      //removes item from current tile
  }
    public String getAction(){
        return "";
    }

}
