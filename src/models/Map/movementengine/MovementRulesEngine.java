package models.map.movementengine;

import models.entities.Entity;
import models.map.movementengine.interfaces.*;
import models.map.Tile;

import java.util.HashMap;

public class MovementRulesEngine implements IMovementRulesEngine
{
    IMovementRuleInitializer ruleInitialzer;

    private HashMap<Class, IMovementRule> movementRules;

    @Override
    public boolean evaluateRule(Tile tile, Entity entity) {
        return false;
    }
}
