package models.MovementEngine.Interfaces;

import models.entities.Entity;
import models.Map.Tile;

public interface IMovementRulesEngine
{
    boolean evaluateRule(Tile tile, Entity entity);
}
