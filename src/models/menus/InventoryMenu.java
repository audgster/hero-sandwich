package models.menus;
import models.menus.options.*;
import views.Listener;
import views.ViewManager;
import models.entities.Entity;
import java.util.ArrayList;

public class InventoryMenu extends Menus{
  private Option currentlySelected;
  private Entity avatar;

  /*
   * Default constructor
   */
  public InventoryMenu(ViewManager vm, Entity avatar){
    super(new Option[]{new ResumeOption(), new PauseOption(),
            new EquipItemOption(), new DropItemOption()}, new ArrayList<Listener>(), vm);
    this.avatar = avatar;
  }
}
