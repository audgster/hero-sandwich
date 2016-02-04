package initialization;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class MapCreator {
    private ConfigParser parser;
    //private ItemCreater itemCreater = new ItemCreator();
    private String baseMapTerrain;
    ArrayList<Node> tileGroups;
    ArrayList<Node> areaEffectGroups;
    ArrayList<Node> items;

    public MapCreator(String mapFile) {
        parser = new ConfigParser(mapFile);
        baseMapTerrain = parser.getMapBaseTerrain();
        tileGroups = parser.getTileGroups();
        items = parser.getMapItems();
        areaEffectGroups = parser.getAreaEffectGroups();
        printTileGroups();
        printAreaEffectGroups();
        printItems();
    }

    public void create() {

    }

    private void printAreaEffectGroups() {
        for(int nodeNum = 0; nodeNum < areaEffectGroups.size(); nodeNum++) {
            Node xmlNode = areaEffectGroups.get(nodeNum);
            Element tileGroup = (Element) xmlNode;
            System.out.println(xmlNode.getNodeName());
            System.out.println("Terrain: " + tileGroup.getAttribute("type"));
            System.out.println("Height: " + tileGroup.getAttribute("height"));
            System.out.println("Width: " + tileGroup.getAttribute("width"));
            System.out.println("X-Position: " + tileGroup.getAttribute("x-origin"));
            System.out.println("Y-Position: " + tileGroup.getAttribute("y-origin"));
        }
    }

    private void printTileGroups() {

        for(int nodeNum = 0; nodeNum < tileGroups.size(); nodeNum++) {
            Node xmlNode = tileGroups.get(nodeNum);
            Element tileGroup = (Element) xmlNode;
            System.out.println(xmlNode.getNodeName());
            System.out.println("Terrain: " + tileGroup.getAttribute("terrain"));
            System.out.println("Height: " + tileGroup.getAttribute("height"));
            System.out.println("Width: " + tileGroup.getAttribute("width"));
            System.out.println("X-Position: " + tileGroup.getAttribute("x-origin"));
            System.out.println("Y-Position: " + tileGroup.getAttribute("y-origin"));
        }
    }

    private void printItems() {
        for(int i = 0; i < items.size(); i++) {
            Node xmlNode = items.get(i);
            Element item = (Element) xmlNode;
            System.out.println(xmlNode.getNodeName());
            System.out.println("x-position: " + item.getAttribute("x-position"));
            System.out.println("y-position: " + item.getAttribute("y-position"));
        }
    }
}
