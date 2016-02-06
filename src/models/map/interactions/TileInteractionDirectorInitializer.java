package models.map.interactions;

import models.map.interactions.interfaces.ITileInteractionDirector;
import models.map.interactions.interfaces.ITileInteractionDirectorInitializer;

public class TileInteractionDirectorInitializer implements ITileInteractionDirectorInitializer
{
    @Override
    public ITileInteractionDirector initialize()
    {
        return new TileInteractionDirector();
    }
}
