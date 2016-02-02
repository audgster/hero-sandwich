public class View implements Listener {
  MainMenu menu;
  public View(MainMenu menu) {
    this.menu = menu;
    addAsListener();
  }

  public void update() {
    System.out.println("Hey we have to update the Main Menu!");
  }

  private void addAsListener() {
    menu.addListener(this);
  }
}
