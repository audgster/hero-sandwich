package initialization;

import java.util.ArrayList;
import java.util.List;
import models.map.Tile;

public class TestMap {
    private TestTile mapGrid[][];

    public TestMap(int xSize, int ySize) {
        mapGrid = new TestTile[xSize][ySize];
    }

    public void addTile(TestTile tile, int x, int y) {
        mapGrid[x][y] = tile;
    }

    public void printMap() {
        for(int i = 0; i < mapGrid[0].length; i++) {
            for (int j = 0; j < mapGrid[0].length; j++) {
                if(j+1 != mapGrid[0].length) {
                    System.out.print(mapGrid[i][j].toString());
                }
                else {
                    System.out.println(mapGrid[i][j].toString());
                }
            }
        }
    }

    public TestTile[][] getMap() {
        return mapGrid;
    }
}
