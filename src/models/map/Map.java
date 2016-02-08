package models.map;

import models.Subject;
import models.items.Item;
import models.map.areaofeffect.AreaOfEffect;
import util.Position;
import views.Listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Map implements Listener, Subject
{
    private Tile[][] grid;
    private List<Listener> subjects;


    public Map(int x, int y)
    {
        subjects = new ArrayList<>();
        setMapArray(createDefaultGrid(x, y));
    }

    public Map(int N)
    {
        subjects = new ArrayList<>();
        setMapArray(createDefaultGrid(N, N));
    }

    public Map(Tile[][] tileGrid)
    {
        subjects = new ArrayList<>();
        setMapArray(tileGrid);
    }

    private Tile[][] createDefaultGrid(int x, int y)
    {
        Tile[][] tileGrid = new Tile[y][x];

        for (int i = 0; i < y; ++i) {
            for (int j = 0; j < x; ++j)
            {
                tileGrid[i][j] = new Tile();
            }
        }

        return tileGrid;
    }

    public Tile getTileAt(Position p)
    {
        if(isValidPosition(p))
            return grid[ p.getX() ][ p.getY() ];

        //System.err.println("[MAP] Attempted to get a tile at an invalid position: " + p.toString());
        return null;
    }

    public Tile[][] getMapArray()
    {
        return grid;
    }

    public void setMapArray(Tile[][] grid)
    {
        this.grid = grid;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j].addListener(this);
            }
        }

        notifyListeners();
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

    public boolean isValidPosition(Position p)
    {
        if (p.getX() < 0 || p.getX() >= grid[0].length) {
            //System.out.println("[MAP] Position was not valid b/c x was out of bounds");
            return false;
        }

        if (p.getY() < 0 || p.getY() >= grid.length) {
            //System.out.println("[MAP] Position was not valid b/c y was out of bounds");
            return false;
        }

        return true;

    }

    @Override
    public void update()
    {
        notifyListeners();
    }

    @Override
    public void addListener(Listener listener)
    {
        subjects.add(listener);
    }

    @Override
    public void removeListener(Listener listener)
    {
        boolean found = subjects.remove(listener);

        if (!found)
            System.err.println("[MAP] Attempted to remove a non-existent listener [NOT-FOUND]");
    }

    @Override
    public void notifyListeners()
    {
        for(Listener l : subjects){
            l.update();
        }
    }
}
