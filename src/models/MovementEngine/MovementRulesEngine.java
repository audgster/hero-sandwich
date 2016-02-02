package models.movementengine;

import models.entities.Entity;
import models.movementengine.interfaces.IMovementRulesEngine;
import models.map.Tile;

public class MovementRulesEngine implements IMovementRulesEngine
{
    @Override
    public boolean evaluateRule(Tile tile, Entity entity) {
        return false;
    }
}
