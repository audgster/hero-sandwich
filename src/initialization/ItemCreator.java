package initialization;

import models.entities.StatModifiers;
import models.items.*;
import models.items.actions.AddConstantHealthAction;
import models.items.actions.ModifyAoE;
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
            tileGrid[y][x].addItem(getInstance(items.get(i),
                    currentItem.getAttribute("name"),
                    Integer.parseInt(currentItem.getAttribute("base"))));
            //createTileGroup(mapGrid, currentTileGroup);
        }
    }

    private int getItemXPostion(Element item) {
        return Integer.parseInt(item.getAttribute("x-position"));
    }

    private int getItemYPosition(Element item) {
        return Integer.parseInt(item.getAttribute("y-position"));
    }

    private Item getInstance(Node item, String itemName, int base) {
        String itemType = item.getNodeName();
        if(itemType.equalsIgnoreCase("one-shot")) {
            Item oneShot = new StatModifyingOneShotItem(itemName, new AddConstantHealthAction(base));
            System.out.println(oneShot.getImageId());
            return oneShot;
        }
        else if(itemType.equalsIgnoreCase("interactable"))
        {
            Item interactable = new InteractableItem(itemName, new ModifyAoE());
            System.out.println(interactable.getImageId());
            return interactable;
        }
        else if(itemType.equalsIgnoreCase("takeable")) {
            Item takeable = new TakeableItem(itemName);
            System.out.println(takeable.getImageId());
            return takeable;
        }
        else if(itemType.equalsIgnoreCase("consumable")) {
            Item consumable = new StatModifyingConsumableItem(itemName, new AddConstantHealthAction(base));
            System.out.println(consumable.getImageId());
            return consumable;
        }
        else if(itemType.equalsIgnoreCase("equippable")) {
            Item equip = new EquipableItem(itemName, EquipmentType.WEAPON, new StatModifiers());
            System.out.println(equip.getImageId());
            return equip;
        }
        else if(itemType.equalsIgnoreCase("obstacle"))
        {
            Item obstacle = new ObstacleItem(itemName);
            System.out.println(obstacle.getImageId());
            return obstacle;
        }
            return null;
    }
}