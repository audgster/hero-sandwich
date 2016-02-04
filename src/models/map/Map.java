package models.map;

import util.Position;
import java.util.List;
import java.util.ArrayList;

public class Map {
  private ArrayList< ArrayList<Tile> > grid;
  /* Constructor: Create an NxN grid */
  Map(int N) {
    grid = new ArrayList( new ArrayList(N) );
  }

  public Tile getTileAt(Position p) {
    return grid.get( p.getX().getY() );
  }
}
