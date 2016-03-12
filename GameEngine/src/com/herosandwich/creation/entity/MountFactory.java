package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Mount;

public class MountFactory
{
    public Mount vendCustomMount(
            String name,
            int movement,
            Character rider
    )
    {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be blank or null");
        if (movement < 1)
            throw new IllegalArgumentException("Movement cannot be negative or zero.");

        return new Mount(name, rider, movement);
    }

    public Mount vendDefaultInstance()
    {
        return new Mount();
    }
}
