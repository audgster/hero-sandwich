public class EquipmentMenu extends Menu{
  private Selection currentlySelected;

  /*
   * Default constructor
   */
  public EquipmentMenu(){
    super(new Selection[]{Selection.START, Selection.PAUSE, Selection.EQUITPTITEM});
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
