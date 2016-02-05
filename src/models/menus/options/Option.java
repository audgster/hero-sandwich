package models.menus.options;
import views.*;

public abstract class Option{
  protected String name = "";

  public abstract void execute(ViewManager vm);
  public String toString(){return name;};
}
