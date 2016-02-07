package models.map.locationmanager;

import models.entities.Entity;
import models.map.locationmanager.interfaces.ILocationManager;
import util.Position;
import util.TwoWayHashMap;


public class LocationManager implements ILocationManager
{
    TwoWayHashMap<Position, Entity> twoWayHashMap;

    public LocationManager()
    {
        twoWayHashMap = new TwoWayHashMap<>();
    }

    @Override
    public boolean addEntity(Entity entity, Position position) {
        if (twoWayHashMap.containsKey(position))
        {
            // Should I throw an exception here?
            System.out.println("Attempted to put an entity at an occupied position");
            return false;
        }
        else if(twoWayHashMap.containsValue(entity))
        {
            // Should I throw an exception here?
            System.out.println("Attempted to put a pre-existing entity to the map");
            return false;
        }

        twoWayHashMap.put(position, entity);
        System.out.println("Successfully added entity@position to manager");

        return true;
    }

    @Override
    public boolean updateEntityPosition(Entity entity, Position newPosition) {
        if (!twoWayHashMap.containsValue(entity))
        {
            System.out.println("Entity is not on map, cannot update");
            return false;
        }

        twoWayHashMap.removeByValue(entity);
        twoWayHashMap.put(newPosition, entity);
        System.out.println("Position has been updated");

        System.out.println(twoWayHashMap.getByValue(entity).toString());

        return true;
    }

    @Override
    public boolean removeEntity(Entity entity) {
        if (!twoWayHashMap.containsValue(entity))
        {
            System.out.println("Attempted to remove an entity not on map");
            return false;
        }

        twoWayHashMap.removeByValue(entity);

        return true;
    }

    @Override
    public boolean isOccupied(Position position)
    {
        return twoWayHashMap.containsKey(position);
    }

    @Override
    public Entity getEntity(Position position) {
        //Should throw exception here
        if (!twoWayHashMap.containsKey(position))
            return null;

        return twoWayHashMap.getByKey(position);
    }

    @Override
    public Position getPosition(Entity entity)
    {
        //Should throw exception here
        if (!twoWayHashMap.containsValue(entity))
            return null;

        return twoWayHashMap.getByValue(entity);
    }

    //public Position getPosition(int x, int y){
//
  //  }

    public String toString()
    {
        return twoWayHashMap.toString();
    }
}
