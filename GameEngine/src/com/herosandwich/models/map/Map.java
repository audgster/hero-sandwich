package com.herosandwich.models.map;

import com.herosandwich.menus.areaviewdrawables.TileGrid;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.Item;
import com.herosandwich.models.map.aoe.AoE;
import com.herosandwich.util.DirectionHex;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.TileVisitor;
import com.herosandwich.util.visitor.movement.MovementExecutionVisitor;
import javafx.scene.canvas.Canvas;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Mitchell on 3/7/2016.
 */
public class Map {

    private HashMap<PositionHex, Tile> tileMap;
    private HashSet<Entity> entitySet;
    private PositionHex[][] positionArray;
    private int size;

    // The position the entity spawns at when it dies
    private PositionHex checkPoint;

    public Map(int size){
        if(size < 0){
            throw new IllegalArgumentException("Map size cannot be negative");
        }
        this.size = size;
        positionArray = new PositionHex[2 * size + 1][2 * size + 1];
        for(int q = -size; q <= size; q++){
            int rStart = -size - Math.min(q, 0);
            int rEnd = size - Math.max(q, 0);
            for(int r = rStart; r <= rEnd; r++){
                positionArray[size + q][size + r] = new PositionHex(q, r);
            }
        }
        tileMap = new HashMap<PositionHex, Tile>();
        entitySet = new HashSet<Entity>();
    }

    public void initialize(Collection<Tile> tiles){
        for(Tile tile: tiles){
            PositionHex pos = tile.getPosition();

            if(PositionHex.distanceTo(new PositionHex(0,0,0), pos) > size){
                throw new IndexOutOfBoundsException("Map size is: " + this.size + "; tried to load Tile at out of " +
                        "bounds PositionHex: " + pos.getQ() +", " + pos.getR() + ", " + pos.getS());
            }
            tileMap.put(pos, tile);
            if (tile.getEntity() != null)
                entitySet.add(tile.getEntity());
        }
    }

    public Collection<Tile> getTiles(){
        return tileMap.values();
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
                    if(getTile(current) != null) {
                        circle.put(current, getTile(current));
                        current = current.getPosInDirection(currentDir);
                    }
                }
                currentDir = DirectionHex.clockwise(currentDir);
            }
            current = current.getPosInDirection(DirectionHex.NORTH);
        }
        return circle;
    }

    public void addEntity(PositionHex pos, Entity entity){
        if (tileMap.containsKey(pos)) {
            if(!entitySet.contains(entity)){
                entitySet.add(entity);
            }

            entity.updatePosition(pos);
            tileMap.get(pos).addEntity(entity);
        }
    }

    public PositionHex getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(PositionHex position) {
        this.checkPoint = position;
    }

    /********************************************************************/
    /* TODO

        ADD THE CharacterPickUpItemEvent to moveEntity...

        fires visitor?? or maybe just a notification to connect the entity the the itemList on the tile

     */
    /********************************************************************/


    public void moveEntity(PositionHex newPos, Entity entity){
        tileMap.get(entity.getPosition()).removeEntity(entity);
        addEntity(newPos, entity); //tileMap.get(pos).addEntity(entity);
        entity.updatePosition(newPos);
        MovementExecutionVisitor visitor = new MovementExecutionVisitor(this, entity);
        entity.accept(visitor);
        tileMap.get(newPos).acceptItemVisitor(visitor);
        tileMap.get(newPos).acceptAoEVisitor(visitor);
    }

    public void removeEntity(PositionHex pos, Entity entity){
        if (tileMap.containsKey(pos)) {
            if (!entitySet.contains(entity)) {
                throw new IllegalArgumentException("This entity is not in the map, and therefore cannot be removed");
            }
            tileMap.get(pos).removeEntity(entity);

            entity.updatePosition(null);
            entitySet.remove(entity);
        }
    }

    public void addItem(PositionHex pos, Item item){
        if (tileMap.containsKey(pos)) {
            tileMap.get(pos).addItem(item);
        }
    }

    public void removeItem(PositionHex pos, Item item){
        if (tileMap.containsKey(pos)) {
            tileMap.get(pos).removeItem(item);
        }
    }

    public void addAoE(PositionHex pos, AoE aoe){
        if (tileMap.containsKey(pos)) {
            tileMap.get(pos).addAoE(aoe);
        }
    }

    public void removeAoE(PositionHex pos, AoE aoe){
        if (tileMap.containsKey(pos)) {
            tileMap.get(pos).removeAoE(aoe);
        }
    }

    public void acceptTileVisitor(TileVisitor tileVisitor){
        for(Tile tile: tileMap.values()){
            tile.acceptTileVisitor(tileVisitor);
        }
    }

    public void acceptTileVisitor(TileVisitor tileVisitor, HashMap<PositionHex, Tile> selection){
        for(PositionHex pos: selection.keySet()){
            Tile tile = tileMap.get(pos);
            if(tile == null){
                continue;
            }
            tile.acceptTileVisitor(tileVisitor);
        }
    }

    /***********************************************************************************************************/
    // For testing!!!!

    public TileGrid initMyDrawable(Canvas canvas) {
        return new TileGrid(this, canvas.getGraphicsContext2D(), canvas.getWidth(), canvas.getHeight());
    }

    /***********************************************************************************************************/



}
