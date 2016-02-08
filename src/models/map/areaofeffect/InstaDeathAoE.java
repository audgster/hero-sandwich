package models.map.areaofeffect;

import models.entities.Entity;
import models.map.Tile;

public class InstaDeathAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity, Tile tile)
    {
        System.out.println("[INSTADEATHAOE] killing entity");
        int livesLeft = entity.loseLife();
        System.out.println("[INSTADEATHAOE] entity has " + livesLeft + " lives left.");

        return true;
    }
}
