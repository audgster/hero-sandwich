package com.herosandwich.menus.areaviewdrawables;

import javafx.scene.canvas.GraphicsContext;

public class SmasherAvatarDrawable implements Drawable {
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer graphicKey = new Integer(65); //whatever the key in the sprite is

    @Override
    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        graphicsContext.drawImage(spriteMap.getImageForKey(10), point.getX(), point.getY());
    }
}
