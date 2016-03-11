package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.DeriveStatStrategy;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.PrimaryStats;

public class EntityFactory
{
    public Entity vendCustomInstance(
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
        PrimaryStats stats = new PrimaryStats(lives, strength, agility, intellect, hardiness, experience, movement);

        return new Entity(name, stats, statStrategy);
    }

    public Entity vendDefaultInstance()
    {
        return new Entity();
    }
}
