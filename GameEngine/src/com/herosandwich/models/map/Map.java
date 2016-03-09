package com.herosandwich.models.map;

import java.util.HashMap;

/**
 * Created by Mitchell on 3/7/2016.
 */
public class Map {

    private HashMap<PositionHex, Tile> tilehMap;
    private PositionHex[][] positionArray;

    public Map(int size){
        if(size < 0){
            throw new IllegalArgumentException("Map size cannot be negative");
        }
        positionArray = new PositionHex[2 * size + 1][2 * size + 1];
        for(int q = -size; q <= size; q++){
            int rStart = -size - Math.min(q, 0);
            int rEnd = size - Math.max(q, 0);
            for(int r = rStart; r <= rEnd; r++){
                positionArray[size + q][size + r] = new PositionHex(q, r);
            }
        }
    }

    public HashMap<PositionHex, Tile> drawLine(PositionHex from, PositionHex to){
        return null;
    }

    public HashMap<PositionHex, Tile> drawCone(PositionHex origin, DirectionHex dir, int radius){
        return null;
    }

    public HashMap<PositionHex, Tile> drawCircle(PositionHex origin, int radius){
        return null;
    }

}
