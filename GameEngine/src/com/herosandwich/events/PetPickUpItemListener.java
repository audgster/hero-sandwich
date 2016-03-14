package com.herosandwich.events;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Pet;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public interface PetPickUpItemListener {

    void petPickUpItem(Pet pet, TakeableItem item);

}