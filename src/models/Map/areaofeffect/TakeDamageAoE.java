package models.Map.areaofeffect;

import models.Entity.Entity;

public class TakeDamageAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
