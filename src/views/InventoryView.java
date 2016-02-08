package views;
import views.View;
import models.menus.*;
import models.menus.options.Option;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class InventoryView extends MenuView{

  public InventoryView(Menus menu){
		super(menu);
		setLayout( new BorderLayout() );
		update();
	}

  protected void render(){
    removeAll();

    Border grayMatteBorder = BorderFactory.createMatteBorder( 1, 1, 1, 1, Color.black);
    
    // draw title
    JLabel title = new JLabel("Inventory");
    title.setAlignmentX(Component.CENTER_ALIGNMENT);        
    title.setFont(menuFont);
    add(title, BorderLayout.PAGE_START);
    title.setBorder(grayMatteBorder);
    
    // draw menu panel
    JPanel menuPanel = new JPanel();    
    add(menuPanel, BorderLayout.LINE_START);
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
    add(inventoryPanel, BorderLayout.CENTER);
    inventoryPanel.setBorder(grayMatteBorder);

    // draw options panel
    JPanel optionsPanel = new JPanel();    
    add(optionsPanel, BorderLayout.LINE_END);
    optionsPanel.setBorder(grayMatteBorder);
    
    /*
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
      add(label);
    }
    */

    revalidate();
    repaint();
  }
}
