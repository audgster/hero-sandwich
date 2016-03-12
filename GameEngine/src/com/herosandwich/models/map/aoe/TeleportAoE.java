package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

public class TeleportAoE extends AoE
{
    PositionHex destination;

    public TeleportAoE(PositionHex destination, PositionHex position)
    {
        super(position);
        this.destination = destination;
    }

    @Override
    public void executeEffect(Entity entity) {
    }

    @Override
    public String toString()
    {
        return "TeleportAoE";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitTeleportAoE(this);
    }
}
