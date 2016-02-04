package models.menus;
import java.util.ArrayList;

public abstract class Menus{
  private Option currentlySelected;
  private Option[] listOfOptions;
  private ArrayList<Listener> listenerList;
  private int listPosition;

  protected Menus(Option[] listOfOptions, ArrayList<Listener> listenerList){
    this.listOfOptions = listOfOptions;
    this.listenerList = listenerList;
    listPosition = 0;
    currentlySelected = listOfOptions[0];
  }
  /*
    Based of the idea that a menu starts at position 0
    ex:
     __________________
    | START       0   |
    | PAUSE       1   |
    | EQUIPTMENT  2   |
    | INVENTORY   3   |
    |_________________|
   */
  public void scrollDown(){
    if(listPosition < listOfOptions.length - 1){
      currentlySelected = listOfOptions[++listPosition];
      notifyListeners();
    }
  }

  public void scrollUp(){
    if(listPosition > 0){
      currentlySelected = listOfOptions[--listPosition];
      notifyListeners();
      //... make view to move using drawable
    }
  }

  public void addListener(Listener listener) {
    listenerList.add(listener);
  }

  protected void notifyListeners() {
    for(int i = 0; i < listenerList.size(); i++) {
      listenerList.get(i).update();
    }
  }

  public void enter(){
      notifyListeners();
  }

  //get methods
  public Option[] getListOfOptions(){
    return listOfOptions;
  }

  public Option getCurrentlySelected(){
    return currentlySelected;
  }
}
