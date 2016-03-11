package com.herosandwich.util.visitor;

import com.herosandwich.models.map.Tile;

/**
 * Created by Mitchell on 3/10/2016.
 */
public interface TileVisitor {
    void visit(Tile tile);
}
