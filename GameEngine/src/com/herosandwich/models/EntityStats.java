package com.herosandwich.models;

public class EntityStats
{
    private PrimaryStats primaryStats;

    public EntityStats()
    {
        primaryStats = new PrimaryStats();
    }

    /*
    * Precondition: occupation stats must be valid (all values positive)
    * */
    public EntityStats(PrimaryStats occupation)
    {
        primaryStats = new PrimaryStats();
        updateStats(occupation, true);
    }

    /*
    * Checks that adding a set of stats to the EntityStats is valid (all values positive)
    * */
    private boolean updateStats(PrimaryStats stats, boolean buff)
    {
        int[] statsArray = new int[6];

        if (buff) {
            statsArray[0] = primaryStats.getStrength() + stats.getStrength();
            statsArray[1] = primaryStats.getAgility() + stats.getAgility();
            statsArray[2] = primaryStats.getIntellect() + stats.getAgility();
            statsArray[3] = primaryStats.getHardiness() + stats.getHardiness();
            statsArray[4] = primaryStats.getExperience() + stats.getExperience();
            statsArray[5] = primaryStats.getMovement() + stats.getMovement();
        } else
        {
            statsArray[0] = primaryStats.getStrength() - stats.getStrength();
            statsArray[1] = primaryStats.getAgility() - stats.getAgility();
            statsArray[2] = primaryStats.getIntellect() - stats.getAgility();
            statsArray[3] = primaryStats.getHardiness() - stats.getHardiness();
            statsArray[4] = primaryStats.getExperience() - stats.getExperience();
            statsArray[5] = primaryStats.getMovement() - stats.getMovement();
        }

        for (int i = 0; i < statsArray.length; i++)
        {
            if (statsArray[i] < 0)
                return false;
        }

        primaryStats = new PrimaryStats(
                statsArray[0],
                statsArray[1],
                statsArray[2],
                statsArray[3],
                statsArray[4],
                statsArray[5]
        );

        return true;
    }

    public boolean buff(PrimaryStats buff)
    {
        return updateStats(buff, true);
    }

    public boolean nerf(PrimaryStats nerf)
    {
        return updateStats(nerf, false);
    }
}
