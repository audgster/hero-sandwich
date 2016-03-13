package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.creation.entity.PlayerFactory;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class TileGrid  implements Listener{

    HashMap<PositionHex, DrawableTile> drawableMap = new HashMap<PositionHex, DrawableTile>();
    Double tileScale = 31D;
    Double tileWidth = tileScale*2;
    Double tileHeight = tileScale * Math.sqrt(3D);
    GraphicsContext graphicsContext;
    Set<PositionHex> inViewTilePositions;

    Double screenWidth;
    Double screenHeight;

    //Need Avatar's position
    Character avatar;
    Map map;

    public TileGrid(Map map, GraphicsContext graphicsContext, Double screenWidth, Double screenHeight) {
        this.map = map;
        this.graphicsContext = graphicsContext;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initGridWithMap();
    }

//    public TileGrid(int height, int width, GraphicsContext graphicsContext) {
//        this.graphicsContext = graphicsContext;
//        //setGrid(height, width);
//    }

    private void initGridWithMap() {
        System.out.println("initGridWithMap");
        Collection<Tile> mapTiles = map.getTiles();
        for(Tile tile : mapTiles) {
            System.out.println("adding drawableTiles");
            DrawableTile drawableTile = new DrawableTile(tile);
            drawableMap.put(tile.getPosition(), drawableTile);
        }

        PlayerFactory factory = new PlayerFactory();
        avatar = factory.vendDefaultInstance();
        map.addEntity(new PositionHex(0,0), avatar);
    }


    /***********************************************************************************************************/
    // For testing!!!!

    public void makeAllTileVisible() {
        System.out.println("makeAllTileVisible");
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

    public void setTileAsDiscovered(PositionHex positionHex) {
        DrawableTile tile = drawableMap.get(positionHex);
        tile.makeNotVisible();
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
        //System.out.println("draw");
        for(PositionHex position : drawableMap.keySet()) {
            //System.out.println("draw0.2");
            drawableMap.get(position).draw(graphicsContext, hexToCanvasPoint(position));
        }
    }



    public CanvasPoint hexToCanvasPoint(PositionHex point) {
        Double x = ( (3/2) * 2.92*(point.getQ() - avatar.getPosition().getQ()) + 0*point.getR())*tileScale;
        Double y = ( (Math.sqrt(3)/2) * 1.92 *(point.getQ() - avatar.getPosition().getQ()) + Math.sqrt(3)*(1.92 * point.getR() - avatar.getPosition().getR()))*tileScale;

        return new CanvasPoint(x + screenWidth/2 - tileWidth, y + screenHeight/2 - tileHeight);
    }
}
