package com.herosandwich.models;

public class DerivedStats
{
    private int level;
    private int life;
    private int mana;

    private int offensiveRating;
    private int defensiveRating;
    private int armorRating;

    private DeriveStatStrategy strategy;

    public DerivedStats(DeriveStatStrategy strategy, int level, int life, int mana, int offensiveRating, int defensiveRating, int armorRating)
    {
        this.strategy = strategy;

        this.level = level;
        this.life = life;
        this.mana = mana;
        this.offensiveRating = offensiveRating;
        this.defensiveRating = defensiveRating;
        this.armorRating = armorRating;
    }

    public DerivedStats(DeriveStatStrategy strategy)
    {
        this.strategy = strategy;

        this.level = 0;
        this.life = 0;
        this.mana = 0;
        this.offensiveRating = 0;
        this.defensiveRating = 0;
        this.armorRating = 0;
    }

    public DerivedStats(DerivedStats stats)
    {
        this.strategy = stats.strategy;

        this.level = stats.getLevel();
        this.life = stats.getLife();
        this.mana = stats.getMana();

        this.offensiveRating = stats.getOffensiveRating();
        this.defensiveRating = stats.getDefensiveRating();
        this.armorRating = stats.getArmorRating();
    }

    public int getLevel()
    {
        return level;
    }

    public int getLife()
    {
        return life;
    }

    public int getMana()
    {
        return mana;
    }

    public int getOffensiveRating()
    {
        return offensiveRating;
    }

    public int getDefensiveRating()
    {
        return defensiveRating;
    }

    public int getArmorRating()
    {
        return armorRating;
    }

    public DeriveStatStrategy getStrategy()
    {
        return strategy;
    }

    public void deriveLevel(int experience)
    {
        this.level = strategy.deriveLevel(experience);
    }

    public void deriveLife(int hardiness)
    {
        this.life = strategy.deriveLife(this.level, hardiness);
    }

    public void deriveMana(int intellect)
    {
        this.mana = strategy.deriveMana(this.level, intellect);
    }

    public void deriveOffensiveRating(int strength)
    {
        this.offensiveRating = strategy.deriveOffensiveRating(this.level, strength);
    }

    public void deriveDefensiveRating(int agility)
    {
        this.defensiveRating = strategy.deriveDefensiveRating(this.level, agility);
    }

    public void deriveArmorRating(int hardiness)
    {
        this.armorRating = strategy.deriveArmorRating(hardiness);
    }
}
