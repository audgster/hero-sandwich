package models.Map.areaofeffect;

import models.entities.Entity;

public class TakeDamageAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
