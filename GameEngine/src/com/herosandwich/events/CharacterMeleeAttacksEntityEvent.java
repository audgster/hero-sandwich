package com.herosandwich.events;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Entity;

public class CharacterMeleeAttacksEntityEvent implements GameEvent<CharacterMeleeAttacksEntityListener> {
    private final Character attackingCharacter;
    private final Entity targetEntity;

    public CharacterMeleeAttacksEntityEvent(Character attackingCharacter, Entity targetEntity) {
        this.attackingCharacter = attackingCharacter;
        this.targetEntity = targetEntity;
    }

    public void notify( final CharacterMeleeAttacksEntityListener listener ) {
        listener.characterMeleeAttacksEntity( attackingCharacter, targetEntity );
    }

}