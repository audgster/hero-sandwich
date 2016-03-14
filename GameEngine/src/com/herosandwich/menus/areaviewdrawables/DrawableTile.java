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
    DrawableVisitor drawableVisitor = new DrawableVisitor();
    SpriteMap spriteMap = SpriteMap.getInstance();

    Integer mountainTileKey = 203;
    Integer landTileImageKey = 202;
    Integer opaqueTileImageKey = 204;
    Integer fogTileImageKey = 205;
    Integer waterTileImageKey = 201;



    public void update() {
        if(isVisible) {
            drawableVisitor.clearDrawableList();
            modelTile.acceptAoEVisitor(drawableVisitor);
            modelTile.acceptItemVisitor(drawableVisitor);
            modelTile.acceptEntityVisitor(drawableVisitor);
            drawableList = drawableVisitor.getDrawableList();
        }
    }

    public void makeNotVisible() {
       // System.out.println("makeNotVisible");
        isVisible = false;
    }

    public void makeVisible() {
       //System.out.println("makeVisible");
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
        this.modelTile.addListener(this);
    }

    public CanvasPoint getCanvasCoordinate() {
        return centerPoint;
    }


    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        //System.out.println("tileDraw");
        if(isInFog)
            graphicsContext.drawImage(spriteMap.getImageForKey(fogTileImageKey), point.getX(), point.getY());
        else if(isVisible) {
            int key;

            switch (modelTile.getTerrain())
            {
                case WATER:
                    key = waterTileImageKey;
                    break;
                case GRASS:
                    key = landTileImageKey;
                    break;
                case MOUNTAIN:
                    key = mountainTileKey;
                    break;
                default:
                    key = landTileImageKey;
            }

            graphicsContext.drawImage(spriteMap.getImageForKey(key), point.getX(), point.getY());
            drawGraphicsInBag(graphicsContext, point);
        }
        else if(discovered) {
           //System.out.println("discoveredTile");
            int key;

            switch (modelTile.getTerrain())
            {
                case WATER:
                    key = waterTileImageKey;
                    break;
                case GRASS:
                    key = landTileImageKey;
                    break;
                case MOUNTAIN:
                    key = mountainTileKey;
                    break;
                default:
                    key = landTileImageKey;
            }

            graphicsContext.drawImage(spriteMap.getImageForKey(key), point.getX(), point.getY());
            drawGraphicsInBag(graphicsContext, point);
            graphicsContext.drawImage(spriteMap.getImageForKey(opaqueTileImageKey), point.getX(), point.getY());
        }
    }

    private void drawGraphicsInBag(GraphicsContext graphicsContext, CanvasPoint point) {
        //System.out.println("drawGraphicsInBag");
        for(Drawable graphic : drawableList)
            graphic.draw(graphicsContext, point);
    }

}
