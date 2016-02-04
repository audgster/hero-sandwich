package models.map.locationmanager.interfaces;

import models.entities.Entity;
import util.Position;

public interface ILocationManager
{
    boolean addEntity(Entity entity, Position position);

    boolean updateEntityPosition(Entity entity, Position newPosition);

    boolean removeEntity(Entity entity);

    boolean isOccupied(Position position);

    Entity getEntity(Position position);

    Position getPosition(Entity entity);
}
