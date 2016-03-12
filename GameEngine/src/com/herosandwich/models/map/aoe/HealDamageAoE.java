package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

public class HealDamageAoE extends AoE
{
    int healPerTick;

    public HealDamageAoE(int healPerTick, PositionHex position)
    {
        super(position);
        this.healPerTick = healPerTick;
    }

    public HealDamageAoE(HealDamageAoE copy)
    {
        super(copy.getPosition());
        this.healPerTick = copy.getHealPerTick();
    }

    public int getHealPerTick()
    {
        return healPerTick;
    }

    @Override
    public void executeEffect(Entity entity) {
        entity.modifyCurrentLife(healPerTick);
    }

    @Override
    public String toString()
    {
        return "HealDamageAoE";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitHealDamageAoE(this);
    }
}
