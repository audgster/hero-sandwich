package models.movementengine.interfaces;

import models.map.Tile;

public interface IMovementRule
{
    boolean evaluateRule(Tile tile);
}
