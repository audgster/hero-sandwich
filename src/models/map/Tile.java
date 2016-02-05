package models.Map;

import util.TerrainGroup;

public class Tile
{
    private TerrainGroup terrainType;

    public Tile()
    {
	    this.terrainType = TerrainGroup.GROUND;
    }

    public Tile(TerrainGroup terrainType)
    {
        this.terrainType = terrainType;
    }

    public String getTerrainType()
    {
        return this.terrainType.toString().toLowerCase();
    }
}
