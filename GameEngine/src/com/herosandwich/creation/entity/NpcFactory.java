package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.occupation.Property;

public class NpcFactory
{
    private CharacterFactory characterFactory = new CharacterFactory();

    public Npc vendCustomInstance(
            String name,
            int lives,
            int strength,
            int agility,
            int intellect,
            int hardiness,
            int experience,
            int movement,
            DeriveStatStrategy statStrategy,
            Property occupation,
            Attitude attitudeTowardsPlayer,
            Trade trade,
            String[] thgs2say
    )
    {
        if (thgs2say.length < 1)
            throw new IllegalArgumentException("Npc cannot be speechless");
        if (attitudeTowardsPlayer == null)
            throw new IllegalArgumentException("Attitude towards player cannot be null");
        if (trade == null)
            throw new IllegalArgumentException("Trade cannot be null");

        Character character = characterFactory.vendCustomInstance(
                name, lives, strength, agility, intellect, hardiness, experience, movement, statStrategy, occupation);

        return new Npc(character, attitudeTowardsPlayer, trade, thgs2say);
    }

    public Npc vendDefaultInstance()
    {
        return new Npc();
    }
}
