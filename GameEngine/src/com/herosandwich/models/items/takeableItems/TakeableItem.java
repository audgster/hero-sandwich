package com.herosandwich.models.items.takeableItems;

import com.herosandwich.models.items.Item;
import com.herosandwich.util.visitor.ItemVisitor;

public class TakeableItem extends Item {
    public TakeableItem(String name, int itemId){
      super(name, itemId);
  }

    public String getAction(){return "";}

    public void accept(ItemVisitor visitor){
        visitor.visitTakeableItem(this);
    }
}
