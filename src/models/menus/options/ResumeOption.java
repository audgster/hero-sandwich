package models.menus.options;
import views.ViewManager;
import controllers.*;

public class ResumeOption extends Option{
	public ResumeOption(){
		name = "Resume";
	}
	public void execute(ViewManager vm, Controller cm){
		cm.changeState();
		vm.setGameModeAgain();
  }
}
