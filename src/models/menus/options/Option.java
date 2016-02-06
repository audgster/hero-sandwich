package models.menus.options;
import views.*;
import controllers.*;

public abstract class Option{
  protected String name = "";

  public abstract void execute(ViewManager vm, Controller cm);
  public String toString(){return name;};
}
