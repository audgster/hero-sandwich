package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

public class TakeDamageAoE extends AoE
{
    int damagePerTick;

    public TakeDamageAoE(int damagePerTick, PositionHex position)
    {
        super(position);
        this.damagePerTick = damagePerTick;
    }

    public TakeDamageAoE(TakeDamageAoE copy)
    {
        super(copy.getPosition());
        this.damagePerTick = copy.getDamagePerTick();
    }

    public int getDamagePerTick()
    {
        return damagePerTick;
    }

    @Override
    public void executeEffect(Entity entity) {
        entity.modifyCurrentLife(-1 * damagePerTick);
    }

    @Override
    public String toString()
    {
        return "TakeDamageAoE";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitTakeDamageAoE(this);
    }
}
