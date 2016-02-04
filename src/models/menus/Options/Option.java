package models.menus.options;

public abstract class Option{
  protected String name = "";
  public abstract void execute();
  public String toString(){return name;};
}
