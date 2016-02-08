package models.map.areaofeffect;

import models.entities.Entity;
import models.map.Tile;

public class LevelUpAoE extends AreaOfEffect
{
    @Override
    public boolean executeInteraction(Entity entity, Tile tile)
    {
        entity.levelUp();
        System.out.println("[LEVELUPAOE] Entity leveled up");
        return true;
    }
}
