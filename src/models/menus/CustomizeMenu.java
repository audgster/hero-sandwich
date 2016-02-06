package models.menus;
import models.menus.options.*;
import views.Listener;
import views.ViewManager;

import java.util.ArrayList;
public class CustomizeMenu extends Menus{

  /*
   * Default constructor
   */
  public CustomizeMenu(ViewManager vm) {
      super(new Option[]{new SmasherOption(), new SummonerOption(), new SneakOption()}, 
      new ArrayList<Listener>(), vm);
  }
}
