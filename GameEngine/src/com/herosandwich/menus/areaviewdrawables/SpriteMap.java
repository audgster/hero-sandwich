package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.creation.init.ItemInit;
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
    private static Image mountainTile = new Image("res/images/tiles/mountain_tile.png");
    private static Image opaqueTile = new Image("res/images/tiles/opaque_tile.png");
    private static Image fogTile = new Image("res/images/tiles/fog_tile.png");

    private static Image smasher = new Image("res/images/entities/smasher/smasher.png");
    private static Image smasherNorth = new Image("res/images/entities/smasher/smasher_north.png");
    private static Image smasherNorthEast = new Image("res/images/entities/smasher/smasher_northeast.png");
    private static Image smasherSouthEast = new Image("res/images/entities/smasher/smasher_southeast.png");
    private static Image smasherSouth     = new Image("res/images/entities/smasher/smasher_south.png");
    private static Image smasherSouthWest = new Image("res/images/entities/smasher/smasher_southeast.png");
    private static Image smasherNorthWest = new Image("res/images/entities/smasher/smasher_northwest.png");

    private static Image sneak = new Image("res/images/entities/sneak/sneak.png");
    private static Image sneakNorth = new Image("res/images/entities/sneak/sneak_north.png");
    private static Image sneakNorthEast = new Image("res/images/entities/sneak/sneak_northeast.png");
    private static Image sneakSouthEast = new Image("res/images/entities/sneak/sneak_southeast.png");
    private static Image sneakSouth = new Image("res/images/entities/sneak/sneak_south.png");
    private static Image sneakSouthWest = new Image("res/images/entities/sneak/sneak_southwest.png");
    private static Image sneakNorthWest = new Image("res/images/entities/sneak/sneak_northwest.png");


    private static Image summoner = new Image("res/images/entities/summoner/summoner.png");
    private static Image summonerNorth = new Image("res/images/entities/summoner/summoner_north.png");
    private static Image summonerNorthEast = new Image("res/images/entities/summoner/summoner_northeast.png");
    private static Image summonerSouthEast = new Image("res/images/entities/summoner/summoner_southeast.png");
    private static Image summonerSouth = new Image("res/images/entities/summoner/summoner_south.png");
    private static Image summonerSouthWest = new Image("res/images/entities/summoner/summoner_southwest.png");
    private static Image summonerNorthWest = new Image("res/images/entities/summoner/summoner_northwest.png");

    private static Image moldySandwichImage = new Image("res/images/entities/moldySandwich/MoldySandwich.png");
    private static Image bootsOfAwesome = new Image("res/images/items/TheBootsOfAwesome.gif");
    private static Image olivePetNorth     = new Image("res/images/entities/olivepet/olivepet_north.png");
    private static Image olivePetNorthEast = new Image("res/images/entities/olivepet/olivepet_northeast.png");
    private static Image olivePetSouthEast = new Image("res/images/entities/olivepet/olivepet_southeast.png");
    private static Image olivePetSouth     = new Image("res/images/entities/olivepet/olivepet_south.png");
    private static Image olivePetSouthWest = new Image("res/images/entities/olivepet/olivepet_southwest.png");
    private static Image olivePetNorthWest = new Image("res/images/entities/olivepet/olivepet_northwest.png");

    // Obstacle
    private static Image wall = new Image("res/images/items/wall.png");

    // interactable
    private static Image enemybutton = new Image("res/images/items/enemybutton.png");
    private static Image lockeddoor = new Image("res/images/items/lockeddoor.png");
    private static Image lockeddooroop = new Image("res/images/items/lockeddooroop.png");

    // oneshot
    private static Image extraloaf = new Image("res/images/items/extraloaf.png");
    private static Image coppercoin = new Image("res/images/items/coppercoin.png");
    private static Image silvercoin = new Image("res/images/items/silvercoin.png");
    private static Image goldcoin = new Image("res/images/items/goldcoin.png");

    // takeable
    private static Image key = new Image("res/images/items/key.png");
    private static Image checkplusplus = new Image("res/images/items/checkplusplus.png");

    // consumeable
    private static Image hpminor = new Image("res/images/items/minorhealth.png");
    private static Image hpmoderate = new Image("res/images/items/moderatehealth.png");
    private static Image hpmajor = new Image("res/images/items/majorhealth.png");
    private static Image manaminor = new Image("res/images/items/manaminor.png");
    private static Image manamoderate = new Image("res/images/items/manamoderate.png");
    private static Image manamajor = new Image("res/images/items/manamajor.png");

    // equipable bread
    private static Image wonderbread = new Image("res/images/items/wonderbread.png");
    private static Image marblerye = new Image("res/images/items/marblerye.png");
    private static Image ciabatta = new Image("res/images/items/ciabatta.png");
    private static Image hoagie = new Image("res/images/items/hoagie.png");

    // equipable meat
    private static Image rbeef = new Image("res/images/items/roastbeef.png");
    private static Image rrbeef = new Image("res/images/items/rareroastbeef.png");
    private static Image ham = new Image("res/images/items/ham.png");
    private static Image turkey = new Image("res/images/items/turkey.png");
    private static Image veggie = new Image("res/images/items/veggieburger.png");

    // equipable veggie
    private static Image lettuce = new Image("res/images/items/lettuce.png");
    private static Image tomato = new Image("res/images/items/tomato.png");
    private static Image onion = new Image("res/images/items/onion.png");
    private static Image pickles = new Image("res/images/items/pickels.png");
    private static Image bananapep = new Image("res/images/items/bananapepper.png");

    // equipable cheese
    private static Image cheddar = new Image("res/images/items/cheddar.png");
    private static Image american = new Image("res/images/items/american.png");
    private static Image provolone = new Image("res/images/items/provolone.png");
    private static Image swiss = new Image("res/images/items/cheese.png");
    private static Image pepperjack = new Image("res/images/items/pepperjack.png");

    // equipable shield
    private static Image cellophane = new Image("res/images/items/celophane.png");
    private static Image aluminum = new Image("res/images/items/aluminumfoil.png");

    // smasher weapon brawler
    private static Image fistwrap = new Image("res/images/items/handwraps.png");
    private static Image jalapenopooper = new Image("res/images/items/jalapenopoppers.png");
    private static Image knucklesand = new Image("res/images/items/knucklesandwich.png");

    // smasher weapon 1 hand
    private static Image frenchfry = new Image("res/images/items/limpfrenchfry.png");
    private static Image toothpick = new Image("res/images/items/toothpick.png");
    private static Image plasticsword = new Image("res/images/items/plasticsword.png");

    // smasher weapon 2 hand
    private static Image butterknife = new Image("res/images/items/butterknife.png");
    private static Image picklespear = new Image("res/images/items/PickleSpear.png");
    private static Image serratedknife = new Image("res/images/items/serratedknife.png");

    // sneak 1 handed
    private static Image pcshiv = new Image("res/images/items/potatoshiv.png");

    // sneak ranged
    private static Image peashooter = new Image("res/images/items/peashooter.png");
    private static Image orchakram = new Image("res/images/items/chakram.png");
    private static Image ketchupBlaster = new Image("res/images/items/ketchupblaster.png");

    // summoner
    private static Image celerystaff = new Image("res/images/items/celerystaff.png");
    private static Image kitchenstaff = new Image("res/images/items/kitchenstaff.png");


    private static SpriteMap instance;

    private SpriteMap() {
        sprites.put(ItemInit.ItemNames.WALL.ordinal(), wall);

        sprites.put(ItemInit.ItemNames.ENEMY_BUTTON.ordinal(), enemybutton);
        sprites.put(ItemInit.ItemNames.LOCKED_DOOR.ordinal(), lockeddoor);
        sprites.put(ItemInit.ItemNames.LOCKED_DOOR_OOP.ordinal(), lockeddooroop);

        sprites.put(ItemInit.ItemNames.EXTRA_LOAF.ordinal(), extraloaf);
        sprites.put(ItemInit.ItemNames.COPPER_COIN.ordinal(), coppercoin);
        sprites.put(ItemInit.ItemNames.SILVER_COIN.ordinal(), silvercoin);
        sprites.put(ItemInit.ItemNames.GOLD_COIN.ordinal(), goldcoin);

        sprites.put(ItemInit.ItemNames.KEY.ordinal(), key);
        sprites.put(ItemInit.ItemNames.CHECK_PLUS_PLUS.ordinal(), checkplusplus);

        sprites.put(ItemInit.ItemNames.HEALTH_POTION_MINOR.ordinal(), hpminor);
        sprites.put(ItemInit.ItemNames.HEALTH_POTION_MODERATE.ordinal(), hpmoderate);
        sprites.put(ItemInit.ItemNames.HEALTH_POTION_MAJOR.ordinal(), hpmajor);
        sprites.put(ItemInit.ItemNames.MANA_POTION_MINOR.ordinal(), manaminor);
        sprites.put(ItemInit.ItemNames.MANA_POTION_MODERATE.ordinal(), manamoderate);
        sprites.put(ItemInit.ItemNames.MANA_POTION_MAJOR.ordinal(), manamajor);

        sprites.put(ItemInit.ItemNames.WONDER_BREAD.ordinal(), wonderbread);
        sprites.put(ItemInit.ItemNames.MARBLE_RYE.ordinal(), marblerye);
        sprites.put(ItemInit.ItemNames.CIABATTA.ordinal(), ciabatta);
        sprites.put(ItemInit.ItemNames.HOAGIE_ROLL.ordinal(), hoagie);

        sprites.put(ItemInit.ItemNames.ROAST_BEEF.ordinal(), rbeef);
        sprites.put(ItemInit.ItemNames.RARE_ROAST_BEEF.ordinal(), rrbeef);
        sprites.put(ItemInit.ItemNames.HAM.ordinal(), ham);
        sprites.put(ItemInit.ItemNames.TURKEY.ordinal(), turkey);

        sprites.put(ItemInit.ItemNames.VEGGIE_PATTY.ordinal(), veggie);
        sprites.put(ItemInit.ItemNames.LETTUCE.ordinal(), lettuce);
        sprites.put(ItemInit.ItemNames.TOMATO.ordinal(), tomato);
        sprites.put(ItemInit.ItemNames.ONION.ordinal(), onion);
        sprites.put(ItemInit.ItemNames.PICKLES.ordinal(), pickles);
        sprites.put(ItemInit.ItemNames.BANANA_PEPPERS.ordinal(),bananapep);

        sprites.put(ItemInit.ItemNames.CHEDDAR.ordinal(), cheddar);
        sprites.put(ItemInit.ItemNames.AMERICAN.ordinal(), american);
        sprites.put(ItemInit.ItemNames.PROVOLONE.ordinal(), provolone);
        sprites.put(ItemInit.ItemNames.SWISS.ordinal(), swiss);
        sprites.put(ItemInit.ItemNames.PEPPER_JACK.ordinal(), pepperjack);

        sprites.put(ItemInit.ItemNames.CELLOPHANE.ordinal(), cellophane);
        sprites.put(ItemInit.ItemNames.ALUMINUM_FOIL.ordinal(), aluminum);

        sprites.put(ItemInit.ItemNames.FIST_WRAPS.ordinal(), fistwrap);
        sprites.put(ItemInit.ItemNames.JALAPENO_POPPERS.ordinal(), jalapenopooper);
        sprites.put(ItemInit.ItemNames.KNUCKLE_SANDWICH.ordinal(), knucklesand);

        sprites.put(ItemInit.ItemNames.FRENCH_FRY.ordinal(), frenchfry);
        sprites.put(ItemInit.ItemNames.TOOTHPICK.ordinal(), toothpick);
        sprites.put(ItemInit.ItemNames.PLASTIC_SWORD.ordinal(), plasticsword);

        sprites.put(ItemInit.ItemNames.BUTTER_KNIFE.ordinal(), butterknife);
        sprites.put(ItemInit.ItemNames.PICKLE_SPEAR.ordinal(), picklespear);
        sprites.put(ItemInit.ItemNames.SERRATED_KNIFE.ordinal(), serratedknife);

        sprites.put(ItemInit.ItemNames.POTATO_CHIP_SHIV.ordinal(), pcshiv);

        sprites.put(ItemInit.ItemNames.PEA_SHOOTER.ordinal(), peashooter);
        sprites.put(ItemInit.ItemNames.ONION_RING_CHAKRAM.ordinal(), orchakram);
        sprites.put(ItemInit.ItemNames.KETCHUP_BLASTER.ordinal(), ketchupBlaster);

        sprites.put(ItemInit.ItemNames.CELERY_STAFF.ordinal(), celerystaff);
        sprites.put(ItemInit.ItemNames.KITCHEN_STAFF.ordinal(), kitchenstaff);


        sprites.put(101, smasher);
        sprites.put(102, smasherNorth);
        sprites.put(103, smasherNorthEast);
        sprites.put(104, smasherSouthEast);
        sprites.put(105, smasherSouth);
        sprites.put(106, smasherSouthWest);
        sprites.put(107, smasherNorthWest);

        sprites.put(110, moldySandwichImage);

        sprites.put(111, sneak);
        sprites.put(112, sneakNorth);
        sprites.put(113, sneakNorthEast);
        sprites.put(114, sneakSouthEast);
        sprites.put(115, sneakSouth);
        sprites.put(116, sneakSouthWest);
        sprites.put(117, sneakNorthWest);

        sprites.put(118, summoner);
        sprites.put(119, summonerNorth);
        sprites.put(120, summonerNorthEast);
        sprites.put(121, summonerSouthEast);
        sprites.put(122, summonerSouth);
        sprites.put(123, summonerSouthWest);
        sprites.put(124, summonerNorthWest);

        sprites.put(140, olivePetNorth);
        sprites.put(141, olivePetNorthEast);
        sprites.put(142, olivePetSouthEast);
        sprites.put(143, olivePetSouth);
        sprites.put(144, olivePetSouthWest);
        sprites.put(145, olivePetNorthWest);
        sprites.put(200, bootsOfAwesome);

        sprites.put(201, waterTile);
        sprites.put(202, groundTile);
        sprites.put(203, mountainTile);
        sprites.put(204, opaqueTile);
        sprites.put(205, fogTile);
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
