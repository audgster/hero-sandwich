package com.herosandwich.menus.areaviewdrawables;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by adamfortier on 3/12/16.
 */
public class SpriteMap {
    /*
    Hashmap of all images... keys are ints... Drawable have hardcoded ints... Yay!
     */

    HashMap<Integer, Image> sprites = new HashMap<Integer, Image>();


    static Image groundTile = new Image("com/herosandwich/menus/ground_tile.png");

    private static SpriteMap instance;

    private SpriteMap() {
        sprites.put(new Integer(1), groundTile);
    }

    public static SpriteMap getInstance() {
        if(instance == null)
            instance = new SpriteMap();
        return instance;

    }
    public Image getImageForKey(Integer key) {
        return sprites.get(key);
    }
}
