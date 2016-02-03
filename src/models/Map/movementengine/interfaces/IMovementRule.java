package models.map.movementengine.interfaces;

import models.map.Tile;

public interface IMovementRule
{
    boolean evaluateRule(Tile tile);

    boolean isWhitelist();

    boolean isBlacklist();

    void toggleListMode();

    void add(String add);

    void remove(String remove);
}
