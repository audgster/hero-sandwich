package models.menus.options;
import views.*;
import controllers.*;
import util.*;
import initialization.AvatarCreator;
import models.entities.*;
import models.gameengine.*;

 public  class SmasherOption extends Option{
 	public SmasherOption(){
   		name = "Smasher";
 	}
	public void execute(ViewManager vm, Controller cm){
		Game game = new Game(new HardCodedGameEngineInitializer());
		game.newGame();		

		AvatarCreator ac = new AvatarCreator();
		ac.setName("Brandon");
		ac.setOccupation(new Smasher());
		Entity avatar = ac.vendCustomEntity();

		Level level = game.getLevel();
		AreaView area = new AreaView(level, avatar);

		cm.changeState();
		cm.setGame(game);
	}
}

