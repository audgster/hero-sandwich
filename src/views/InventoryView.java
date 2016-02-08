package views;
import models.menus.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import models.entities.*;
import java.util.ArrayList;
import models.items.*;
import util.HardCodedSpriteInitializer;
import util.SpriteMap;

public class InventoryView extends View{
  private Entity avatar;
  private Inventory inventory;
  private Equipment equipment;
  private ArrayList<Item> inventoryBag;
  protected String[] options;
  protected InventoryMenu menu;
  protected int currentIndex;
  private String[] items;
  private JPanel backPanel = new JPanel();
  protected Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 40);
    private SpriteMap spriteMap = new SpriteMap(new HardCodedSpriteInitializer());

  public InventoryView(Menus menu, Entity avatar){
    this.menu = (InventoryMenu)menu;
    this.avatar = avatar;
    this.inventory = avatar.getInventory();
    this.inventoryBag = inventory.getBag();
    this.equipment = avatar.getEquipment();
    setLayout(new GridBagLayout());
    update();
	}

  protected void render(){
    removeAll();
    backPanel.removeAll();
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
    mainGBC.gridy = 0;
    mainGBC.weighty = 0.1;
    mainGBC.gridwidth = 3;
    add(title, mainGBC);


    // draw Info panel
    JPanel infoPanel = new JPanel();
    // put JLabels in a column
    infoPanel.setLayout( new BoxLayout(infoPanel, BoxLayout.Y_AXIS ) );
    infoPanel.setBorder(grayMatteBorder);
    JLabel currentItemInfo;
    Item currentItem = inventory.getItemAt(currentIndex);
    if(currentItem != null){
      currentItemInfo = new JLabel(currentItem.getDescription());
    }else{
      currentItemInfo = new JLabel("No Item Selected");
    }
    currentItemInfo.setFont(menuFont);
    infoPanel.add(currentItemInfo);
    mainGBC.gridy = 1;
    mainGBC.gridx = 0;
    mainGBC.weightx = 0.5;
    mainGBC.weighty = 0.9;
    mainGBC.gridwidth = 1;
    add(infoPanel, mainGBC);

    // draw Inventory panel
    JPanel menuPanel = new JPanel();
    // put JLabels in a column
    menuPanel.setLayout( new BoxLayout(menuPanel, BoxLayout.Y_AXIS ) );
    menuPanel.setBorder(grayMatteBorder);

    for(int i = 0; i < inventoryBag.size(); i++){
      currentItem = inventoryBag.get(i);
      JLabel label;
      if(currentItem != null){
        label = new JLabel(currentItem.getName());
      }else{
        label = new JLabel("----");
      }

      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      label.setBackground(Color.GREEN);
      label.setFont(menuFont);
      if(currentIndex == i && menu.getCurrentlySelected() == null){
        label.setOpaque(true);
        backPanel.setOpaque(false);
      }
      else if(menu.getCurrentlySelected() != null){
        backPanel.setOpaque(true);
      }
      else{
        label.setOpaque(false);
        backPanel.setOpaque(false);
      }
      menuPanel.add(label);
    }

    mainGBC.gridy = 1;
    mainGBC.gridx = 1;
    mainGBC.weightx = 0.5;
    mainGBC.fill = GridBagConstraints.BOTH;
    add(menuPanel, mainGBC);


    JPanel equipmentPanel = new JPanel(new GridBagLayout());
    equipmentPanel.setBorder(grayMatteBorder);
    GridBagConstraints subGBC = new GridBagConstraints();
    JLabel[] grids = new JLabel[5];
    String imgPath = "resources/images/blank_slot.jpg";

    int j = 0;

    for (EquipableItem i : equipment.getEquipped())
    {
        try {
            grids[j] = new JLabel(new ImageIcon(spriteMap.getResourcePath(i.getImageId())));
        }
        catch (Exception ex)
        {
            grids[j] = new JLabel(new ImageIcon(imgPath));
        }

        subGBC.insets = new Insets(10,0,0,0);  //top padding
        subGBC.gridx = 0;
        subGBC.gridy = j;
        equipmentPanel.add(grids[j], subGBC);
        j++;
    }

    while (j < 4)
    {
        grids[j] = new JLabel(new ImageIcon(imgPath));

        subGBC.insets = new Insets(10,0,0,0);  //top padding
        subGBC.gridx = 0;
        subGBC.gridy = j;
        equipmentPanel.add(grids[j], subGBC);

        j++;
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


    // draw back Panel
    backPanel.setBorder(grayMatteBorder);
    backPanel.setBackground(Color.GREEN);
    JLabel backText = new JLabel("Back");
    backText.setAlignmentX(Component.CENTER_ALIGNMENT);
    backText.setFont(menuFont);
    backPanel.add(backText);
    mainGBC.gridx = 0;
    mainGBC.gridy = 2;
    mainGBC.weighty = 0.1;
    mainGBC.gridwidth = 3;
    add(backPanel, mainGBC);

    revalidate();
    repaint();
  }

  public void update(){
    Item currentlySelectedItem = menu.getCurrentlySelectedItem();
    System.out.println("The current selected item is " + currentlySelectedItem);
    System.out.println("The item in position 0 is" + inventoryBag.get(0));
    for(int i = 0; i < inventoryBag.size(); i++){
			if(inventoryBag.get(i) == currentlySelectedItem){
				currentIndex = i;
			}
		}

    render();
  }
}
