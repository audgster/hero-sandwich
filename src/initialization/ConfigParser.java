package initialization;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import util.ResourceUtil;

public class ConfigParser {
    Document mapXML;

    public ConfigParser(String fileName) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            mapXML = docBuilder.parse(fileName);
            mapXML.getDocumentElement().normalize();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMapBaseTerrain() {
        Node map = mapXML.getElementsByTagName("map").item(0);
        Element mapElement = (Element) map;
        String baseTerrain = mapElement.getAttribute("base-terrain");
        return baseTerrain;

    }

    public Node getBaseMapTag() {
        Node map = mapXML.getElementsByTagName("map").item(0);
        return map;
    }

    public List<Node> getTileGroups() {
        NodeList tileGroupNodeList = mapXML.getElementsByTagName("tile-group");
        List<Node> tileGroups = makeFilteredList(tileGroupNodeList);
        return tileGroups;
    }

    public List<Node> getMapItems() {
        Node itemsParent = mapXML.getElementsByTagName("items").item(0);
        List<Node> items = makeFilteredList(itemsParent.getChildNodes());
        return items;
    }

    public List<Node> getAreaEffectGroups() {
        NodeList areaEffectGroupNodeList = mapXML.getElementsByTagName("area-effect-group");
        List<Node> areaEffectGroups = makeFilteredList(areaEffectGroupNodeList);
        return areaEffectGroups;
    }

    private List<Node> makeFilteredList(NodeList list) {
        List<Node> nodeArray = new ArrayList<Node>();
        for(int i = 0; i < list.getLength(); i++)
            if(list.item(i).getNodeType() == 1)
                nodeArray.add(list.item(i));

        return nodeArray;
    }
}

/*
    Add errors as inner classes
 */



/*
    private void setupBaseMap(Document doc) {
        NodeList Nodes = doc.getElementsByTagName("map");
        for(int nodeNum = 0; nodeNum < Nodes.getLength(); nodeNum++) {
            Node mapNode = Nodes.item(nodeNum);
            Element mapElement = (Element) mapNode;
            System.out.println("Element: " + mapNode.getNodeName() + "\n" + mapElement.getAttribute("base-terrain"));
            System.out.println("Size: " + mapElement.getAttribute("height") + "x" + mapElement.getAttribute("width"));
        }
    }

    private void setupTileGroups(Document doc) {
        NodeList nodes = doc.getElementsByTagName("tile-group");
        for(int nodeNum = 0; nodeNum < nodes.getLength(); nodeNum++) {
            Node xmlNode = nodes.item(nodeNum);
            Element tileGroup = (Element) xmlNode;
            System.out.println(xmlNode.getNodeName());
            System.out.println("Terrain: " + tileGroup.getAttribute("terrain"));
            System.out.println("Height: " + tileGroup.getAttribute("height"));
            System.out.println("Width: " + tileGroup.getAttribute("width"));
            System.out.println("X-Position: " + tileGroup.getAttribute("x-origin"));
            System.out.println("Y-Position: " + tileGroup.getAttribute("y-origin"));
        }
        System.out.println("The tile groups have been setup");
    }
    //Need to get all children of item and parse them
    private void setupItemsOnMap(Document doc) {
        Node itemsParent = doc.getElementsByTagName("items").item(0);
        NodeList items = itemsParent.getChildNodes();
        for(int i = 0; i < items.getLength(); i++) {
            Node xmlNode = items.item(i);
            if(xmlNode.getNodeType() == 1) {
                Element item = (Element) xmlNode;
                System.out.println(xmlNode.getNodeName());
                System.out.println("x-position: " + item.getAttribute("x-position"));
                System.out.println("y-position: " + item.getAttribute("y-position"));
            }
        }
    }

    private Node findNode(Node parent , String tagName) {
        NodeList childNodes = parent.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if(node.getNodeName().equalsIgnoreCase(tagName))
                return node;
        }
        return null;
    }
    */
