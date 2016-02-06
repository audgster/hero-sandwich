package models.menus;
import models.menus.options.*;
import views.Listener;
import views.ViewManager;

import java.util.ArrayList;
public class InventoryMenu extends Menus{
  private Option currentlySelected;

  /*
   * Default constructor
   */
  public InventoryMenu(ViewManager vm){
    super(new Option[]{new StartOption(), new PauseOption(),
            new EquiptItemOption(), new DropItemOption()}, new ArrayList<>(), vm);
  }
}
