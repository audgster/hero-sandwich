package models.menus.options;
import views.*;
import controllers.*;

public  class ExitOption extends Option{
	public ExitOption(){
		name = "Exit";
	}
	public void execute(ViewManager vm, Controller cm){
		System.exit(0);
	}
}
