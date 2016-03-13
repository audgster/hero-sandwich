package com.herosandwich.menus.areaviewdrawables;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by adamfortier on 3/12/16.
 */
public class EntityDrawable implements Drawable {
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer graphicKey = 101; //whatever the key in the sprite is


    public void setGraphicKey(Integer spriteMapImageID) {
        graphicKey = spriteMapImageID;
    }

    public void setType(String entityType) {
        if(entityType.equalsIgnoreCase("moldySandwich")) {
            graphicKey = 102;
        }
    }

    @Override
    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        graphicsContext.drawImage(spriteMap.getImageForKey(graphicKey), point.getX(), point.getY());
    }
}
