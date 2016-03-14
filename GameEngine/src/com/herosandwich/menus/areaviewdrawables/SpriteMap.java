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


    private static Image waterTile = new Image("res/images/tiles/water_tile.png");
    private static Image groundTile = new Image("res/images/tiles/ground_tile.png");
    private static Image opaqueTile = new Image("res/images/tiles/opaque_tile.png");
    private static Image fogTile = new Image("res/images/tiles/fog_tile.png");
    private static Image smasher = new Image("res/images/entities/smasher/smasher.png");
    private static Image smasherNorth = new Image("res/images/entities/smasher/smasher1.png");
    private static Image smasherNorthEast = new Image("res/images/entities/smasher/smasher5.png");
    private static Image smasherSouthEast = new Image("res/images/entities/smasher/smasher3.png");
    private static Image smasherSouth     = new Image("res/images/entities/smasher/smasher0.png");
    private static Image smasherSouthWest = new Image("res/images/entities/smasher/smasher3.png");
    private static Image smasherNorthWest = new Image("res/images/entities/smasher/smasher4.png");

    private static Image moldySandwichImage = new Image("res/images/entities/moldySandwich/MoldySandwich.png");
    private static Image bootsOfAwesome = new Image("res/images/items/TheBootsOfAwesome.gif");
    private static Image olivePetNorth     = new Image("res/images/entities/olivepet/olivepet_north.png");
    private static Image olivePetNorthEast = new Image("res/images/entities/olivepet/olivepet_northeast.png");
    private static Image olivePetSouthEast = new Image("res/images/entities/olivepet/olivepet_southeast.png");
    private static Image olivePetSouth     = new Image("res/images/entities/olivepet/olivepet_south.png");
    private static Image olivePetSouthWest = new Image("res/images/entities/olivepet/olivepet_southwest.png");
    private static Image olivePetNorthWest = new Image("res/images/entities/olivepet/olivepet_northwest.png");


    private static SpriteMap instance;

    private SpriteMap() {
        sprites.put(1, groundTile);
        sprites.put(2, opaqueTile);
        sprites.put(3, fogTile);
        sprites.put(4, waterTile);
        sprites.put(101, smasher);
        sprites.put(102, smasherNorth);
        sprites.put(103, smasherNorthEast);
        sprites.put(104, smasherSouthEast);
        sprites.put(105, smasherSouth);
        sprites.put(106, smasherSouthWest);
        sprites.put(107, smasherNorthWest);
        sprites.put(110, moldySandwichImage);
        sprites.put(140, olivePetNorth);
        sprites.put(141, olivePetNorthEast);
        sprites.put(142, olivePetSouthEast);
        sprites.put(143, olivePetSouth);
        sprites.put(144, olivePetSouthWest);
        sprites.put(145, olivePetNorthWest);
        sprites.put(200, bootsOfAwesome);
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
