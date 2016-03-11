package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.DeriveStatStrategy;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.occupation.Property;

public class PlayerFactory
{
    private CharacterFactory characterFactory = new CharacterFactory();

    public Player vendCustomInstance(
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
            int availablePoints
    )
    {
        if (availablePoints < 0)
            throw new IllegalArgumentException("available points cannot be null");

        Character character = characterFactory.vendCustomInstance(
                name, lives, strength, agility, intellect, hardiness, experience, movement, statStrategy, occupation);

        return new Player(character, availablePoints);
    }

    public Player vendDefaultInstance()
    {
        return new Player();
    }
}
