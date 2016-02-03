package models.menus;
import java.util.ArrayList;
public class CustomizeMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public CustomizeMenu(){
    super(new Selection[]{Selection.SETNAME, Selection.SETGENDER, Selection.SETOCCUPATION,
          Selection.SETHAIRCOLOR},
          new ArrayList<Listener>());
  }


}
