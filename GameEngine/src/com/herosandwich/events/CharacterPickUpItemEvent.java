package com.herosandwich.events;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public class CharacterPickUpItemEvent implements GameEvent<CharacterPickUpItemListener> {
    private final Character character;
    private final TakeableItem item;

    public CharacterPickUpItemEvent(Character character, TakeableItem item) {
        this.character = character;
        this.item = item;
    }

    public void notify( final CharacterPickUpItemListener listener ) {
        listener.characterPickUpItem( character, item );
    }

}