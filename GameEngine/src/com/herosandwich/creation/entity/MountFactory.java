package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Mount;

public class MountFactory
{
    private CharacterFactory characterFactory = new CharacterFactory();

    public Mount vendCustomMount(
            String name,
            int movement,
            Character rider
    )
    {
        return new Mount(name, rider, movement);
    }

    public Mount vendDefaultInstance()
    {
        return new Mount();
    }
}
