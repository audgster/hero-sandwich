package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.util.DirectionHex;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by adamfortier on 3/12/16.
 */
public class EntityDrawable implements Drawable {
    SpriteMap spriteMap = SpriteMap.getInstance();
    Integer graphicKey; //whatever the key in the sprite is
    Image avatar = spriteMap.getImageForKey(graphicKey);
    boolean isAnimating;

    ArrayList<Image> smasherAnimation = new ArrayList(2);

    public EntityDrawable(){
//        smasherAnimation.add(spriteMap.getImageForKey(400));
//        smasherAnimation.add(spriteMap.getImageForKey(401));
//        animateFrame();

    }

    public void setGraphicKey(Integer spriteMapImageID) {

        graphicKey = spriteMapImageID;
        avatar = spriteMap.getImageForKey(graphicKey);
    }

    public void setType(Entity entityType) {
        if(entityType.toString().equalsIgnoreCase("moldySandwich")) {
            graphicKey = 102;
            avatar = spriteMap.getImageForKey(graphicKey);
        }
        else if(entityType.toString().equalsIgnoreCase("pet")) {
            graphicKey = 102;
            avatar = spriteMap.getImageForKey(graphicKey);
        }
//        else if(entityType.toString().equalsIgnoreCase("olive"))  {
//            graphicKey = 140;
//            int keyOffSet = DirectionHex.getIntRep(entityType.getDirection());
//            avatar = spriteMap.getImageForKey(graphicKey + keyOffSet);
//        }
    }

    @Override
    public void draw(GraphicsContext graphicsContext, CanvasPoint point) {
        graphicsContext.drawImage(avatar, point.getX(), point.getY());
    }

    private void animateFrame() {
        new AnimationTimer() {
            final long startNanoTime = System.nanoTime();
            double t = 0;
            int frames = 0;
            int fps = 60;
            int frameCnt = 0;
            long lasttimeFPS = 0;
            public void handle(long currentNanoTime) {
                // count the frame
                frameCnt++;

                // check if a second has passed
                long currenttimeNano = System.nanoTime();
                if (currenttimeNano > lasttimeFPS + 1000000000) {
                    // print out each FPS on stdout
                    System.out.println(frameCnt);
                    // reset frame count and time
                    frameCnt = 0;
                    lasttimeFPS = currenttimeNano;
                }
            }
        }.start();
    }

    private void setFrame(double time){
        double duration = 1;
        int index = (int)((time % (smasherAnimation.size() * duration)) / duration);
        avatar = smasherAnimation.get(index);
    }
}
