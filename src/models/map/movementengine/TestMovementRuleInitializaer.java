package models.map.movementengine;

import models.map.movementengine.interfaces.IMovementRule;
import models.map.movementengine.interfaces.IMovementRuleInitializer;
import util.EntityIdentifier;
import util.TerrainGroup;

import java.util.HashMap;

public class TestMovementRuleInitializaer implements IMovementRuleInitializer
{
    @Override
    public HashMap<String, IMovementRule> initializeMovementRules() {
        HashMap<String, IMovementRule> movementRules = new HashMap<>();

        IMovementRule groundEntityRule = new MovementRule();
        groundEntityRule.add(TerrainGroup.GROUND.toString().toLowerCase());

        IMovementRule airEntityRule = new MovementRule();
        airEntityRule.add(TerrainGroup.GROUND.toString().toLowerCase());
        airEntityRule.add(TerrainGroup.WATER.toString().toLowerCase());

        movementRules.put(EntityIdentifier.GROUND.toString().toLowerCase(), groundEntityRule);
        movementRules.put(EntityIdentifier.AIR.toString().toLowerCase(), airEntityRule);

        return movementRules;
    }
}
