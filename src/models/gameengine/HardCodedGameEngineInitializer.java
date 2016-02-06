package models.gameengine;

import models.gameengine.interfaces.IGameEngine;
import models.gameengine.interfaces.IGameEngineInitializer;
import models.map.movementengine.TestMovementDirectorFactory;
import models.map.movementengine.interfaces.IMovementDirectorFactory;

public class HardCodedGameEngineInitializer implements IGameEngineInitializer
{
    @Override
    public IGameEngine initialize()
    {
        return new GameEngine(new TestMovementDirectorFactory().vendNewInstance(), null);
    }
}
