package entities;

import models.entities.Entity;
import models.entities.EntityStats;
import models.entities.Smasher;
import org.junit.Before;
import org.junit.Test;
import util.Direction;
import util.EntityIdentifier;

public class EntityTest
{
    Entity entity;

    @Before
    public void setUp()
    {
        entity = new Entity("EntityTest",
                new Smasher(),
                new EntityStats(10, 10, 10, 10, 10, 3, 0, 100, 100, new Smasher()),
                EntityIdentifier.GROUND,
                Direction.NORTH);

        // Lives left: 3
        // xp: 0
        // Current health: 100
        // Current mana: 100
    }

    /*
    * Take Damage
    * */

    /*
    * Verifies that take damage correctly decrements health for entity when the
    * damage taken is not more than current health
    * */
    @Test
    public void takeDamage_nonKillingDamage()
    {

    }
}
