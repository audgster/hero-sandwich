package models.menus;

import java.util.ArrayList;
public class MainMenu extends Menus{

  /*
   * Default constructor
   */
  public MainMenu(){
    super(new Option[]{new NewGameOption(), new LoadGameOption(),
          new ExitOption()}, new ArrayList<Listener>());
  }
}
