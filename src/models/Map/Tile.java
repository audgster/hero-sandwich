package models.map;

public class Tile
{
    private String terrainType;

    public Tile(String terrainType)
    {
        this.terrainType = terrainType;
    }

    public String getTerrainType()
    {
        return this.terrainType.toLowerCase();
    }
}
