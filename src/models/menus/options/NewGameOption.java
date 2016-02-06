package models.menus.options;
import views.*;
import controllers.*;
import models.menus.*;

public class NewGameOption extends Option{
	public NewGameOption(){
		name = "New Game";
	}

	public void execute(ViewManager vm, Controller cm){
		Menus customMenu = new CustomizeMenu(vm);
		vm.setCustomizeMenuMode(customMenu);
		cm.setMenu(customMenu);
	}
}
