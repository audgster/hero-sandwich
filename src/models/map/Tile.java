package models.map;

import models.Subject;
import util.TerrainGroup;
import models.map.areaofeffect.*;
import models.items.*;
import views.Drawable;
import views.Listener;

import java.util.*;

public class Tile implements Drawable, Subject
{
    private TerrainGroup terrainType;
	private HashSet<Item> itemList;
	private HashSet<AreaOfEffect> aoeList;
    private List<Listener> subjects;

    public Tile()
    {
	    this.terrainType = TerrainGroup.GROUND;
		this.itemList = new HashSet<>();
		this.aoeList = new HashSet<>();
        this.subjects = new ArrayList<>();
    }

    public Tile(TerrainGroup terrainType)
    {
        this.terrainType = terrainType;
		this.itemList = new HashSet<>();
		this.aoeList = new HashSet<>();
        this.subjects = new ArrayList<>();
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
            System.out.println("[TILE] Attempted to add an already existing item");
            return;
        }

        itemList.add(item);
        notifyListeners();
    }

    public void removeItem(Item item)
    {
        if (!itemList.contains(item))
        {
            System.out.println("[TILE] Attempted to remove an Item that does not exist");
            return;
        }

        itemList.remove(item);

        notifyListeners();
    }

    public void addAoE(AreaOfEffect AoE)
    {
        if (aoeList.contains(AoE))
        {
            System.out.println("[TILE] Attempted to add an already existing AoE");
            return;
        }

        aoeList.add(AoE);
        notifyListeners();
    }

    public void removeAoE(AreaOfEffect AoE)
    {
        if (!aoeList.contains(AoE))
        {
            System.out.println("[TILE] Attempted to remove an Aoe that does not exist");
            return;
        }

        aoeList.remove(AoE);

        notifyListeners();
    }

    @Override
    public String getImageId() {
        return "Tile_" + terrainType.toString();
    }

    @Override
    public void addListener(Listener listener)
    {
        subjects.add(listener);
    }

    @Override
    public void removeListener(Listener listener)
    {
        boolean found = subjects.remove(listener);

        if (!found)
            System.err.println("[TILE] Tile could not remove Listener [NOT FOUND]");
    }

    @Override
    public void notifyListeners()
    {
        for(Listener l : subjects)
        {
            l.update();
        }
    }
}
