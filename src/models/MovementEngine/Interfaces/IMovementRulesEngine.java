package models.movementengine.interfaces;

import models.entities.Entity;
import models.map.Tile;

public interface IMovementRulesEngine
{
    boolean evaluateRule(Tile tile, Entity entity);
}
