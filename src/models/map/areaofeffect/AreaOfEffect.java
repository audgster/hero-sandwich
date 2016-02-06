package models.map.areaofeffect;

import models.Level;
import models.map.interactions.interfaces.IInteractionHandler;
import views.Drawable;

public abstract class AreaOfEffect implements IInteractionHandler, Drawable
{
    @Override
    public boolean executeInteraction(Level level) {
        return false;
    }

    @Override
    public String getImageId()
    {
        return "AoE_" + this.getClass().getSimpleName();
    }
}
