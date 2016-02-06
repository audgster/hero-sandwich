package models.items.actions;

import models.entities.Entity;

public interface IAction
{
    boolean execute(Entity entity);
}
