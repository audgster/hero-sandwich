package com.herosandwich.events;

import com.herosandwich.models.entity.Pet;
import com.herosandwich.models.items.takeableItems.TakeableItem;

/**
 * Created by Mitchell on 3/13/2016.
 */
public class PetPickUpItemEvent implements GameEvent<PetPickUpItemListener> {
    private final Pet pet;
    private final TakeableItem item;

    public PetPickUpItemEvent(Pet pet, TakeableItem item) {
        this.pet = pet;
        this.item = item;
    }

    public void notify( final PetPickUpItemListener listener ) {
        listener.petPickUpItem( pet, item );
    }

}
