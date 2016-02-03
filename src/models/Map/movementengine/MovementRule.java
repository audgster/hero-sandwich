package models.map.movementengine;

import models.map.Tile;
import models.map.movementengine.interfaces.IMovementRule;

import java.util.HashSet;
import java.util.List;

public class MovementRule implements IMovementRule
{
    private HashSet<String> list;

    private boolean isWhitelist = true;

    public MovementRule()
    {
        list = new HashSet<>();
    }

    public boolean isWhitelist()
    {
        return isWhitelist;
    }

    public boolean isBlacklist() {
        return !isWhitelist;
    }

    public void toggleListMode()
    {
        isWhitelist = !isWhitelist;
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
        if (isWhitelist())
            return list.contains(tile.getTerrainType().toLowerCase());
        return !list.contains(tile.getTerrainType().toLowerCase());
    }
}
