package models.map.movementengine;

import models.entities.Entity;
import models.map.movementengine.interfaces.*;
import models.map.Tile;

import java.util.HashMap;

public class MovementRulesEngine implements IMovementRulesEngine
{
    private HashMap<String, IMovementRule> movementRules;

    public MovementRulesEngine(IMovementRuleInitializer ruleInitializer)
    {
        movementRules = ruleInitializer.initializeMovementRules();
    }

    @Override
    public boolean evaluateRule(Tile tile, Entity entity)
    {
        IMovementRule rule = movementRules.get(entity.getEntityType());

        return rule.evaluateRule(tile);
    }
}
