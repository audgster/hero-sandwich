package initialization;

import models.map.Map;
import models.map.Tile;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import util.TerrainGroup;

import java.util.List;

public class MapCreator {
    private ConfigParser parser;
    private Node baseMapNode;
    private List<Node> tileGroups;
    private List<Node> areaEffectGroups;
    private List<Node> items;


    //Get full map tag not just base Terrain -- you need size of map.
    public MapCreator(String mapFile) {
        parser = new ConfigParser(mapFile);
        baseMapNode = parser.getBaseMapTag();
        tileGroups = parser.getTileGroups();
        items = parser.getMapItems();
        areaEffectGroups = parser.getAreaEffectGroups();
        //printTileGroups();
        //printAreaEffectGroups();
        //printItems();
    }

    public Map create() {
        int[] mapSize = getMapSize();
        Tile[][] mapGrid = new Tile[mapSize[0]][mapSize[1]];
        setTileGroups(mapGrid);
        fillInGrid(mapGrid);
        setAreaOfEffectGroups(mapGrid);
        setItems(mapGrid);
        //map.printMap();
        return new Map(mapGrid);
    }

    private void setItems(Tile[][] tileGrid) {
        ItemCreator itemCreator = new ItemCreator(items);
        itemCreator.createItemsOnMap(tileGrid);
    }

    private void setAreaOfEffectGroups(Tile[][] tileGrid) {
        AreaOfEffectCreator areaOfEffectCreator = new AreaOfEffectCreator(areaEffectGroups);
        areaOfEffectCreator.createAreasOfEffectOnMap(tileGrid);
    }


    private void setTileGroups(Tile[][] tileGrid) {
        TileCreator tileCreator = new TileCreator(tileGroups);
        tileCreator.createTilesOnMap(tileGrid);
    }

    private void fillInGrid(Tile[][] tileGrid) {
        for(int i = 0; i < tileGrid[0].length; i++)
            for (int j = 0; j < tileGrid[0].length; j++)
                if (tileGrid[i][j] == null)
                    tileGrid[i][j] = new Tile(getBaseTerrain());
    }

    private TerrainGroup getBaseTerrain(){
        String baseMapTerrain = parser.getMapBaseTerrain();
        if(baseMapTerrain.equalsIgnoreCase("ground"))
            return TerrainGroup.GROUND;
        else if(baseMapTerrain.equalsIgnoreCase("water"))
            return TerrainGroup.WATER;
        else if(baseMapTerrain.equalsIgnoreCase("mountain"))
            return TerrainGroup.MOUNTAIN;
        else
            return null;
    }

    private int[] getMapSize() {
        Element mapElement = (Element) baseMapNode;
        String x = mapElement.getAttribute("width");
        String y = mapElement.getAttribute("height");
        int mapSize[] = {Integer.parseInt(x), Integer.parseInt(y)};
        return mapSize;
    }
}

/*
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
 */
