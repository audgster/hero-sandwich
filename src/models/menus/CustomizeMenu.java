package models.menus;
import java.util.ArrayList;
public class CustomizeMenu extends Menus{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public CustomizeMenu(){
    super(new Selection[]{Selection.SETGENDER, Selection.SETOCCUPATION, Selection.SETHAIRCOLOR},
          new ArrayList<Listener>());
  }

  public void scrollDown(){
    super.scrollDown();
  }

  public void scrollUp(){
    super.scrollUp();
  }

  public void enter(){
    System.out.println(getCurrentlySelected().toString());
  }

  public void addListener(Listener listener) {
    super.addListener(listener);
  }

  protected void notifyListeners() {
    super.notifyListeners();
  }

  //get methods
  public Selection[] getListOfOptions(){
    return super.getListOfOptions();
  }

  public Selection getCurrentlySelected(){
    return super.getCurrentlySelected();
  }
}
