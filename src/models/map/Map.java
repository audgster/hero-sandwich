package models.map;

import util.Position;

public class Map
{
    private Tile[][] grid;

    /* Constructor: Create an NxN grid of default Tiles*/

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

    // need 2nd constructor for adam?

    public Tile getTileAt(Position p)
    {
        if((p.getX() < 0) || (p.getX() >= grid.length) ||
				(p.getY() < 0) || (p.getX() >= grid[0].length)){
			
			//this might be really bad, maybe throw exception instead?
			return null;
			
		}
		return grid[ p.getX() ][ p.getY() ];
    }
}
