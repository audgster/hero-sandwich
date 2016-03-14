package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

public class InstaDeathAoE extends AoE
{
    public InstaDeathAoE(PositionHex position)
    {
        super(position);
    }

    public InstaDeathAoE(InstaDeathAoE copy)
    {
        super(copy.getPosition());
    }

    @Override
    public void executeEffect(Entity entity)
    {
        entity.modifyLives(-1);
    }

    @Override
    public String toString()
    {
        return "InstaDeathAoE";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitInstaDeathAoE(this);
    }
}
