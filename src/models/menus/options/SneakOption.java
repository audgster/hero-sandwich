package models.menus.options;
import views.*;
import controllers.*;
import util.*;
import initialization.AvatarCreator;
import models.entities.*;
import models.gameengine.*;
import models.*;
import models.menus.*;

 public  class SneakOption extends Option{
 	public SneakOption(){
   		name = "Sneak";
 	}
	public void execute(ViewManager vm, Controller cm){
		Game game = new Game(new HardCodedGameEngineInitializer());
		game.newGame();

		System.out.println("controller1 state is " + cm.state.toString());
		cm.setGame(game);
		System.out.println("controller2 state is " + cm.state.toString());

		AvatarCreator ac = new AvatarCreator();
		ac.setName("Brandon");
		ac.setOccupation(new Sneak());
		Entity avatar = ac.vendCustomEntity();
		avatar.addListener(vm);
		game.initializeAvatar(avatar);

		Level level = game.getLevel();

    	Menus inventoryMenu = new InventoryMenu(vm, avatar);
    	inventoryMenu.setController(cm);
    	Menus equipmentMenu = new EquipmentMenu(vm, avatar);
    	equipmentMenu.setController(cm);
    	vm.setInventoryMenu(inventoryMenu);
    	vm.setEquipmentMenu(equipmentMenu);

    	Menus gameOverMenu = new GameOverMenu(vm);
    	gameOverMenu.setController(cm);
    	vm.setGameOverMenu(gameOverMenu);
    	
		vm.setGameMode(level, avatar);
	}
}