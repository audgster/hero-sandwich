public class MainMenu extends Menu{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public MainMenu(){
    super(new Selection[]{Selection.NEWGAME, Selection.LOADGAME, Selection.EXIT});
  }

  public void scrollDown(){
    super.scrollDown();
  }

  public void scrollUp(){
    super.scrollUp();
  }

  // public void enter(){
  //
  // }
  //
  // public Item unEquiptItem(Item item){
  //   //remove item from Equipted list
  // }

  //get methods
  public Selection[] getListOfOptions(){
    return super.getListOfOptions();
  }

  public Selection getCurrentlySelected(){
    return super.getCurrentlySelected();
  }
}
