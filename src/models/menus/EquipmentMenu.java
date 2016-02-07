package models.menus;

import models.menus.options.*;
import views.Listener;
import views.ViewManager;
import java.util.ArrayList;
import models.entities.Entity;

public class EquipmentMenu extends Menus{
  private Entity avatar;
  /*
   * Default constructor
   */
    public EquipmentMenu(ViewManager vm, Entity avatar){
        super(new Option[]{new StartOption(), new PauseOption(),
                new UnequipItemOption()}, new ArrayList<Listener>(), vm);
        this.avatar = avatar;
    }

}
