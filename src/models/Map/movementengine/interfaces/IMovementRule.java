package models.map.movementengine.interfaces;

import models.map.Tile;

public interface IMovementRule
{
    boolean evaluateRule(Tile tile);

    void add(String add);
}
