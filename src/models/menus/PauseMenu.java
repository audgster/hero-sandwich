package models.menus;

import models.menus.options.*;
import controllers.*;
import views.ViewManager;
import views.*;
import java.util.ArrayList;
public class PauseMenu extends Menus{

  /*
   * Default constructor
   */
  public PauseMenu(ViewManager vm){
    super(new Option[]{new ResumeOption(),
            new InventoryOption(), new SaveGameOption(), new ExitOption()},
            new ArrayList<Listener>(), vm);
  }
}
