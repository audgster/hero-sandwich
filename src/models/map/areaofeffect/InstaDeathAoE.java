package models.map.areaofeffect;

import models.entities.Entity;

public class InstaDeathAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity)
    {
        System.out.println("[INSTADEATHAOE] killing entity");
        int livesLeft = entity.loseLife();
        System.out.println("[INSTADEATHAOE] entity has " + livesLeft + " lives left.");

        return true;
    }
}
