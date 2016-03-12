package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class DrawableTile implements Drawable, Listener {
//    CanvasPoint centerPoint;
//
    //Image baseTile = new Image("com/herosandwich/menus/Land6.jpg"); use sprite map for this
//    Image opaqueLayer = new Image("com/herosandwich/menus/opaque_tile.png"); //see above
//    Image fogLayer; // see above

    Tile modelTile;
    PositionHex hexCoordinate;
    CanvasPoint centerPoint;
    boolean isVisible = false;
    boolean isInFog = true;
    List<Drawable> drawableList = new ArrayList<Drawable>();
    DrawableVisitor drawableVisitor = new DrawableVisitor();
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer landTileImageKey = new Integer(1);



    public void update() {
        if(isVisible) {
            drawableVisitor.clearDrawableList();
            modelTile.acceptItemVisitor(drawableVisitor);
            modelTile.acceptEntityVisitor(drawableVisitor);
            drawableList = drawableVisitor.getDrawableList();
        }
    }

    public void methodforMakeInvisible() {
        //MAKE THINGS GRAY
        isVisible = false;
    }

    public void methodforMakeVisible() {
        //MAKE THINGS GRAY
        isVisible = true;
        update();
    }

    public DrawableTile(Double xCenter, Double yCenter) {
        centerPoint = new CanvasPoint(xCenter, yCenter);
    }

    public DrawableTile(CanvasPoint centerPoint) {
        this.centerPoint = centerPoint;
    }

    public DrawableTile(Tile modelTile) {
        this.modelTile = modelTile;
        hexCoordinate = modelTile.getPosition();
    }

    public void setTerrainAsWater() {
        //Set image to water
    }

//    public void setTerrainAsLand() {
//        baseTile = new Image("com/herosandwich/menus/ground_tile.png");
//    }

    public void setTerrainAsMountain() {
        //set image to mountain
    }

    public PositionHex getHexCoordinate() {
        return hexCoordinate;
    }

    public CanvasPoint getCanvasCoordinate() {
        return centerPoint;
    }

//    public void drawBaseTile(GraphicsContext graphicsContext) {
//        graphicsContext.drawImage(baseTile, centerPoint.getX(), centerPoint.getY());
//    }

    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        for(Drawable graphic : drawableList) {
            graphicsContext.drawImage(spriteMap.getImageForKey(landTileImageKey), point.getX(), point.getY());
            graphic.draw(graphicsContext, centerPoint);
            if(isInFog)
                graphicsContext.drawImage(spriteMap.getImageForKey(2), point.getX(), point.getY());
            else if(!isVisible)
                graphicsContext.drawImage(spriteMap.getImageForKey(3), point.getX(), point.getY());
        }
    }

}
