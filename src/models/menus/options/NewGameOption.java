package models.menus.options;
import views.*;

public class NewGameOption extends Option{
	public NewGameOption(){
		name = "New Game";
	}
  	public void execute(ViewManager vm){
				vm.setGameMode();
				vm.update();
				System.out.println("In here");
				//
  	}
}
