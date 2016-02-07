package models;

import models.entities.Entity;
import models.map.Map;
import models.map.Tile;
import models.map.locationmanager.interfaces.ILocationManager;
import util.Position;
import util.TwoWayHashMap;

import java.util.Collection;
import java.util.Set;

/*
** Each level contains a Map and a corresponding LocationManager
** A Game has a list of Levels
 */
public class Level {

    ILocationManager locationManager;
    Map map;

    public Level(ILocationManager locationManager, Map map)
    {
        this.locationManager = locationManager;
        this.map = map;


    }

    public Position returnCurrentPosition(Entity entity)
    {
        return locationManager.getPosition(entity);
    }

    public Tile returnTileAt(Position position)
    {
        return map.getTileAt(position);
    }

    public Tile updatePosition(Entity entity, Position newPosition)
    {
        if (!locationManager.updateEntityPosition(entity, newPosition))
            return null;

        return map.getTileAt(newPosition);
    }

    public Set<Entity> getAllEntitiesIn(Collection<Position> positions)
    {
        TwoWayHashMap<Position, Entity> allEntities = new TwoWayHashMap<>();
        //System.out.println("get all entities in size:" + positions.size());
        for (Position p : positions)
        {
            System.out.println("looking for entity at position: " + p.toString());
            if (locationManager.isOccupied(p))
            {
                System.out.println("location manager occupied at position: " + p.toString());
                allEntities.put(p, locationManager.getEntity(p));
            }
        }

        return allEntities.getValueSet();
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public void addEntity(Entity entity, Position startPosition){
        locationManager.addEntity(entity, startPosition);
        System.out.println(locationManager.toString());
    }

    public String toString()
    {
        return locationManager.toString();
    }

    //public Position getPositionAt(int x, int y){
      //  return locationManager.
    //}
}
