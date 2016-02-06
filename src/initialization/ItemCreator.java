package initialization;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

public class ItemCreator {

    private List<Node> items;

    public ItemCreator(List<Node> items) {
        this.items = items;
    }

    public void createItemsOnMap(TestMap map) {
        TestTile[][] mapGrid = map.getMap();

        for(int i = 0; i < items.size(); i++) {
            Element currentItem = (Element) items.get(i);
            int x = getItemXPostion(currentItem);
            int y = getItemYPosition(currentItem);
            mapGrid[y][x].setItem(getType(items.get(i)));
            //createTileGroup(mapGrid, currentTileGroup);
        }
    }

    private int getItemXPostion(Element item) {
        return Integer.parseInt(item.getAttribute("x-position"));
    }

    private int getItemYPosition(Element item) {
        return Integer.parseInt(item.getAttribute("y-position"));
    }

    private String getType(Node item) {
        String itemType = item.getNodeName();
        if(itemType == "one-shot")
            return "O";
        else if(itemType == "interactable")
            return "I";
        else if(itemType == "takable")
            return "T";
        else if(itemType == "consumable")
            return "C";
        else if(itemType == "equippable")
            return "E";
        else
            return "ERROR";
    }
}