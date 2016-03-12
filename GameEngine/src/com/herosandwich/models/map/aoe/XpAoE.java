package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

public class XpAoE extends AoE
{
    int xpPerTick;

    public XpAoE(int xpPerTick, PositionHex positionHex)
    {
        super(positionHex);
        this.xpPerTick = xpPerTick;
    }

    public XpAoE(XpAoE copy)
    {
        super(copy.getPosition());
        this.xpPerTick = copy.getXpPerTick();
    }

    private int getXpPerTick()
    {
        return xpPerTick;
    }

    @Override
    public void executeEffect(Entity entity)
    {
        entity.modifyExperience(xpPerTick);
    }

    @Override
    public String toString()
    {
        return "XpAoE";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitXpAoE(this);
    }
}
