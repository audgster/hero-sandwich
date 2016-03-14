package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.DeriveStatStrategy;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.util.visitor.movement.MovementVisitor;

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
            MovementVisitor visitor,
            Occupation occupation,
            int availablePoints
    )
    {
        if (availablePoints < 0)
            throw new IllegalArgumentException("Available points cannot be null");

        Character character = characterFactory.vendCustomInstance(
                name, lives, strength, agility, intellect, hardiness, experience, movement, statStrategy, visitor, occupation);

        return new Player(character, availablePoints);
    }

    public Player transformFromCharacter(Character character, int availablePoints)
    {
        return new Player(character, availablePoints);
    }

    public Player vendDefaultInstance()
    {
        return new Player();
    }
}
