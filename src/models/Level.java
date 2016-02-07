package models;

import models.entities.Entity;
import models.map.Map;
import models.map.Tile;
import models.map.locationmanager.interfaces.ILocationManager;
import util.Position;
import util.TwoWayHashMap;
import views.Listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/*
** Each level contains a Map and a corresponding LocationManager
** A Game has a list of Levels
 */
public class Level implements Subject, Listener
{

    ILocationManager locationManager;
    Map map;
    private List<Listener> subjects;

    public Level(ILocationManager locationManager, Map map)
    {
        this.locationManager = locationManager;
        this.map = map;
        map.addListener(this);

        this.subjects = new ArrayList<>();
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
        System.out.println("[LEVEL] Starting entity position update to " + newPosition.toString());
        if (!locationManager.updateEntityPosition(entity, newPosition)) {
            System.err.println("[LEVEL] Could not update entity position");
            return null;
        }

        System.out.println("[LEVEL] Successfully updated entity to " + newPosition.toString());
        notifyListeners();
        return map.getTileAt(newPosition);
    }

    public Set<Entity> getAllEntitiesIn(Collection<Position> positions)
    {
        TwoWayHashMap<Position, Entity> allEntities = new TwoWayHashMap<>();
        //System.out.println("get all entities in size:" + positions.size());
        for (Position p : positions)
        {
            System.out.println("[LEVEL] looking for entity at position: " + p.toString());
            if (locationManager.isOccupied(p))
            {
                System.out.println("[LEVEL] Location manager occupied at position: " + p.toString());
                allEntities.put(p, locationManager.getEntity(p));
            }
        }

        return allEntities.getValueSet();
    }

    public void setMap(Map map) {
        this.map = map;
        map.addListener(this);
        notifyListeners();
    }

    public Map getMap() {
        return map;
    }

    public void addEntity(Entity entity, Position startPosition){
        locationManager.addEntity(entity, startPosition);
        notifyListeners();
        System.out.println("[LEVEL] " + locationManager.toString());
    }

    public boolean isValidLocation(Position p)
    {
        return getMap().isValidPosition(p);
    }

    public String toString()
    {
        return locationManager.toString();
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
            System.err.println("Level could not remove Listener [NOT FOUND]");
    }

    @Override
    public void notifyListeners()
    {
        for(int i = 0; i < subjects.size(); i++){
            subjects.get(i).update();
        }
    }

    @Override
    public void update() {
        notifyListeners();
    }
}
