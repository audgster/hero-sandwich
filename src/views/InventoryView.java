package views;
import models.menus.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class InventoryView extends MenuView{

  public InventoryView(Menus menu){
		super(menu);
		setLayout( new GridBagLayout());
    update();
	}

  protected void render(){
    removeAll();

    Border grayMatteBorder = BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.black);
    GridBagConstraints mainGBC = new GridBagConstraints();

    // draw title Panel
    JPanel titlePanel = new JPanel();
    titlePanel.setBorder(grayMatteBorder);
    JLabel title = new JLabel("Inventory");
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    title.setFont(menuFont);
    titlePanel.add(title);
    mainGBC.gridx = 0;
    mainGBC.weighty = 0.1;
    add(title, mainGBC);


    // draw menu panel
    JPanel menuPanel = new JPanel();
    // put JLabels in a column
    menuPanel.setLayout( new BoxLayout(menuPanel, BoxLayout.Y_AXIS ) );
    menuPanel.setBorder(grayMatteBorder);
    for(int i = 0; i < options.length; i++){
      JLabel label = new JLabel(options[i]);
      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      label.setBackground(Color.GREEN);
      label.setFont(menuFont);
      if(currentIndex == i){
        label.setOpaque(true);
      }
      else{
        label.setOpaque(false);
      }
      menuPanel.add(label);
    }
    mainGBC.gridy = 1;
    mainGBC.gridx = 0;
    mainGBC.weightx = 0.5;
    mainGBC.fill = GridBagConstraints.BOTH;
    mainGBC.weighty = 0.9;
    add(menuPanel, mainGBC);

    // draw inventory panel
    JPanel inventoryPanel = new JPanel();
    // put JLabels in a column
    inventoryPanel.setLayout( new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS ) );


    inventoryPanel.setBorder(grayMatteBorder);
    for(int i = 0; i < options.length; i++){
      JLabel label = new JLabel(options[i]);
      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      label.setBackground(Color.GREEN);
      label.setFont(menuFont);
      if(currentIndex == i){
        label.setOpaque(true);
      }
      else{
        label.setOpaque(false);
      }
      inventoryPanel.add(label);
    }
    mainGBC.gridy = 1;
    mainGBC.gridx = 1;
    mainGBC.weightx = 0.5;
    add(inventoryPanel, mainGBC);


    JPanel equipmentPanel = new JPanel(new GridBagLayout());
    equipmentPanel.setBorder(grayMatteBorder);
    GridBagConstraints subGBC = new GridBagConstraints();
    JLabel[] grids = new JLabel[5];
    String imgPath = "resources/images/blank_slot.jpg";

    for(int i = 0; i < 4; i++){
      grids[i] = new JLabel(new ImageIcon(imgPath));
      subGBC.insets = new Insets(10,0,0,0);  //top padding
      subGBC.gridx = 0;
      subGBC.gridy = i;
      equipmentPanel.add(grids[i], subGBC);
    }
    grids[4] = new JLabel(new ImageIcon(imgPath));
    subGBC.gridx = 1;
    subGBC.gridy = 1;
    subGBC.insets = new Insets(10,10,0,0);
    equipmentPanel.add(grids[4], subGBC);

    mainGBC.gridy = 1;
    mainGBC.gridx = 2;
    mainGBC.weightx = 0.5;
    add(equipmentPanel, mainGBC);

    revalidate();
    repaint();
  }
}
