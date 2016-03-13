package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public interface PickUpItemListener {

    void pickUpItem( Entity entity, TakeableItem item );

}