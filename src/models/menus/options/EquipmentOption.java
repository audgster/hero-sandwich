package models.menus.options;
import views.*;
import controllers.*;
import models.menus.*;

public class EquipmentOption extends Option{
	public EquipmentOption(){
		name = "Equipment";
	}
	public void execute(ViewManager vm, Controller cm){
		Menus equipmentMenu = vm.getEquipmentMenu();
		cm.setMenu(equipmentMenu);
		vm.setEquipmentMenuMode();
	}
}
