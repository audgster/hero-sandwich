package initialization;

import models.entities.Entity;
import models.entities.EntityStats;
import models.entities.Occupation;
import models.entities.Smasher;
import util.Direction;
import util.EntityIdentifier;

public class AvatarCreator
{
    private String name;
    private Occupation occupation;

    EntityCreator entityCreator;

    public AvatarCreator()
    {
        name = null;
        occupation = null;
        entityCreator = new EntityCreator();
    }

    public Entity vendCustomEntity()
    {
        if(name == null && occupation == null)
        {
            System.out.println("Avatar Creator: name and occupation were not set");
            System.out.println("Avatar Creator: vending default entity");
            return entityCreator.getDefaultEntity();
        }
        else if (name == null)
        {
            System.out.println("Avatar Creator: name was not set");
            System.out.println("Avatar Creator: setting default name");
            name = "Roast Beef";
        }
        else if (occupation == null)
        {
            System.out.println("Avatar Creator: occupation was not set");
            System.out.println("Avatar Creator: setting default occupation");
            occupation = new Smasher();
        }

        Entity entity = new Entity(name, occupation, new EntityStats(), EntityIdentifier.GROUND, Direction.NORTH);

        name = null;
        occupation = null;

        return entity;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOccupation(Occupation occupation)
    {
        this.occupation = occupation;
    }
}
