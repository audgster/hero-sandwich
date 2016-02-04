package models.map.movementengine.interfaces;

import models.entities.Entity;
import models.Level;
import models.map.Tile;
import util.Direction;
import util.Position;

public interface IMovementDirector
{
    Tile executeMovement(Entity entity, Position newPosition, Level level);

    Position getPositionAfterMovement(Level level, Entity entity, Direction direction);
}
