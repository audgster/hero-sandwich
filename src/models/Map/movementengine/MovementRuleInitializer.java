package models.map.movementengine;

import models.map.movementengine.interfaces.IMovementRule;
import models.map.movementengine.interfaces.IMovementRuleInitializer;

import java.util.HashMap;

public class MovementRuleInitializer implements IMovementRuleInitializer
{
    public HashMap<Class, IMovementRule> initializeMovementRules() { return new HashMap<>(); };
}
