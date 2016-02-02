package models.Map.areaofeffect;

import models.entities.Entity;

/**
 * Created by simonnea on 2/1/16.
 */
public class HealDamageAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity) {
        return false;
    }
}
