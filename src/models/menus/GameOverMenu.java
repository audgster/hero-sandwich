package menu;

import java.util.ArrayList;
public class GameOverMenu extends Menu{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public GameOverMenu(){
    super(new Selection[]{Selection.EXITGAME, Selection.RESTARTGAME, Selection.SETTING},
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
