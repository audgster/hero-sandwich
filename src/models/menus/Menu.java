public abstract class Menu{
  private Selection currentlySelected;
  private Selection[] listOfOptions;
  private int listPosition;

  protected Menu(Selection[] listOfOptions){
    this.listOfOptions = listOfOptions;
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
      //... make view to move using drawable
      // update();
    }
  }

  public void scrollUp(){
    if(listPosition >= 0){
      currentlySelected = listOfOptions[--listPosition];
      //... make view to move using drawable
      update()
    }
  }

  // public void enter();

  //get methods
  public Selection[] getListOfOptions(){
    return listOfOptions;
  }

  public Selection getCurrentlySelected(){
    return currentlySelected;
  }

  // public void draw();
  public void update(){
  
  };
}
