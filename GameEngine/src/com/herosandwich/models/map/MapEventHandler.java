package com.herosandwich.models.map;

import com.herosandwich.events.CharacterPickUpItemListener;
import com.herosandwich.events.EntityActivatesAoEListener;
import com.herosandwich.events.PetPickUpItemListener;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Pet;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.map.aoe.AoE;

/**
 * Created by Mitchell on 3/13/2016.
 */
public class MapEventHandler implements CharacterPickUpItemListener, PetPickUpItemListener, EntityActivatesAoEListener{

    private Map map;

    public MapEventHandler(Map map){
        this.map = map;
    }

    @Override
    public void characterPickUpItem(Character character, TakeableItem item) {

        if(character.insertItemToInventory(item)) {
            map.removeItem(character.getPosition(), item);
        }
        //EventDispatcher.getInstance().notify(new CharacterPickUpItemEvent(character, item));
    }

    @Override
    public void petPickUpItem(Pet pet, TakeableItem item) {
        map.removeItem(pet.getPosition(), item);
    }

    @Override
    public void entityActivatesAoE(Entity entity, AoE aoE) {
        aoE.executeEffect(entity);
    }
}
