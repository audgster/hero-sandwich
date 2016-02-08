package views;
import views.View;
import models.menus.*;
import models.menus.options.Option;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Dimension;

public class InventoryView extends MenuView{

  public InventoryView(Menus menu){
		super(menu);
		setLayout( new BorderLayout() );
    update();
	}

  protected void render(){
    removeAll();

    Border grayMatteBorder = BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.black);
    //Dimension panelD = new Dimension(this.getWidth()/3, this.getHeight() );

    // draw title
    JLabel title = new JLabel("Inventory");
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    title.setFont(menuFont);
    add(title, BorderLayout.PAGE_START);
    title.setBorder(grayMatteBorder);

    // draw menu panel
    JPanel menuPanel = new JPanel();
    // put JLabels in a column
    menuPanel.setLayout( new BoxLayout(menuPanel, BoxLayout.Y_AXIS ) );
    //menuPanel.setPreferredSize(panelD);
    add(menuPanel, BorderLayout.WEST);
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

    // draw inventory panel
    JPanel inventoryPanel = new JPanel();
    // put JLabels in a column
    inventoryPanel.setLayout( new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS ) );
    //inventoryPanel.setPreferredSize(panelD);
    add(inventoryPanel, BorderLayout.CENTER);
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
    gBC.insets = new Insets(10,0,0,0);
    JPanel equipmentPanel = new JPanel(new GridBagLayout());
    //equipmentPanel.setPreferredSize(panelD);
    equipmentPanel.setBorder(grayMatteBorder);
    GridBagConstraints gBC = new GridBagConstraints();
    JLabel[] grids = new JLabel[5];
    String imgPath = "../images/blank_slot.jpg";

    for(int i = 0; i < 4; i++){
      grids[i] = new JLabel(new ImageIcon(imgPath));
      gBC.gridx = 0;
      gBC.gridy = i;
      equipmentPanel.add(grids[i], gBC);
    }

    grids[4] = new JLabel(new ImageIcon(imgPath));
    gBC.gridx = 1;
    gBC.gridy = 1;
    equipmentPanel.add(grids[4], gBC);

    add(equipmentPanel, BorderLayout.EAST);
    revalidate();
    repaint();
  }
}
