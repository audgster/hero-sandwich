package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Character;

public interface CharacterMeleeAttacksEntityListener {

    boolean characterMeleeAttacksEntity( Character attackingEntity, Entity targetEntity );

}