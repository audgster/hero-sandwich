package models.menus.options;
import views.*;
import controllers.*;

public class BackOption extends Option{
	public BackOption(){
		name = "Back";
	}
	public void execute(ViewManager vm, Controller cm){
    cm.changeState();
		vm.setGameModeAgain();
  }
}
