package models.MovementEngine;

import models.Entity;
import models.MovementEngine.Interfaces.IMovementRulesEngine;
import models.Map.Tile;

public class MovementRulesEngine implements IMovementRulesEngine
{
    @Override
    public boolean evaluateRule(Tile tile, Entity entity) {
        return false;
    }
}
