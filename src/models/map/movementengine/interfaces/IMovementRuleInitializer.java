package models.map.movementengine.interfaces;

import java.util.HashMap;

public interface IMovementRuleInitializer
{
    HashMap<String, IMovementRule> initializeMovementRules();
}
