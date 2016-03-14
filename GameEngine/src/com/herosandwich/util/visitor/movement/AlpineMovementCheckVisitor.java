package com.herosandwich.util.visitor.movement;

import com.herosandwich.models.map.Tile;

/**
 * Created by Mitchell on 3/11/2016.
 */
public class AlpineMovementCheckVisitor extends MovementCheckVisitor {

    public AlpineMovementCheckVisitor(){
        super();
    }

    @Override
    public void visitTile(Tile tile) {
        switch(tile.getTerrain()) {
            case GRASS:
                acceptRule(true);
                tile.acceptItemVisitor(this);
                tile.acceptEntityVisitor(this);
                break;
            case WATER:
                acceptRule(false);
                break;
            case MOUNTAIN:
                acceptRule(true);
                tile.acceptItemVisitor(this);
                tile.acceptEntityVisitor(this);
                break;
            default:
                acceptRule(false);
                break;
        }
    }

    public String toString()
    {
        return "alpine";
    }

}
