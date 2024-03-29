package initialization;

import models.entities.Entity;
import models.entities.EntityStats;
import models.entities.Occupation;
import util.Direction;
import util.EntityIdentifier;

public class EntityCreator
{
    public Entity getDefaultEntity()
    {
        return new Entity();
    }

    private Entity getCustomizedEntity(String name, Occupation occupation, EntityStats entityStats, EntityIdentifier identifier, Direction direction)
    {
        return new Entity(name, occupation, entityStats, identifier, direction);
    }
}
