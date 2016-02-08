package models.menus;
import models.menus.options.*;
import models.entities.Entity;
import models.items.*;
import views.Listener;
import views.ViewManager;
import java.util.ArrayList;


public class InventoryMenu extends Menus{
  private Entity avatar;
  private Item currentlySelectedItem;
  private ArrayList<Item> listOfItems;

  /*
   * Default constructor
   */
  public InventoryMenu(ViewManager vm, Entity avatar){
    super(new Option[]{new ResumeOption(), new PauseOption(),
            new EquipItemOption(), new DropItemOption()}, new ArrayList<Listener>(), vm);
    this.avatar = avatar;
    this.listOfItems = avatar.getInventory().getBag();
    currentlySelectedItem = listOfItems.get(0);
    System.out.println("the avatar" + this.avatar);
  }

  public Item getCurrentlySelectedItem(){
    return this.currentlySelectedItem;
  }

  public void enter(){
    this.avatar.addItem(currentlySelectedItem);
    notifyListeners();
  }


  public void scrollDown(){
    if(listPosition < listOfItems.size() - 1){
      currentlySelectedItem = listOfItems.get(++listPosition);
      notifyListeners();
    }
  }

  public void scrollUp(){
    if(listPosition > 0){
      currentlySelectedItem = listOfItems.get(--listPosition);
      notifyListeners();
    }
  }

  public Entity getAvatar(){
    return avatar;
  }

}
