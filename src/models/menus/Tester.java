public class Tester{
  public static void main(String[] args) {
    Menu e = new EquipmentMenu();
    Menu m = new MainMenu();
    View menuView = new View(m);
    System.out.println(e.getCurrentlySelected() );
    e.scrollDown();
    System.out.println(e.getCurrentlySelected());
    e.scrollDown();
    System.out.println(e.getCurrentlySelected());
    e.scrollDown();
    System.out.println(e.getCurrentlySelected());
    e.scrollUp();
    System.out.println(e.getCurrentlySelected());

    System.out.println("Main");

    System.out.println(m.getCurrentlySelected() );
    m.scrollDown();
  }
}
