package models.map.movementengine;

import models.map.Tile;
import models.map.movementengine.interfaces.IMovementRule;

import java.util.HashSet;

public class MovementRule implements IMovementRule
{
    private HashSet<String> list;

    public MovementRule()
    {
        list = new HashSet<>();
    }

    public void add(String add)
    {
        if (!list.contains(add))
            list.add(add.toLowerCase());
    }

    public void remove(String remove)
    {
        if (list.contains(remove))
            list.remove(remove.toLowerCase());
    }

    @Override
    public boolean evaluateRule(Tile tile)
    {
        return list.contains(tile.getTerrainType().toLowerCase());
    }
}
