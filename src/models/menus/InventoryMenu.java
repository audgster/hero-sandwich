package models.menus;
import java.util.ArrayList;
public class InventoryMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public InventoryMenu(){
    super(new Selection[]{Selection.START, Selection.PAUSE, Selection.EQUITPTITEM, Selection.DROPITEM},
          new ArrayList<Listener>());
  }

}
