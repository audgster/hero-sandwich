package com.herosandwich.models.map;

import com.herosandwich.events.CharacterPickUpItemListener;
import com.herosandwich.events.PetPickUpItemListener;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Pet;
import com.herosandwich.models.items.takeableItems.TakeableItem;

/**
 * Created by Mitchell on 3/13/2016.
 */
public class MapEventHandler implements CharacterPickUpItemListener, PetPickUpItemListener {

    private Map map;

    public MapEventHandler(Map map){
        this.map = map;
    }

    @Override
    public void characterPickUpItem(Character character, TakeableItem item) {
        map.removeItem(character.getPosition(), item);
        character.insertItemToInventory(item);

        //EventDispatcher.getInstance().notify(new CharacterPickUpItemEvent(character, item));
    }

    @Override
    public void petPickUpItem(Pet pet, TakeableItem item) {
        map.removeItem(pet.getPosition(), item);
    }
}
