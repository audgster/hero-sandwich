package com.herosandwich.models.entity;

import com.herosandwich.util.visitor.EntityVisitor;

public class Pet extends Entity
{
    public Pet()
    {
        super();
    }

    public Pet(Pet pet)
    {
        super(pet);
    }

    // Include behaviors for mischief
    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visitPet(this);
    }
}