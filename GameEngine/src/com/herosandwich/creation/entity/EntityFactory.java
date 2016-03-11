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
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be blank or null");

        if (lives < 0)
            throw new IllegalArgumentException("Lives cannot be negative.");
        if (strength < 0)
            throw new IllegalArgumentException("Strength cannot be negative.");
        if (agility < 0)
            throw new IllegalArgumentException("Agility cannot be negative.");
        if (intellect < 0)
            throw new IllegalArgumentException("Intellect cannot be negative.");
        if (hardiness < 0)
            throw new IllegalArgumentException("Hardiness cannot be negative.");
        if (experience < 0)
            throw new IllegalArgumentException("Experience cannot be negative.");
        if (movement < 1)
            throw new IllegalArgumentException("Movement cannot be negative or zero.");

        if (statStrategy == null)
            throw new IllegalArgumentException("Derived Stat strategy cannot be null");

        if (lives > 3)
            lives = 3;

        PrimaryStats stats = new PrimaryStats(lives, strength, agility, intellect, hardiness, experience, movement);

        return new Entity(name, stats, statStrategy);
    }

    public Entity vendDefaultInstance()
    {
        return new Entity();
    }
}
