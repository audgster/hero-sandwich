package models.menus;
import models.menus.options.*;
import models.entities.Entity;
import models.items.*;
import views.Listener;
import views.ViewManager;
import controllers.*;
import java.util.ArrayList;


public class InventoryMenu extends Menus{
  private Entity avatar;
  private Item currentlySelectedItem;
  private ArrayList<Item> listOfItems;
  private Controller cm;
  private ViewManager vm;

  /*
   * Default constructor
   */
  public InventoryMenu(ViewManager vm, Entity avatar){
    super(new Option[]{new BackOption()}, new ArrayList<Listener>(), vm);
    this.avatar = avatar;
    this.listOfItems = avatar.getInventory().getBag();
    currentlySelected = null;
  }

  public void setCurrentlySelectedItem(Item item){
    this.currentlySelectedItem = item;
  }

  public Item getCurrentlySelectedItem(){
    return this.currentlySelectedItem;
  }

  public void enter(){
    if(currentlySelected != null){
      currentlySelected.execute(vm, cm);
    }
    else{
      EquipableItem eq;
      try{
        eq = (EquipableItem)currentlySelectedItem;
      }catch(ClassCastException ex){
        return;
      }

      this.avatar.equip(eq);
      notifyListeners();
    }
  }


  public void scrollDown(){
    if(listPosition < listOfItems.size() - 1){
      currentlySelectedItem = listOfItems.get(++listPosition);
      currentlySelected = null;
    }
    else{
      currentlySelected = listOfOptions[0];
    }
    notifyListeners();
  }

  public void scrollUp(){
    if(listPosition > 0){
      currentlySelectedItem = listOfItems.get(--listPosition);
      currentlySelected = null;
      notifyListeners();
    }
  }

  public Entity getAvatar(){
    return avatar;
  }
  public Option getCurrentlySelected(){
    return currentlySelected;
  }
  public void setController(Controller cm){
    this.cm = cm;
  }
  public void setViewManager(ViewManager vm){
    this.vm = vm;
  }

}
