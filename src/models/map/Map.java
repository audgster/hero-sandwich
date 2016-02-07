package models.map;

import models.items.Item;
import models.map.areaofeffect.AreaOfEffect;
import util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Map
{
    private Tile[][] grid;

    /* Constructor: Create an NxN grid of default Tiles*/

    public Map(int x, int y) {
        grid = new Tile[y][x];
    }

    public Map(int N)
    {
        grid = new Tile[N][N];

        // populate the grid with Tiles
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                grid[i][j] = new Tile();
            }
        }
    }

    public Tile getTileAt(Position p)
    {
        if((p.getX() < 0) || (p.getX() >= grid.length) ||
				(p.getY() < 0) || (p.getX() >= grid[0].length)){
			
			//this might be really bad, maybe throw exception instead?
			return null;
			
		}
		return grid[ p.getX() ][ p.getY() ];
    }

    public Tile[][] getMapArray() {
        return grid;
    }

    public void setMapArray(Tile[][] grid) {
        this.grid = grid;
    }

    public void printMap() {
        for(int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if(j+1 != grid[0].length) {
                    System.out.print(grid[i][j].getTerrainType() + " ");
               }
                else {
                    System.out.println(grid[i][j].getTerrainType() + " ");
                }
            }
        }
    }

    public void printAoes() {
        for(int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j + 1 != grid[0].length)
                    printAoeList(grid[i][j].getAllAoE(), j, i);
                else
                    printAoeList(grid[i][j].getAllAoE(), j, i);
                }
            }
    }

    private void printAoeList(Collection<AreaOfEffect> aoeList, int x, int y) {
        for(AreaOfEffect aoe : aoeList) {
            System.out.println(aoe.getImageId() + "(" + x + "," + y + ")");
        }
    }

    public void printItems() {
        for(int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j + 1 != grid[0].length)
                    printItemList(grid[i][j].getAllItems(), j, i);
                else
                    printItemList(grid[i][j].getAllItems(), j, i);
            }
        }
    }

    private void printItemList(Collection<Item> itemList, int x, int y) {
        for(Item item : itemList) {
            System.out.println(item.getImageId() + "(" + x + "," + y + ")");
        }
    }
/*
    public List<String> getSaveState() {
        List<String> state = new ArrayList<String>();
        for(int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j].hasItem())
                    state.add(grid[i][j].getClass().getSimpleName() + " ");
            }
        }
    }
    */
}
