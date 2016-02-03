package models;

import models.entities.Entity;
import models.map.Tile;
import util.Position;

/*
** Each level contains a Map and a corresponding LocationManager
** A Game has a list of Levels
 */
public class Level {

    // Audrey: need this for movement stuff
    // This will talk to the location manager
    public Position returnCurrentPosition(Entity entity) {return new Position();}

    public Tile returnTileAt(Position position) {return new Tile();}

    //return current Tile
    public Tile updatePosition(Entity entity, Position newPosition) {return new Tile();}
}
