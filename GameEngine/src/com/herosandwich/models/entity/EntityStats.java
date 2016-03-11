package com.herosandwich.models.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityStats
{
    private PrimaryStats primaryStats;
    private DerivedStats derivedStats;
    private List<DerivedStats> flatBonus;

    private DerivedStats totalStats;

    public EntityStats(DeriveStatStrategy strategy)
    {
        primaryStats = new PrimaryStats();
        derivedStats = new DerivedStats(strategy);
        flatBonus = new ArrayList<>();
        totalStats = new DerivedStats();

        updateDerivedStats();
        calculateTotalDerivedStats();
    }

    public EntityStats()
    {
        primaryStats = new PrimaryStats(5, 10, 10, 10, 10, 1, 1);
        derivedStats = new DerivedStats( 1, 100, 100, 10, 5, 12);
        flatBonus = new ArrayList<>();
        totalStats = new DerivedStats();

        updateDerivedStats();
        calculateTotalDerivedStats();
    }

    /*
    * Precondition: occupation stats must be valid (all values positive)
    * */
    public EntityStats(DeriveStatStrategy strategy, PrimaryStats occupation)
    {
        primaryStats = new PrimaryStats();
        derivedStats = new DerivedStats(strategy);
        totalStats = new DerivedStats();
        flatBonus = new ArrayList<>();
        addPrimaryStats(occupation);

        updateDerivedStats();
        calculateTotalDerivedStats();
    }

    /*
    * Checks that adding a set of stats to the EntityStats is valid (all values positive)
    * */
    private boolean addPrimaryStats(PrimaryStats stats)
    {
        int[] statsArray = new int[7];

        statsArray[0] = primaryStats.getLives() + stats.getLives();
        statsArray[1] = primaryStats.getStrength() + stats.getStrength();
        statsArray[2] = primaryStats.getAgility() + stats.getAgility();
        statsArray[3] = primaryStats.getIntellect() + stats.getAgility();
        statsArray[4] = primaryStats.getHardiness() + stats.getHardiness();
        statsArray[5] = primaryStats.getExperience() + stats.getExperience();
        statsArray[6] = primaryStats.getMovement() + stats.getMovement();


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
                statsArray[5],
                statsArray[6]
        );

        updateDerivedStats();
        calculateTotalDerivedStats();

        return true;
    }

    public boolean restorePrimaryStats(PrimaryStats stats)
    {
        boolean positive = stats.getLives() >= 0
                && stats.getMovement() >= 0
                && stats.getExperience() >= 0
                && stats.getAgility() >= 0
                && stats.getHardiness() >= 0
                && stats.getStrength() >= 0
                && stats.getIntellect() >= 0;


        if (positive) {
            primaryStats = stats;

            updateDerivedStats();
            calculateTotalDerivedStats();
        }

        return positive;
    }

    /*
    * Updates values of derived stats based on primary stats
    * */
    private void updateDerivedStats()
    {
        derivedStats.deriveLevel(primaryStats.getExperience());
        derivedStats.deriveLife(primaryStats.getHardiness());
        derivedStats.deriveMana(primaryStats.getIntellect());
        derivedStats.deriveOffensiveRating(primaryStats.getStrength());
        derivedStats.deriveDefensiveRating(primaryStats.getAgility());
        derivedStats.deriveArmorRating(primaryStats.getHardiness());

        calculateTotalDerivedStats();
    }

    /*
    * Updates true derived stats based on base derived stats and flat derived bonuses
    * */
    private void calculateTotalDerivedStats()
    {
        int level = derivedStats.getLevel(),
                life = derivedStats.getLife(),
                mana = derivedStats.getMana(),
                offRate = derivedStats.getOffensiveRating(),
                defRate = derivedStats.getDefensiveRating(),
                armorRate = derivedStats.getArmorRating();

        for (DerivedStats d : flatBonus)
        {
            level += d.getLevel();
            life += d.getLife();
            mana += d.getMana();

            offRate += d.getOffensiveRating();
            defRate += d.getDefensiveRating();
            armorRate += d.getArmorRating();
        }

        totalStats = new DerivedStats(
                derivedStats.getStrategy(),
                level,
                life,
                mana,
                offRate,
                defRate,
                armorRate
        );
    }

    /*
    * Addition of provided DerivedStats
    *
    * Returns true if primary stats were valid (all positive after addition)
    *
    * Returns false if primary stats were invalid (at least one negative after addition)
    * */
    public boolean addDerivedStat(DerivedStats stat)
    {
        boolean valid = validateDerivedAddition(stat);

        if (valid)
        {
            flatBonus.add(stat);

            if (flatBonus.size() > 50)
                compressFlatBonus();
        }

        calculateTotalDerivedStats();

        return valid;
    }

    /*
    * Verifies that a provided DerivedStats object can be applied to entity stats
    * */
    private boolean validateDerivedAddition(DerivedStats stats)
    {
        int[] tempStats = new int[6];

        tempStats[0] = totalStats.getLevel()            + stats.getLevel();
        tempStats[1] = totalStats.getLife()             + stats.getLife();
        tempStats[2] = totalStats.getMana()             + stats.getMana();
        tempStats[3] = totalStats.getOffensiveRating()  + stats.getOffensiveRating();
        tempStats[4] = totalStats.getDefensiveRating()  + stats.getDefensiveRating();
        tempStats[5] = totalStats.getArmorRating()      + stats.getArmorRating();


        for (int i = 0; i < tempStats.length; i++)
        {
            if (tempStats[i] < 0)
                return false;
        }

        return true;
    }

    private void compressFlatBonus()
    {
        if (flatBonus.size() == 1)
            return;

        int[] statArray = new int[6];


        for (DerivedStats d : flatBonus)
        {
            statArray[0] += d.getLevel();
            statArray[1] += d.getLife();
            statArray[2] += d.getMana();
            statArray[3] += d.getOffensiveRating();
            statArray[4] += d.getDefensiveRating();
            statArray[5] += d.getArmorRating();
        }

        flatBonus.clear();

        flatBonus.add(new DerivedStats(
                statArray[0],
                statArray[1],
                statArray[2],
                statArray[3],
                statArray[4],
                statArray[5]));
    }

    /*
    * Accessors - Derived
    * */
    public int getLevel()
    {
    return totalStats.getLevel();
    }

    public int getLife()
    {
    return totalStats.getLife();
    }

    public int getMana()
    {
    return totalStats.getMana();
    }

    public int getOffensiveRating()
    {
    return totalStats.getOffensiveRating();
    }

    public int getDefensiveRating()
    {
    return totalStats.getDefensiveRating();
    }

    public int getArmorRating()
    {
    return totalStats.getArmorRating();
    }

    /*
    * Accessors - Primary
    * */

    public int getLives()
    {
    return primaryStats.getLives();
    }

    public int getStrength()
    {
    return primaryStats.getStrength();
    }

    public int getAgility()
    {
    return primaryStats.getAgility();
    }

    public int getIntellect()
    {
    return primaryStats.getIntellect();
    }

    public int getHardiness()
    {
    return primaryStats.getHardiness();
    }

    public int getExperience()
    {
    return primaryStats.getExperience();
    }

    public int getMovement()
    {
    return primaryStats.getMovement();
    }

    /*
    * Accessors - bonus stats
    * */

    public int getFlatBonusLevel()
    {
        compressFlatBonus();

        return flatBonus.get(0).getLevel();
    }

    public int getFlatBonusLife()
    {
        compressFlatBonus();

        return flatBonus.get(0).getLife();
    }

    public int getFlatBonusMana()
    {
        compressFlatBonus();

        return flatBonus.get(0).getMana();
    }

    public int getFlatBonusOffensiveRating()
    {
        compressFlatBonus();

        return flatBonus.get(0).getOffensiveRating();
    }

    public int getFlatBonusDefensiveRating()
    {
        compressFlatBonus();

        return flatBonus.get(0).getDefensiveRating();
    }

    public int getFlatBonusArmorRating()
    {
        compressFlatBonus();

        return flatBonus.get(0).getArmorRating();
    }


    /*
    * Modify with delta - Primary
    *
    * Return true if delta successfully applied
    * */

    public boolean changeLives(int delta)
    {
        int newLives = primaryStats.getLives() + delta;

        boolean valid = true;

        if (newLives < 0)
            valid = false;

        if (newLives > 3)
            newLives = 3;

        if (valid)
            primaryStats.setLives(newLives);

        return valid;
    }

    public boolean changeStrength(int delta)
    {
        int newStrength = primaryStats.getStrength() + delta;

        boolean valid = true;

        if (newStrength < 0)
            valid = false;

        if (valid) {
            primaryStats.setStrength(newStrength);
            derivedStats.deriveOffensiveRating(newStrength);

            calculateTotalDerivedStats();
        }

        return valid;
    }

    public boolean changeAgility(int delta)
    {
        int newAgility = primaryStats.getAgility() + delta;

        boolean valid = true;

        if (newAgility < 0)
            valid = false;

        if (valid) {
            primaryStats.setAgility(newAgility);
            derivedStats.deriveDefensiveRating(newAgility);

            calculateTotalDerivedStats();
        }

        return valid;
    }

    public boolean changeIntellect(int delta)
    {
        int newIntellect = primaryStats.getIntellect() + delta;

        boolean valid = true;

        if (newIntellect < 0)
            valid = false;

        if (valid) {
            primaryStats.setIntellect(newIntellect);
            derivedStats.deriveMana(newIntellect);

            calculateTotalDerivedStats();
        }

        return valid;
    }

    public boolean changeHardiness(int delta)
    {
        int newHardiness = primaryStats.getHardiness() + delta;

        boolean valid = true;

        if (newHardiness < 0)
            valid = false;

        if (valid) {
            primaryStats.setHardiness(newHardiness);
            derivedStats.deriveArmorRating(newHardiness);
            derivedStats.deriveLife(newHardiness);

            calculateTotalDerivedStats();
        }

        return valid;
    }

    public boolean changeExperience(int delta)
    {
        int newExperience = primaryStats.getExperience() + delta;

        boolean valid = true;

        if (newExperience < 0)
            valid = false;

        if (valid) {
            primaryStats.setExperience(newExperience);
            derivedStats.deriveLevel(newExperience);
        }

        return valid;
    }

    public boolean changeMovement(int delta)
    {
        int newMovement = primaryStats.getMovement() + delta;

        boolean valid = true;

        if (newMovement < 0)
            valid = false;

        if (valid)
            primaryStats.setMovement(newMovement);

        return valid;
    }
}
