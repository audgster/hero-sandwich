package com.herosandwich.menus.areaviewdrawables;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by adamfortier on 3/12/16.
 */
public class AoeDrawable implements Drawable {

    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer graphicKey;

    public void setAoeType(String aoeType) {
        if(aoeType.equalsIgnoreCase("HealDamageAoE")) {
            //graphickey = someID in sprite
        }
        else if(aoeType.equalsIgnoreCase("InstaDeathAoE")) {
            //graphickey = someID in sprite
        }
        else if(aoeType.equalsIgnoreCase("TakeDamageAoE")) {
            //graphickey = someID in sprite
        }
        else if(aoeType.equalsIgnoreCase("TeleportAoE")) {
            //graphickey = someID in sprite
        }
        else if(aoeType.equalsIgnoreCase("XpAoE")){
            //graphickey = someID in sprite
        }
    }
    @Override
    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        graphicsContext.drawImage(spriteMap.getImageForKey(graphicKey), point.getX(), point.getY());
    }
}
