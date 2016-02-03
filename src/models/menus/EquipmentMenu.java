package models.menus;

import java.util.ArrayList;
public class EquipmentMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public EquipmentMenu(){
    super(new Selection[]{Selection.START, Selection.PAUSE, Selection.UNEQUITPTITEM},
          new ArrayList<Listener>());
  }
}
