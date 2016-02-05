package models.Map;

import util.TerrainGroup;
import models.map.areaofeffect.*;
import models.items.*;
import java.util.*;

public class Tile
{
    private TerrainGroup terrainType;
	private HashSet<Item> itemList;
	private HashSet<AreaOfEffect> aoeList;

    public Tile()
    {
	    this.terrainType = TerrainGroup.GROUND;
		this.itemList = new HashSet<>();
		this.aoeList = new HashSet<>();
    }

    public Tile(TerrainGroup terrainType)
    {
        this.terrainType = terrainType;
		this.itemList = new HashSet<>();
		this.aoeList = new HashSet<>();
    }

    public String getTerrainType()
    {
        return this.terrainType.toString().toLowerCase();
    }
	
	public Collection<Item> getAllItems()
    {
		return itemList;
	}
	
	public Collection<AreaOfEffect> getAllAoE()
    {
		return aoeList;
	}

	public void addItem(Item item)
    {
        if (itemList.contains(item))
        {
            System.out.println("Attempted to add an already existing item");
            return;
        }

        itemList.add(item);
    }

    public void removeItem(Item item)
    {
        if (!itemList.contains(item))
        {
            System.out.println("Attempted to remove an Item that does not exist");
            return;
        }

        itemList.remove(item);
    }

    public void addAoE(AreaOfEffect AoE)
    {
        if (aoeList.contains(AoE))
        {
            System.out.println("Attempted to add an already existing AoE");
            return;
        }

        aoeList.add(AoE);
    }

    public void removeAoE(AreaOfEffect AoE)
    {
        if (!aoeList.contains(AoE))
        {
            System.out.println("Attempted to remove an Item that does not exist");
            return;
        }

        aoeList.remove(AoE);
    }
}
