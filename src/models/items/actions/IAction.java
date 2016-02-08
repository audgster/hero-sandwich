package models.items.actions;

import models.entities.Entity;
import models.map.Tile;

import java.util.List;

public interface IAction
{
    boolean execute(Entity entity, Tile tile);

    List<String> getSaveState();
}
