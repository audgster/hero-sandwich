package views;
import views.View;
import models.menus.*;
import models.menus.options.Option;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class EquipmentView extends MenuView{

  public EquipmentView(Menus menu){
    super(menu);
    setLayout(new GridBagLayout());
  }

  protected void render(){
    removeAll();
    Border blackline = BorderFactory.createLineBorder(Color.black);

    JPanel equipmentContainer = new JPanel(new GridLayout(2,5));
    String imgPath = "../images/avatar.gif";
    JLabel[] grids = new JLabel[10];
    for(int i = 0; i < 10; i++){
      grids[i] = new JLabel(new ImageIcon(imgPath));
      grids[i].setBorder(blackline);
      equipmentContainer.add(grids[i]);
    }

    add(equipmentContainer);

    revalidate();
    repaint();
  }
}
