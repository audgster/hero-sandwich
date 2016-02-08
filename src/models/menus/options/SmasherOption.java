package models.menus.options;
import views.*;
import controllers.*;
import util.*;
import initialization.AvatarCreator;
import models.entities.*;
import models.gameengine.*;
import models.*;
import models.menus.*;

 public  class SmasherOption extends Option{
 	public SmasherOption(){
   		name = "Smasher";
 	}
	public void execute(ViewManager vm, Controller cm){
		Game game = new Game(new HardCodedGameEngineInitializer());
		game.newGame();

		System.out.println("controller1 state is " + cm.state.toString());
		cm.setGame(game);
		System.out.println("controller2 state is " + cm.state.toString());

		AvatarCreator ac = new AvatarCreator();
		ac.setName("Brandon");
		ac.setOccupation(new Smasher());
		Entity avatar = ac.vendCustomEntity();
		game.initializeAvatar(avatar);

		Level level = game.getLevel();

    Menus inventoryMenu = new InventoryMenu(vm, avatar);
    Menus equipmentMenu = new EquipmentMenu(vm, avatar);
    vm.setInventoryMenu(inventoryMenu);
    vm.setEquipmentMenu(equipmentMenu);

		vm.setGameMode(level, avatar);
	}
}
