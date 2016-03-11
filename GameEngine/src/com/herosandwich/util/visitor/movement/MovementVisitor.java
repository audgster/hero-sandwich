package com.herosandwich.util.visitor.movement;

import com.herosandwich.models.map.Tile;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;
import com.herosandwich.util.visitor.TileVisitor;

/**
 * Created by Mitchell on 3/10/2016.
 */
public abstract class MovementVisitor implements TileVisitor, EntityVisitor, ItemVisitor{

    private boolean canMove;

    public abstract boolean canMove();


    public void visitTile(Tile tile){
        canMove = canMove & false;
        tile.acceptItemVisitor(this);
        tile.acceptEntityVisitor(this);
    }

}
