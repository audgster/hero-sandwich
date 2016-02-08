package models.menus.options;
import views.*;
import controllers.*;

public class SaveGameOption extends Option{
	public SaveGameOption(){
		name = "Save Game";
	}
	public void execute(ViewManager vm, Controller cm){
		//
		cm.getGame().saveGame();
		cm.changeState();
		vm.setGameModeAgain();
  }
}
