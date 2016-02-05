package models.map;

import util.TerrainGroup;
import models.map.areaofeffect.*;
import models.items.*;
import java.util.*;

public class Tile
{
    private TerrainGroup terrainType;
	private ArrayList<Item> itemList;
	private ArrayList<AreaOfEffect> aoeList;

    public Tile()
    {
	    this.terrainType = TerrainGroup.GROUND;
		this.itemList = new ArrayList<Item>();
		this.aoeList = new ArrayList<AreaOfEffect>();
    }

    public Tile(TerrainGroup terrainType)
    {
        this.terrainType = terrainType;
		this.itemList = new ArrayList<Item>();
		this.aoeList = new ArrayList<AreaOfEffect>();
    }

    public String getTerrainType()
    {
        return this.terrainType.toString().toLowerCase();
    }
	
	public ArrayList<Item> getListOfItems(){
		return itemList;
	}
	
	public ArrayList<AreaOfEffect> getListOfAOEs(){
		return aoeList;
	}
}
