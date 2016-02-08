package models.menus.options;
import views.*;
import controllers.*;
import models.menus.*;

public class InventoryOption extends Option{
	public InventoryOption(){
		name = "Inventory";
	}
	public void execute(ViewManager vm, Controller cm){
		Menus inventoryMenu = vm.getInventoryMenu();
		cm.setMenu(inventoryMenu);
		vm.setInventoryMenuMode();
  }
}
