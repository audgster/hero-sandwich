package com.herosandwich.util.visitor.movement;

import com.herosandwich.models.map.Tile;

/**
 * Created by Mitchell on 3/11/2016.
 */
public class AquaticMovementCheckVisitor extends MovementCheckVisitor {

    public AquaticMovementCheckVisitor(){
        super();
    }

    @Override
    public void visitTile(Tile tile) {
        switch(tile.getTerrain()) {
            case GRASS:
                acceptRule(false);
                break;
            case WATER:
                acceptRule(true);
                tile.acceptItemVisitor(this);
                tile.acceptEntityVisitor(this);
                break;
            case MOUNTAIN:
                acceptRule(false);
                break;
            default:
                acceptRule(false);
                break;
        }
    }

    public String toString()
    {
        return "aquatic";
    }

}