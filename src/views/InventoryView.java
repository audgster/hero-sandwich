package views;
import views.View;
import models.menus.*;
import models.menus.options.Option;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import models.entities.*;
import java.util.ArrayList;
import models.items.*;



public class InventoryView extends View{
  private Entity avatar;
  private Inventory inventory;
  private Equipment equipment;
  private ArrayList<Item> inventoryBag;
  protected String[] options;
  protected InventoryMenu menu;
  protected int currentIndex;
  private String[] items;
  protected Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 40);

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


    // draw info panel
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

    // draw menu panel
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
      if(currentIndex == i){
        label.setOpaque(true);
      }
      else{
        label.setOpaque(false);
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
    String imgPath = "../images/blank_slot.jpg";

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

  public void update(){
    Item currentlySelectedItem = menu.getCurrentlySelectedItem();
    for(int i = 0; i < inventoryBag.size(); i++){
			if(inventoryBag.get(i) == currentlySelectedItem){
				currentIndex = i;
			}
		}

    render();
  }
}
