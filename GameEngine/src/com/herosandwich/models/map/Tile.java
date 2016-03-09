package com.herosandwich.models.map;

/**
 * Created by Mitchell on 3/7/2016.
 */
public class Tile {

    public enum Terrain{
        GRASS,
        WATER,
        MOUNTAIN
    }

    private PositionHex pos;
    private Terrain terrain;

    public Tile(PositionHex pos, Terrain terrain){
        this.pos = pos;
        this.terrain = terrain;
    }

}
