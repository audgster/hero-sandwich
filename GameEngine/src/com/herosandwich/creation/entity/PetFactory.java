package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.DeriveStatStrategy;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Pet;

public class PetFactory
{
    private EntityFactory entityFactory = new EntityFactory();

    public Pet vendCustomInstance(
            String name,
            int lives,
            int strength,
            int agility,
            int intellect,
            int hardiness,
            int experience,
            int movement,
            DeriveStatStrategy statStrategy
    )
    {
        Entity entity = entityFactory.vendCustomInstance(
                name, lives, strength, agility, intellect, hardiness, experience, movement, statStrategy);
        return new Pet(entity);
    }

    public Pet transformFromEntity(Entity entity)
    {
        return new Pet(entity);
    }

    public Pet vendDefaultInstance()
    {
        return new Pet();
    }
}
