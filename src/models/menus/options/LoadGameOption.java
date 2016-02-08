package models.menus.options;
import views.*;
import controllers.*;
import util.*;
import models.entities.*;
import models.gameengine.*;
import models.*;
import models.menus.*;

public class LoadGameOption extends Option{
	public LoadGameOption(){
		name = "Load Game";
	}
	public void execute(ViewManager vm, Controller cm){
		//
		Game game = new Game(new HardCodedGameEngineInitializer());
		game.loadGame();
		cm.setGame(game);
		
		Menus inventoryMenu = new InventoryMenu(vm, game.getAvatar());
    	inventoryMenu.setController(cm);
    	Menus equipmentMenu = new EquipmentMenu(vm, game.getAvatar());
    	equipmentMenu.setController(cm);
    	vm.setInventoryMenu(inventoryMenu);
    	vm.setEquipmentMenu(equipmentMenu);
		
		game.getAvatar().addListener(vm);

    	Menus gameOverMenu = new GameOverMenu(vm);
    	gameOverMenu.setController(cm);
    	vm.setGameOverMenu(gameOverMenu);
		
		vm.setGameMode(game.getCurrentLevel(), game.getAvatar());
  }
}
