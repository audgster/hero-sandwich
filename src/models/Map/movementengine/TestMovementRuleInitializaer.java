package models.map.movementengine;

import models.map.movementengine.interfaces.IMovementRule;
import models.map.movementengine.interfaces.IMovementRuleInitializer;

import java.util.HashMap;

public class TestMovementRuleInitializaer implements IMovementRuleInitializer
{
    @Override
    public HashMap<String, IMovementRule> initializeMovementRules() {
        HashMap<String, IMovementRule> movementRules = new HashMap<>();

        IMovementRule groundEntityRule = new MovementRule();
        groundEntityRule.add("grass");

        IMovementRule airEntityRule = new MovementRule();
        airEntityRule.add("grass");
        airEntityRule.add("water");

        movementRules.putIfAbsent("groundentity", groundEntityRule);
        movementRules.putIfAbsent("airentity", airEntityRule);

        return movementRules;
    }
}
