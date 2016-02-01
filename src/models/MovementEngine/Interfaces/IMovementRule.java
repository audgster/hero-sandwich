package models.MovementEngine.Interfaces;

import models.Map.Tile;

public interface IMovementRule
{
    boolean evaluateRule(Tile tile);
}
