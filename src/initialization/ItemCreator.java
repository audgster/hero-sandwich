package initialization;

import models.entities.StatModifiers;
import models.items.EquipableItem;
import models.items.EquipmentType;
import models.items.Item;
import models.map.Map;
import models.map.Tile;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class ItemCreator {

    private List<Node> items;

    public ItemCreator(List<Node> items) {
        this.items = items;
    }

    public void createItemsOnMap(Tile[][] tileGrid) {

        for(int i = 0; i < items.size(); i++) {
            Element currentItem = (Element) items.get(i);
            int x = getItemXPostion(currentItem);
            int y = getItemYPosition(currentItem);
            tileGrid[y][x].addItem(getType(items.get(i)));
            //createTileGroup(mapGrid, currentTileGroup);
        }
    }

    private int getItemXPostion(Element item) {
        return Integer.parseInt(item.getAttribute("x-position"));
    }

    private int getItemYPosition(Element item) {
        return Integer.parseInt(item.getAttribute("y-position"));
    }

    private Item getType(Node item) {
        String itemType = item.getNodeName();
        if(itemType == "one-shot")
            return null;
        else if(itemType.equalsIgnoreCase("interactable"))
            return null;
        else if(itemType.equalsIgnoreCase("takable"))
            return null;
        else if(itemType.equalsIgnoreCase("consumable"))
            return null;
        else if(itemType.equalsIgnoreCase("equippable"))
            return new EquipableItem("equippable", EquipmentType.WEAPON, new StatModifiers());
        else
            return null;
    }
}