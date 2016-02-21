package com.herosandwich.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityStatsTest {

    private PrimaryStats buffOccup = new PrimaryStats(1,1,1,1,1,1);
    private PrimaryStats nerfOccup = new PrimaryStats(10,10,10,10,10,10);

    /*
    * Verify that a buff successfully updates cache
    *
    * TODO: modify test to check values after cache update
    * */
    @Test
    public void testBuffPositive()
    {
        PrimaryStats buff = new PrimaryStats(1,1,1,1,1,1);

        EntityStats entityStats = new EntityStats(buffOccup);

        boolean result = entityStats.buff(buff);

        Assert.assertTrue(result);
    }

    /*
    * Verify that a buff resulting in a negative statistic does not update cache
    *
    * TODO: modify test to check values after cache update
    * */
    @Test
    public void testBuffInvalid()
    {
        PrimaryStats buff = new PrimaryStats(-2,-2,-2,-2,-2,-2);

        EntityStats entityStats = new EntityStats(buffOccup);

        boolean result = entityStats.buff(buff);

        Assert.assertFalse(result);
    }


    /*
    * Verify that a buff successfully updates cache when result will be zero
    *
    * TODO: modify test to check values after cache update
    * */
    @Test
    public void testBuffBorder()
    {
        PrimaryStats buff = new PrimaryStats(-1,-1,-1,-1,-1,-1);

        EntityStats entityStats = new EntityStats(buffOccup);

        boolean result = entityStats.buff(buff);

        Assert.assertTrue(result);
    }

    /*
    * Verify that a nerf successfully updates cache
    *
    * TODO: modify test to check values after cache update
    * */
    @Test
    public void testNerfPositive()
    {
        PrimaryStats nerf = new PrimaryStats(5,5,5,5,5,5);

        EntityStats entityStats = new EntityStats(nerfOccup);

        boolean result = entityStats.nerf(nerf);

        Assert.assertTrue(result);
    }

    /*
    * Verify that a nerf resulting in a negative stat will not update the cache
    *
    * TODO: modify test to check values after cache update
    * */
    @Test
    public void testNerfInvalid()
    {
        PrimaryStats nerf = new PrimaryStats(15,15,15,15,15,15);

        EntityStats entityStats = new EntityStats(nerfOccup);

        boolean result = entityStats.nerf(nerf);

        Assert.assertFalse(result);
    }

    /*
    * Verify that a nerf successfully updates cache when result will be zero
    *
    * TODO: modify test to check values after cache update
    * */
    @Test
    public void testNerfBorder()
    {
        PrimaryStats nerf = new PrimaryStats(10,10,10,10,10,10);

        EntityStats entityStats = new EntityStats(nerfOccup);

        boolean result = entityStats.nerf(nerf);

        Assert.assertTrue(result);
    }
}