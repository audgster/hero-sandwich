package models.menus.options;
import views.*;
import controllers.*;
import util.*;
import initialization.AvatarCreator;
import models.entities.*;
import models.gameengine.*;
import models.*;

 public  class SneakOption extends Option{
 	public SneakOption(){
   		name = "Sneak";
 	}
	public void execute(ViewManager vm, Controller cm){
		Game game = new Game(new HardCodedGameEngineInitializer());
		game.newGame();		

		AvatarCreator ac = new AvatarCreator();
		ac.setName("Brandon");
		ac.setOccupation(new Sneak());
		Entity avatar = ac.vendCustomEntity();

		Level level = game.getLevel();
		AreaView area = new AreaView(level, avatar);

		cm.changeState();
		cm.setGame(game);
		vm.setGameMode(level, avatar);
		vm.update();
	}
}
