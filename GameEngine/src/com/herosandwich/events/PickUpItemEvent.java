package com.herosandwich.events;

import com.herosandwich.events.GameEvent;
import com.herosandwich.events.PickUpItemListener;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public class PickUpItemEvent implements GameEvent<PickUpItemListener> {
    private final Entity entity;
    private final TakeableItem item;

    public PickUpItemEvent(Entity entity, TakeableItem item) {
        this.entity = entity;
        this.item = item;
    }

    public void notify( final PickUpItemListener listener ) {
        listener.pickUpItem( entity, item );
    }

}