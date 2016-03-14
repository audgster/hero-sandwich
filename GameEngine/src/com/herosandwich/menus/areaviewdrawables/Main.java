package com.herosandwich.menus.areaviewdrawables;


import com.herosandwich.creation.GameFactory;
import com.herosandwich.creation.entity.NpcFactory;
import com.herosandwich.creation.init.ItemInit;
import com.herosandwich.creation.init.NpcStats;
import com.herosandwich.models.Game;
import com.herosandwich.models.entity.Npc;
import com.herosandwich.models.items.obstacleItems.ObstacleItem;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.aoe.TakeDamageAoE;
import com.herosandwich.models.map.aoe.TeleportAoE;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.persistence.XmlLoader;
import com.herosandwich.util.persistence.XmlSaver;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader(new File("map.xml"));
        Game game = xmlLoader.loadGame();

        Map map = game.getMap();

        ItemInit init = ItemInit.getInstance();

        TakeableItem item1 = init.getTakeableItem(ItemInit.ItemNames.AMERICAN.ordinal());

        GameFactory gameFactory = new GameFactory();


        TeleportAoE teleportAoE = new TeleportAoE(new PositionHex(3,-3), new PositionHex(0,0));

        Npc npc = gameFactory.vendMoldySandwichNpc(NpcStats.Strength.AVERAGE);

        map.addAoE(new PositionHex(3,-3), teleportAoE);

        map.addEntity(new PositionHex(2,1), npc);

        // map.addEntity(new PositionHex(1, 2), npc);

        map.addItem(new PositionHex(-1, 1), item1);

        XmlSaver saver = new XmlSaver(new File("MyNewMap.xml"));
        saver.saveGame(game);


    }
}
