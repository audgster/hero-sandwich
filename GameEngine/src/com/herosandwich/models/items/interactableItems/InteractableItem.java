package com.herosandwich.models.items.interactableItems;

import com.herosandwich.models.items.Item;
import com.herosandwich.util.visitor.ItemVisitor;

public class InteractableItem extends Item {
  public InteractableItem(String name, int itemId){
      super(name, itemId);

  }

    public void accept(ItemVisitor visitor){
        visitor.visitInteractableItem(this);
    }

}
