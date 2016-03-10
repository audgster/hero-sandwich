package com.herosandwich.models.map;

import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;

import java.util.HashMap;

/**
 * Created by Mitchell on 3/7/2016.
 */
public class Map {

    private HashMap<PositionHex, Tile> tileMap;
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
        tileMap = new HashMap<PositionHex, Tile>();
    }

    public Tile getTile(PositionHex pos){
        return tileMap.get(pos);
    }

    public HashMap<PositionHex, Tile> drawLine(PositionHex origin, int range, DirectionHex dir, boolean includeOrigin){
        PositionHex current = origin.getPosInDirection(dir);
        HashMap<PositionHex, Tile> line = new HashMap<PositionHex, Tile>();
        if(includeOrigin){
            line.put(origin, getTile(origin));
        }
        for(int i = 0; i < range; i++){
            line.put(current, getTile(current));
            current = current.getPosInDirection(dir);
        }
        return line;
    }

    public HashMap<PositionHex, Tile> drawCone(PositionHex origin, int range, DirectionHex dir, boolean includeOrigin){
        PositionHex current = origin.getPosInDirection(dir);
        HashMap<PositionHex, Tile> cone = new HashMap<PositionHex, Tile>();
        if(includeOrigin){
            cone.put(origin, getTile(origin));
        }
        for(int i = 0; i < range; i++){
            cone.put(current, getTile(current));
            PositionHex left = current.getPosInDirection(DirectionHex.clockwise(dir));
            PositionHex right = current.getPosInDirection(DirectionHex.counterClockwise(dir));
            for(int j = 0; j < range / 2; j++){
                cone.put(left, getTile(left));
                cone.put(right, getTile(right));
                left = left.getPosInDirection(DirectionHex.clockwise(dir));
                right = right.getPosInDirection(DirectionHex.counterClockwise(dir));
            }
            current = current.getPosInDirection(dir);
        }
        return cone;
    }

    public HashMap<PositionHex, Tile> drawCircle(PositionHex origin, int range, boolean includeOrigin){
        DirectionHex currentDir = DirectionHex.SOUTH_EAST;
        PositionHex current = origin.getPosInDirection(DirectionHex.NORTH);
        HashMap<PositionHex, Tile> circle = new HashMap<PositionHex, Tile>();
        if(includeOrigin){
            circle.put(origin, getTile(origin));
        }
        for(int i = 0; i < range; i++){
            for(int j = 0; j < 6; j++){
                for(int k = 0; k <= i; k++){
                    circle.put(current, getTile(current));
                    current = current.getPosInDirection(currentDir);
                }
                currentDir = DirectionHex.clockwise(currentDir);
            }
            current = current.getPosInDirection(DirectionHex.NORTH);
        }
        return circle;
    }

}
