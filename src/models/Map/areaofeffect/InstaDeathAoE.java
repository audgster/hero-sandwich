package models.Map.areaofeffect;

import models.entities.Entity;

public class InstaDeathAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
