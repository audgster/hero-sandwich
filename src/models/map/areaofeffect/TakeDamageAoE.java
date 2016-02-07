package models.map.areaofeffect;

import models.entities.Entity;

public class TakeDamageAoE extends AreaOfEffect
{
    private int baseDamageAmount;

    public TakeDamageAoE(int damageAmount)
    {
        this.baseDamageAmount = damageAmount;
    }

    @Override
    public boolean executeInteraction(Entity entity) {
        System.out.println("[TAKEDAMAGEAOE] Healing damage amount: " + getDamageAmount());
        entity.takeDamage(getDamageAmount());

        return true;
    }

    public int getDamageAmount()
    {
        return baseDamageAmount;
    }
}
