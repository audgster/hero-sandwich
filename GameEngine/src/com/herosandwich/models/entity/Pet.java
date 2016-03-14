package com.herosandwich.models.entity;

import com.herosandwich.menus.areaviewdrawables.Listener;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.visitor.EntityVisitor;

public class Pet extends Entity {
    private int mischief;

    public Pet()
    {
        super();

        mischief = (int)(15 * Math.random()) + 1;
    }

    public Pet(Entity entity)
    {
        super(entity);

        mischief = (int)(15 * Math.random()) + 1;
    }

    public Pet(Pet pet)
    {
        super(pet);

        this.mischief = pet.getMischief();
    }

    public int getMischief()
    {
        return mischief;
    }

    public void modifyMischief(int delta)
    {
        int newMischief = delta + getMischief();

        if (newMischief < 1)
            mischief = 1;
        else if (newMischief > 15)
            mischief = 15;
        else
            mischief = newMischief;

    }

    // Include behaviors for mischief
    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visitPet(this);
    }

}