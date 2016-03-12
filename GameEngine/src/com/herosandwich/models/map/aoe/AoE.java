package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;


public abstract class AoE
{
    private PositionHex position;

    public AoE(PositionHex position)
    {
        this.position = position;
    }

    public abstract void executeEffect(Entity entity);

    public void accept(AoEVisitor visitor)
    {
        visitor.visitAoE(this);
    }

    public PositionHex getPosition()
    {
        return position;
    }

    public void setPosition(PositionHex position)
    {
        this.position = position;
    }
}
