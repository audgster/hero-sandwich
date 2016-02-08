package initialization;

import models.map.Map;
import models.map.Tile;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import util.TerrainGroup;

import java.util.List;

public class TileCreator {
    private List<Node> tileGroups;

    public TileCreator(List<Node> tileGroups) {
        this.tileGroups = tileGroups;
    }

    public TileCreator() {}

    public void createTilesOnMap(Tile[][] tileGrid) {
        for(int i = 0; i < tileGroups.size(); i++) {
            Element currentTileGroup = (Element) tileGroups.get(i);
            createTileGroup(tileGrid, currentTileGroup);
        }
    }

    private void createTileGroup(Tile[][] mapGrid, Element tileGroup) {
        TerrainGroup terrain = getTileGroupTerrainType(tileGroup);
        int height = getTileGroupHeight(tileGroup);
        int width = getTileGroupWidth(tileGroup);
        int xOrigin = getTileGroupXOrigin(tileGroup);
        int yOrigin = getTileGroupYOrigin(tileGroup);
        for(int i = 0; i < height; i++) {
            for(int j=0; j < width; j++) {
                mapGrid[yOrigin+i][xOrigin+j] = new Tile(terrain);
            }
        }
    }

    private int getTileGroupXOrigin(Element tileGroup) {
        return Integer.parseInt(tileGroup.getAttribute("x-origin"));
    }

    private int getTileGroupYOrigin(Element tileGroup) {
        return Integer.parseInt(tileGroup.getAttribute("y-origin"));
    }

    private int getTileGroupHeight(Element tileGroup) {
        return Integer.parseInt(tileGroup.getAttribute("height"));
    }

    private int getTileGroupWidth(Element tileGroup) {
        return Integer.parseInt(tileGroup.getAttribute("width"));
    }

    private TerrainGroup getTileGroupTerrainType(Element tileGroup) {
        String terrain = tileGroup.getAttribute("terrain");
        if(terrain.equalsIgnoreCase("water"))
            return TerrainGroup.WATER;
        else if(terrain.equalsIgnoreCase("mountain"))
            return TerrainGroup.MOUNTAIN;
        else if(terrain.equalsIgnoreCase("ground"))
            return TerrainGroup.GROUND;
        else
            return null;
    }

}
