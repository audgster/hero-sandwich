package models.items.actions;

import models.entities.Entity;

import java.util.List;

public interface IAction
{
    boolean execute(Entity entity);

    List<String> getSaveState();
}
