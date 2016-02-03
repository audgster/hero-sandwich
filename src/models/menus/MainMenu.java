package menu;

import java.util.ArrayList;
public class MainMenu extends Menu{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public MainMenu(){
    super(new Selection[]{Selection.NEWGAME, Selection.LOADGAME, Selection.EXIT},
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
