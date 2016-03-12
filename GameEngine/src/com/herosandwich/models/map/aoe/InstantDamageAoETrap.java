package com.herosandwich.models.map.aoe;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;

public class InstantDamageAoETrap extends AoE implements Trap
{
    int instantDamage;
    boolean isActive;
    boolean isDiscovered;

    public InstantDamageAoETrap(int instantDamage, PositionHex position)
    {
        super(position);
        this.instantDamage = instantDamage;

        isActive = true;
        isDiscovered = false;
    }

    public InstantDamageAoETrap(InstantDamageAoETrap copy)
    {
        super(copy.getPosition());
        this.instantDamage = copy.getInstantDamage();
        this.isActive = copy.isActive();
        this.isDiscovered = copy.isDiscovered();
    }

    private int getInstantDamage()
    {
        return instantDamage;
    }

    @Override
    public void executeEffect(Entity entity) {
        if (isActive()) {
            entity.modifyCurrentLife(-1 * instantDamage);
        }
    }

    @Override
    public boolean isDiscovered() {
        return isDiscovered;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void deactivate() {
        isActive = false;
    }

    @Override
    public void activate() {
        isActive = true;
    }

    @Override
    public String toString()
    {
        return "InstantDamageAoETrap";
    }

    @Override
    public void accept(AoEVisitor visitor)
    {
        visitor.visitTrapAoE(this);
    }
}
