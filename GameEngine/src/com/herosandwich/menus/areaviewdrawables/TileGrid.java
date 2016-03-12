package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class TileGrid  implements Listener{

    HashMap<PositionHex, DrawableTile> drawableMap = new HashMap<PositionHex, DrawableTile>();
    Double tileHeight = 30 * Math.sqrt(3D);
    GraphicsContext graphicsContext;
    Set<PositionHex> inViewTilePositions;

    //Need Avatar's position
    Character avatar;
    Map map;

    public TileGrid(Map map, GraphicsContext graphicsContext) {
        this.map = map;
        this.graphicsContext = graphicsContext;
        initGridWithMap();
    }

//    public TileGrid(int height, int width, GraphicsContext graphicsContext) {
//        this.graphicsContext = graphicsContext;
//        //setGrid(height, width);
//    }

    private void initGridWithMap() {
        Collection<Tile> mapTiles = map.getTiles();
        for(Tile tile : mapTiles) {
            DrawableTile drawableTile = new DrawableTile(tile);
            drawableMap.put(tile.getPosition(), drawableTile);
        }
    }


    /***********************************************************************************************************/
    // For testing!!!!

    public void makeAllTileVisible() {
        for(DrawableTile tile : drawableMap.values()) {
            tile.makeVisible();
        }
    }
    /***********************************************************************************************************/
    //TODO need avatar position
    public void update() {

        makePreviousInViewTilesNotVisible();

        inViewTilePositions = map.drawCircle(avatar.getPosition(), 3, true).keySet();
        for(PositionHex position : inViewTilePositions) {
            DrawableTile drawableTile = drawableMap.get(position);
            drawableTile.makeVisible();
            drawableTile.update();
        }
    }

    private void makePreviousInViewTilesNotVisible() {

        if(inViewTilePositions == null)
            return;

        for(PositionHex position : inViewTilePositions) {
            DrawableTile tile = drawableMap.get(position);
            tile.makeNotVisible();
        }
    }

    public void draw() {
        CanvasPoint blankPoint = new CanvasPoint(0D,0D);
        for(DrawableTile tile : drawableMap.values()) {
            tile.draw(graphicsContext, blankPoint);
        }
    }
}
