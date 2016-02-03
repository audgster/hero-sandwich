package models.menus;

import java.util.ArrayList;
public class PauseMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public PauseMenu(){
    super(new Selection[]{Selection.PAUSE, Selection.RESUME},
          new ArrayList<Listener>());
  }
}
