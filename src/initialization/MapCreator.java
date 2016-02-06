package initialization;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.List;

public class MapCreator {
    private ConfigParser parser;
    private String baseMapTerrain;
    private Node baseMapNode;
    private List<Node> tileGroups;
    private List<Node> areaEffectGroups;
    private List<Node> items;


    //Get full map tag not just base Terrain -- you need size of map.
    public MapCreator(String mapFile) {
        parser = new ConfigParser(mapFile);
        baseMapTerrain = parser.getMapBaseTerrain();
        baseMapNode = parser.getBaseMapTag();
        tileGroups = parser.getTileGroups();
        items = parser.getMapItems();
        areaEffectGroups = parser.getAreaEffectGroups();
        printTileGroups();
        printAreaEffectGroups();
        printItems();
    }

    public TestMap create() {
        int[] mapSize = getMapSize();
        TestMap map = new TestMap(mapSize[0], mapSize[1]);
        setTileGroups(map);
        fillInGrid(map);
        setAreaOfEffectGroups(map);
        setItems(map);
        return map;
    }

    private void setItems(TestMap map) {
        ItemCreator itemCreator = new ItemCreator(items);
        itemCreator.createItemsOnMap(map);
    }

    private void setAreaOfEffectGroups(TestMap map) {
        AreaOfEffectCreator areaOfEffectCreator = new AreaOfEffectCreator(areaEffectGroups);
        areaOfEffectCreator.createAreasOfEffectOnMap(map);
    }


    private void setTileGroups(TestMap map) {
        TileCreator tileCreator = new TileCreator(tileGroups);
        tileCreator.createTilesOnMap(map);
    }

    private void fillInGrid(TestMap map) {
        TestTile mapGrid[][] = map.getMap();
        for(int i = 0; i < mapGrid[0].length; i++)
            for (int j = 0; j < mapGrid[0].length; j++)
                if (mapGrid[i][j] == null)
                    mapGrid[i][j] = new TestTile("x", "", "");
    }

    private int[] getMapSize() {
        Element mapElement = (Element) baseMapNode;
        String x = mapElement.getAttribute("width");
        String y = mapElement.getAttribute("height");
        int mapSize[] = {Integer.parseInt(x), Integer.parseInt(y)};
        return mapSize;
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
