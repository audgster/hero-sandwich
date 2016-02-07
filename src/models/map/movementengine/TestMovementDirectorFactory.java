package models.map.movementengine;

import models.map.movementengine.interfaces.IMovementDirector;
import models.map.movementengine.interfaces.IMovementDirectorFactory;
import models.map.movementengine.interfaces.IMovementRuleInitializer;
import models.map.movementengine.interfaces.IMovementRulesEngine;

public class TestMovementDirectorFactory implements IMovementDirectorFactory
{
    @Override
    public IMovementDirector vendNewInstance()
    {
        // Change this to change how your rules are initialized (parsed, hardcoded, etc)
        IMovementRuleInitializer initializer = new TestMovementRuleInitializer();

        // Change this to adjust how you implement the rules engine
        IMovementRulesEngine rulesEngine = new MovementRulesEngine(initializer);

        // Change this if you adjust the implementation of the IMovementDirector
        return new MovementDirector(rulesEngine);
    }
}
