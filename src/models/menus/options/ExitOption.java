package models.menus.options;
import views.*;

public  class ExitOption extends Option{
	public ExitOption(){
		name = "Exit";
	}
	public void execute(ViewManager vm){
		System.exit(0);
	}
}
