package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class DrawableTile implements Drawable, Listener {

    Tile modelTile;
    CanvasPoint centerPoint;
    boolean isVisible = false;
    boolean discovered = false;
    boolean isInFog = true;
    List<Drawable> drawableList = new ArrayList<Drawable>();
    DrawableVisitor drawableVisitor;// = new DrawableVisitor();
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer landTileImageKey = 1;
    Integer opaqueTileImageKey = 2;
    Integer fogTileImageKey = 3;



    public void update() {
        if(isVisible) {
            drawableVisitor.clearDrawableList();
            modelTile.acceptItemVisitor(drawableVisitor);
            modelTile.acceptEntityVisitor(drawableVisitor);
            drawableList = drawableVisitor.getDrawableList();
        }
    }

    public void makeNotVisible() {
        isVisible = false;
    }

    public void makeVisible() {
        isVisible = true;
        discovered = true;
        isInFog = false;
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
    }

    public CanvasPoint getCanvasCoordinate() {
        return centerPoint;
    }


    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        System.out.println("tileDraw");
        if(isInFog)
            graphicsContext.drawImage(spriteMap.getImageForKey(fogTileImageKey), point.getX(), point.getY());
        else if(isVisible) {
            graphicsContext.drawImage(spriteMap.getImageForKey(landTileImageKey), point.getX(), point.getY());
            drawGraphicsInBag(graphicsContext, point);
        }
        else if(discovered) {
            graphicsContext.drawImage(spriteMap.getImageForKey(landTileImageKey), point.getX(), point.getY());
            drawGraphicsInBag(graphicsContext, point);
            graphicsContext.drawImage(spriteMap.getImageForKey(opaqueTileImageKey), point.getX(), point.getY());
        }
    }

    private void drawGraphicsInBag(GraphicsContext graphicsContext, CanvasPoint point) {
        System.out.println("drawGraphicsInBag");
        for(Drawable graphic : drawableList)
            graphic.draw(graphicsContext, point);
    }

}
