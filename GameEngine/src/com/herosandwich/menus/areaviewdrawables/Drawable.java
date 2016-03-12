package com.herosandwich.menus.areaviewdrawables;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by adamfortier on 3/11/16.
 */
public interface Drawable {
    public void draw(GraphicsContext graphicsContext, CanvasPoint point);
}
