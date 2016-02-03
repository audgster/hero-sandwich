package models.menus;

import java.util.ArrayList;
public class GameOverMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public GameOverMenu(){
    super(new Selection[]{Selection.EXITGAME, Selection.RESTARTGAME, Selection.SETTING},
          new ArrayList<Listener>());
  }

}
