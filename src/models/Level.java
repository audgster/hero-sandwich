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
    public Position returnCurrentPosition(Entity entity) {return new Position(1,1);}

    public Tile returnTileAt(Position position) {return new Tile("Grass");}

    //return current Tile
    public Tile updatePosition(Entity entity, Position newPosition) {return new Tile("Grass");}
}
