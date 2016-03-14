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


    private static Image groundTile = new Image("res/images/tiles/ground_tile.png");
    private static Image opaqueTile = new Image("res/images/tiles/opaque_tile.png");
    private static Image fogTile = new Image("res/images/tiles/fog_tile.png");
    private static Image smasherImage = new Image("res/images/Smasher.png");
    private static Image moldySandwichImage = new Image("res/images/MoldySandwich.png");
    private static Image bootsOfAwesome = new Image("res/images/items/TheBootsOfAwesome.gif");

    private static Image testing = new Image("com/herosandwich/menus/sprite_avatar1.png");
    private static Image testing2 = new Image("com/herosandwich/menus/sprite_avatar2.png");


    private static SpriteMap instance;

    private SpriteMap() {
        sprites.put(1, groundTile);
        sprites.put(2, opaqueTile);
        sprites.put(3, fogTile);
        sprites.put(101, smasherImage);
        sprites.put(102, moldySandwichImage);
        sprites.put(200, bootsOfAwesome);

        //animation testing
        sprites.put(400,testing);
        sprites.put(401,testing2);
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
