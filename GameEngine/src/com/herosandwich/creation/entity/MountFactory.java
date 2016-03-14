package com.herosandwich.creation.entity;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Mount;
import com.herosandwich.util.visitor.movement.MovementCheckVisitor;

public class MountFactory
{
    public Mount vendCustomMount(
            String name,
            int movement,
            Character rider,
            MovementCheckVisitor visitor
    )
    {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be blank or null");
        if (movement < 1)
            throw new IllegalArgumentException("Movement cannot be negative or zero.");

        return new Mount(name, rider, movement, visitor);
    }

    public Mount vendDefaultInstance()
    {
        return new Mount();
    }
}
