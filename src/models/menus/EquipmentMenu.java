package models.menus;

import models.menus.options.*;
import views.Listener;
import views.ViewManager;

import java.util.ArrayList;

public class EquipmentMenu extends Menus{
  /*
   * Default constructor
   */
    public EquipmentMenu(ViewManager vm){
        super(new Option[]{new StartOption(), new PauseOption(),
                new UnequiptItemOption()}, new ArrayList<Listener>(), vm);
    }

}
