package models.map.areaofeffect;

import models.entities.Entity;

public class LevelUpAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity)
    {
        entity.levelUp();
        System.out.println("[LEVELUPAOE] Entity leveled up");
        return true;
    }
}
