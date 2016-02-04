package models.menus;

import java.util.ArrayList;
import models.menus.options.*;
import views.*;
public class MainMenu extends Menus{

  /*
   * Default constructor
   */
  public MainMenu(){
    super(new Option[]{new NewGameOption(), new LoadGameOption(),
          new ExitOption()}, new ArrayList<Listener>());
  }
}
