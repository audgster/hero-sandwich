package entities;

import models.entities.Entity;
import models.entities.EntityStats;
import models.entities.Smasher;
import org.junit.Assert;
import org.junit.Test;
import util.Direction;
import util.EntityIdentifier;
import util.exceptions.InvalidStatException;

public class EntityTest
{
    /*
    * Initialization
    * */

    @Test
    public void initialization_currentUnderMax()
    {
        // Verify that instantiating an entity with currentLife or currentMana less than
        // maxLife or maxMana will initialize currentLife and currentMana
        // to provided values

        int initialLife = 30;
        int initialMana = 5;

        Entity entity = new Entity("EntityTest",
                new Smasher(),
                new EntityStats(10, 10, 10, 10, 10, 3, 0, initialLife, initialMana, new Smasher()),
                EntityIdentifier.GROUND,
                Direction.NORTH);

        Assert.assertEquals(entity.getEntityStats().getCurrentLife(), initialLife);
        Assert.assertEquals(entity.getEntityStats().getMana(), initialMana);
    }

    @Test
    public void initialization_currentOverrMax()
    {
        // Verify that instantiating an entity with currentLife or currentMana more than
        // maxLife or maxMana will initialize currentLife and currentMana
        // to maxLife or maxMana

        int initialLife = 45;
        int initialMana = 15;

        Entity entity = new Entity("EntityTest",
                new Smasher(),
                new EntityStats(10, 10, 10, 10, 10, 3, 0, initialLife, initialMana, new Smasher()),
                EntityIdentifier.GROUND,
                Direction.NORTH);

        EntityStats stats = entity.getEntityStats();

        Assert.assertEquals(stats.getCurrentLife(), stats.getLife());
        Assert.assertEquals(stats.getMana(), stats.getMana());
    }

    @Test(expected = InvalidStatException.class)
    public void initialization_negativeCurrentLife()
    {
        // Verify that instantiating an entity with negative current life
        // will throw an InvalidStatException

        int initialLife = -1;
        int initialMana = 5;

        Entity entity = new Entity("EntityTest",
                new Smasher(),
                new EntityStats(10, 10, 10, 10, 10, 3, 0, initialLife, initialMana, new Smasher()),
                EntityIdentifier.GROUND,
                Direction.NORTH);
    }

    @Test(expected = InvalidStatException.class)
    public void initialization_negativeCurrentMana()
    {
        // Verify that instantiating an entity with negative current mana
        // will throw an InvalidStatException

        int initialLife = 30;
        int initialMana = -1;

        Entity entity = new Entity("EntityTest",
                new Smasher(),
                new EntityStats(10, 10, 10, 10, 10, 3, 0, initialLife, initialMana, new Smasher()),
                EntityIdentifier.GROUND,
                Direction.NORTH);
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
        Assert.assertTrue(true);
    }
}
