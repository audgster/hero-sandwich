package views;
import models.menus.*;

import java.awt.*;
import javax.swing.*;

public class EquipmentView extends MenuView{

  public EquipmentView(Menus menu){
    super(menu);
    setLayout(new GridBagLayout());
    update();
  }

  protected void render(){
    removeAll();

    GridBagConstraints gBC = new GridBagConstraints();
    JLabel inventoryTitle = new JLabel("Equipment");
    JLabel[] grids = new JLabel[5];

    String imgPath = "resources/images/blank_slot.jpg";
    gBC.anchor = GridBagConstraints.PAGE_START;
    gBC.weighty = 0.2;
    inventoryTitle.setFont(menuFont);
    add(inventoryTitle, gBC);

    for(int i = 0; i < 4; i++){
      grids[i] = new JLabel(new ImageIcon(imgPath));
      //gBC.insets = new Insets(10,0,0,0);
      gBC.gridx = 0;
      gBC.gridy = i + 1;
      add(grids[i], gBC);
    }

    grids[4] = new JLabel(new ImageIcon(imgPath));
    gBC.gridx = 1;
    gBC.gridy = 2;
    add(grids[4], gBC);

    revalidate();
    repaint();
  }
}
