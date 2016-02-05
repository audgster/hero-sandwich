package models.menus;
import models.menus.options.*;

import java.util.ArrayList;
import models.menus.options.*;
import views.*;
public class MainMenu extends Menus{

  /*
   * Default constructor
   */
  public MainMenu(ViewManager vm){
    super(new Option[]{new NewGameOption(), new LoadGameOption(),
          new ExitOption()}, new ArrayList<Listener>(), vm);
  }
}
