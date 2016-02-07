package models.menus;

import models.menus.options.*;
import views.ViewManager;

import java.util.ArrayList;
public class GameOverMenu extends Menus{

  /*
   * Default constructor
   */
  public GameOverMenu(ViewManager vm){
      super(new Option[]{new ExitOption(), new NewGameOption(),
              new LoadGameOption()}, new ArrayList<Listener>(), vm);
  }

}
