package models.map.movementengine.interfaces;

import java.util.HashMap;

public interface IMovementRuleInitializer
{
    HashMap<Class, IMovementRule> initializeMovementRules();
}
