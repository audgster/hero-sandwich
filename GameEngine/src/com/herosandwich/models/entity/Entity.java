package com.herosandwich.models.entity;

import com.herosandwich.util.visitor.EntityVisitor;

public class Entity
{
    /*
    * Naming
    * */
    private String name;

    /*
    * Stats
    * */
    private EntityStats stats;

    public Entity()
    {
        stats = new EntityStats();

        currentLife = getMaxLife();
        currentMana = getMaxMana();

        name = "Merp entity";
    }

    private int currentLife;
    private int currentMana;

    /*
    * Accessors
    * */

    public String getName()
    {
        return name;
    }

    //Primary Stats
    public int getLives()
    {
        return stats.getLives();
    }

    public int getStrength()
    {
        return stats.getStrength();
    }

    public int getAgility()
    {
        return stats.getAgility();
    }

    public int getIntellect()
    {
        return stats.getIntellect();
    }

    public int getHardiness()
    {
        return stats.getHardiness();
    }

    public int getExperience()
    {
        return stats.getExperience();
    }

    public int getMovement()
    {
        return stats.getMovement();
    }

    // Derived Stats
    public int getLevel()
    {
        return stats.getLevel();
    }

    public int getMaxLife()
    {
        return stats.getLife();
    }

    public int getMaxMana()
    {
        return stats.getMana();
    }

    public int getOffensiveRating()
    {
        return stats.getOffensiveRating();
    }

    public int getDefensiveRating()
    {
        return stats.getDefensiveRating();
    }

    public int getArmorRating()
    {
        return stats.getArmorRating();
    }

    // Other
    public int getCurrentLife()
    {
        return this.currentLife;
    }

    public int getCurrentMana()
    {
        return this.currentMana;
    }

    /*
    * Modifiers
    * */

    public void setName(String name)
    {
        this.name = name;
    }

    //Primary stat modifiers
    public boolean modifyLives(int delta)
    {
        return stats.changeLives(delta);
    }

    public boolean modifyStrength(int delta)
    {
        return stats.changeStrength(delta);
    }

    public boolean modifyAgilty(int delta)
    {
        return stats.changeAgility(delta);
    }

    public boolean modifyIntellect(int delta)
    {
        return stats.changeIntellect(delta);
    }

    public boolean modifyExperience(int delta)
    {
        return stats.changeExperience(delta);
    }

    public boolean modifyMovement(int delta)
    {
        return stats.changeMovement(delta);
    }

    //Derived stat modifiers
    public boolean modifyLevel(int level)
    {
        return stats.addDerivedStat(new DerivedStats(level,0,0,0,0,0));
    }

    public boolean modifyMaxLife(int life)
    {
        return stats.addDerivedStat(new DerivedStats(0,life,0,0,0,0));
    }

    public boolean modifyMaxMana(int mana)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,mana,0,0,0));
    }

    public boolean modifyOffensiveRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,rating,0,0));
    }

    public boolean modifyDefensiveRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,0,rating,0));
    }

    public boolean modifyArmorRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,0,0,rating));
    }

    // Other modifiers

    public void modifyCurrentLife(int delta)
    {
        int newCurrentLife = getCurrentLife() + delta;
        int maxLife = getMaxLife();

        if (newCurrentLife > maxLife)
        {
            newCurrentLife = maxLife;
        }
        else if (newCurrentLife <= 0)
        {
            if (getLives() == 1)
            {
                newCurrentLife = 0;
                modifyLives(-1);
            }
            else
            {
                newCurrentLife = maxLife;
                modifyLives(-1);
            }
        }

        this.currentLife = newCurrentLife;
    }

    public void modifyCurrentMana(int delta)
    {
        int newCurrentMana = getCurrentMana() + delta;
        int maxMana = getMaxMana();

        if (newCurrentMana > maxMana)
        {
            newCurrentMana = maxMana;
        }
        else if (newCurrentMana <= 0)
        {
            newCurrentMana = 0;
        }

        this.currentLife = newCurrentMana;
    }

    /*
    * Methods
    * */

    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visit(this);
    }

}
