package com.herosandwich.models.entity;

import com.herosandwich.util.visitor.EntityVisitor;

public class Pet extends Entity
{
    // Include behaviors for mischief
    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visit(this);
    }
}