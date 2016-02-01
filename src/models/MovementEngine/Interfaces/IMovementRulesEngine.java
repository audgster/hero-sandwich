package models.MovementEngine.Interfaces;

import models.Entity;
import models.Tile;

public interface IMovementRulesEngine
{
    boolean evaluateRule(Tile tile, Entity entity);
}
