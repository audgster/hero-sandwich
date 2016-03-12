package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.util.PositionHex;
import javafx.scene.canvas.GraphicsContext;
import java.util.HashMap;
import java.util.List;

public class TileGrid {

    HashMap<PositionHex, DrawableTile> map = new HashMap<PositionHex, DrawableTile>();
    //HashMap<PositionHex, CustomList<Drawable>> drawableList = new HashMap<PositionHex, List<Drawable>>();
    Double tileHeight = 30 * Math.sqrt(3D);
    GraphicsContext graphicsContext;

    public TileGrid(int height, int width, GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        setGrid(height, width);
    }

    private void setGrid(int height, int width) {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < 600 / 30; column++) {
                if (column % 2 == 0 && row % 2 == 0) {
                    DrawableTile tile = new DrawableTile(60D + 90D * column, 60D + tileHeight * row);
                    //map.add(tile);
                } else if (column % 2 == 0 && row % 2 == 1) {
                    DrawableTile tile = new DrawableTile(150D + 90D * column, 60D + tileHeight * row);
                    //map.add(tile);
                }
            }
        }
    }

//    public void draw() {
//        for(List<DrawableTile> list : map)
//            for(DrawableTile tile: list) {
//                tile.draw(graphicsContext, new CanvasPoint(0D,0D));
//                Drawable graphic = drawableList.get(tile.getHexCoordinate());
//            }
//    }
}
