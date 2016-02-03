package models.menus;

import java.util.ArrayList;
public class MainMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public MainMenu(){
    super(new Selection[]{Selection.NEWGAME, Selection.LOADGAME, Selection.EXIT},
          new ArrayList<Listener>());
  }
}
