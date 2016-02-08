package initialization;

import models.gameengine.HardCodedGameEngineInitializer;
import util.Game;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        //MapCreator mapCreator = new MapCreator("initialization/config.xml");
        //TestMap map = mapCreator.create();
        //map.printMap();
        //TextParser parser = new TextParser(new File("initialization/config.txt"));
        //parser.parseFile();
        // Game game = new Game();
        // game.newGame();
        Game game = new Game(new HardCodedGameEngineInitializer());
        //game.newGame();
        game.saveGame();
        GameLoader parser = new GameLoader(new File("resources/config/saveFile.txt"));
        parser.parseFile();
    }
}

