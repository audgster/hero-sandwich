package models.menus.options;
import views.*;
import controllers.*;
import models.menus.*;
import models.entities.*;

public class InventoryOption extends Option{
	public InventoryOption(){
		name = "Inventory";
	}
	public void execute(ViewManager vm, Controller cm){
		InventoryMenu inventoryMenu = (InventoryMenu)vm.getInventoryMenu();
		Entity avatar = inventoryMenu.getAvatar();
		inventoryMenu.setCurrentlySelectedItem(avatar.getInventory().getItemAt(0));
		cm.setMenu(inventoryMenu);
		vm.setInventoryMenuMode(inventoryMenu, avatar);
		inventoryMenu.setController(cm);

  }
}
