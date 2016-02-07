package models.map.areaofeffect;

import models.entities.Entity;

public class HealDamageAoE extends AreaOfEffect
{
    int baseHealingAmount;

    public HealDamageAoE(int healAmount)
    {
        baseHealingAmount = healAmount;
    }

    @Override
    public boolean executeInteraction(Entity entity) {

        System.out.println("[HEALDAMAGEAOE] Healing damage amount: " + getHealingAmount());
        entity.healDamage(getHealingAmount());

        return true;
    }

    public int getHealingAmount()
    {
        return baseHealingAmount;
    }
}
