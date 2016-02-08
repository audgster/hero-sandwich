package models.menus;

import models.menus.options.*;
import views.ViewManager;
import views.*;
import java.util.ArrayList;
public class GameOverMenu extends Menus{

  /*
   * Default constructor
   */
  public GameOverMenu(ViewManager vm){
      super(new Option[]{new NewGameOption(),
              new LoadGameOption(), new ExitOption()}, new ArrayList<Listener>(), vm);
  }

}
