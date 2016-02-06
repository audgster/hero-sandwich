package models.menus;

import models.menus.options.*;
import views.ViewManager;

import java.util.ArrayList;
public class PauseMenu extends Menus{

  /*
   * Default constructor
   */
  public PauseMenu(ViewManager vm){
    super(new Option[]{new PauseOption(), new ResumeOption(),
            new UnequiptItemOption()}, new ArrayList<>(), vm);
  }
}
