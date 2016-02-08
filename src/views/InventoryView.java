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
    // put JLabels in a column
    menuPanel.setLayout( new BoxLayout(menuPanel, BoxLayout.Y_AXIS ) );        
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

    // draw options panel
    JPanel optionsPanel = new JPanel();    
    add(optionsPanel, BorderLayout.LINE_END);
    optionsPanel.setBorder(grayMatteBorder);
    // put JLabels in a column
    optionsPanel.setLayout( new BoxLayout(optionsPanel, BoxLayout.Y_AXIS ) );        
    add(optionsPanel, BorderLayout.EAST);
    optionsPanel.setBorder(grayMatteBorder);
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
      optionsPanel.add(label);
    }        
    
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
