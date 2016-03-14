package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Player;
import com.herosandwich.util.DirectionHex;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by adamfortier on 3/14/16.
 */
public class PlayerDrawable implements Drawable {
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer graphicKey; //whatever the key in the sprite is
    Image avatar;
    boolean isAnimating;




    public void setGraphicKey(Integer spriteMapImageID) {

        graphicKey = spriteMapImageID;
        avatar = spriteMap.getImageForKey(graphicKey);
    }

    public void setType(Player player) {
        System.out.println(player.getOccupation().toString());
            if(player.getOccupation().toString().equalsIgnoreCase("Smasher")){
                System.out.println("I should render!");
                graphicKey = 102;
                int keyOffSet = DirectionHex.getIntRepresentation(player.getDirection());
                avatar = spriteMap.getImageForKey(graphicKey + keyOffSet);
            }
        else if(player.getOccupation().toString().equalsIgnoreCase("Sneak")) {
                graphicKey = 112;
                int keyOffSet = DirectionHex.getIntRepresentation(player.getDirection());
                avatar = spriteMap.getImageForKey(graphicKey + keyOffSet);
            }

        else if(player.getOccupation().toString().equalsIgnoreCase("Summoner")) {
                graphicKey = 119;
                int keyOffSet = DirectionHex.getIntRepresentation(player.getDirection());
                avatar = spriteMap.getImageForKey(graphicKey + keyOffSet);
            }


    }

    @Override
    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        System.out.println("I am here!!!");
        graphicsContext.drawImage(avatar, point.getX(), point.getY());
    }
}
