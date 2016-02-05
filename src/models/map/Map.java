package models.map;

import util.Position;
import java.util.ArrayList;

public class Map
{
    private ArrayList< ArrayList<Tile> > grid;

    /* Constructor: Create an NxN grid */

    public Map(int N)
    {
        grid = new ArrayList(N);

        // populate the rows with Lists
        for (int i = 0; i < N; ++i) {
            grid.add( new ArrayList(N) );
            ArrayList<Tile> row = grid.get(i);

            // populate the columns of the rows with Tiles
            for (int j = 0; j < N; ++j) {
                row.add( new Tile() );
            }
        }
    }

    // need 2nd constructor for adam?

    public Tile getTileAt(Position p)
    {
        return grid.get( p.getX() ).get( p.getY() );
    }
}
