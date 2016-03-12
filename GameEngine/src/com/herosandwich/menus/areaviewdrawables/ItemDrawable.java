package com.herosandwich.menus.areaviewdrawables;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by adamfortier on 3/12/16.
 */
public class ItemDrawable implements Drawable {
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer graphicKey = new Integer(2); //whatever the key in the sprite is


    public void setGraphicKey(Integer spriteMapImageID) {
        graphicKey = spriteMapImageID;
    }

    @Override
    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        graphicsContext.drawImage(spriteMap.getImageForKey(graphicKey), point.getX(), point.getY());
    }
}
