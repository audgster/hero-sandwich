package models.Map.areaofeffect;

import models.entities.Entity;

public class LevelUpAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
