package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TileGrid  implements Listener{

    HashMap<PositionHex, DrawableTile> drawableMap = new HashMap<PositionHex, DrawableTile>();
    //HashMap<PositionHex, CustomList<Drawable>> drawableList = new HashMap<PositionHex, List<Drawable>>();
    Double tileHeight = 30 * Math.sqrt(3D);
    GraphicsContext graphicsContext;
    HashMap<PositionHex, Tile> inViewTiles;

    //Need Avatar's position
    AvatarPosition avatarPosition;
    Map map;

    public TileGrid(Map map) {
        this.map = map;
        initGridWithMap();
    }

    public TileGrid(int height, int width, GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        setGrid(height, width);
    }

    private void initGridWithMap() {
        Collection<Tile> mapTiles = map.getTiles();
        for(Tile tile : mapTiles) {
            DrawableTile drawableTile = new DrawableTile(tile);
            drawableMap.put(tile.getPosition(), drawableTile);
        }
    }


    //TODO need avatar position
    public void update() {
        inViewTiles = map.drawCircle(avatarPosition, 3, true);
        for(Tile tile : inViewTiles.values()) {
            DrawableTile drawableTile = drawableMap.get(tile.getPosition());
            drawableTile.setIsVisible();
            drawableTile.update();
        }
    }
//
//    private void setGrid(int height, int width) {
//        for (int row = 0; row < height; row++) {
//            for (int column = 0; column < 600 / 30; column++) {
//                if (column % 2 == 0 && row % 2 == 0) {
//                    DrawableTile tile = new DrawableTile(60D + 90D * column, 60D + tileHeight * row);
//                    //map.add(tile);
//                } else if (column % 2 == 0 && row % 2 == 1) {
//                    DrawableTile tile = new DrawableTile(150D + 90D * column, 60D + tileHeight * row);
//                    //map.add(tile);
//                }
//            }
//        }
//    }

    public void draw() {
        CanvasPoint blankPoint = new CanvasPoint(0D,0D);
        for(DrawableTile tile : drawableMap.values()) {
            tile.draw(graphicsContext, blankPoint);
        }
    }
}
