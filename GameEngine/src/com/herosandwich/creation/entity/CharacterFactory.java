package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.DeriveStatStrategy;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.util.visitor.movement.MovementCheckVisitor;

public class CharacterFactory
{
    private EntityFactory entityFactory = new EntityFactory();

    public Character vendCustomInstance(
            String name,
            int lives,
            int strength,
            int agility,
            int intellect,
            int hardiness,
            int experience,
            int movement,
            DeriveStatStrategy statStrategy,
            MovementCheckVisitor visitor,
            Occupation occupation
    )
    {
        if (occupation == null)
            throw new IllegalArgumentException("Occupation cannot be null");

        Entity entity = entityFactory.vendCustomInstance(
                name,
                lives,
                strength,
                agility,
                intellect,
                hardiness,
                experience,
                movement,
                statStrategy,
                visitor
        );

        return new Character(entity, occupation);
    }

    public Character transfromEntity(Entity entity, Occupation occupation)
    {
        return new Character(entity, occupation);
    }

    public Character vendCustomInstance()
    {
        return new Character();
    }
}
