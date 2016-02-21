package com.herosandwich.models;

public class PrimaryStats
{
    private int strength;
    private int agility;
    private int intellect;

    private int hardiness;
    private int experience;
    private int movement;

    public PrimaryStats(int strength, int agility, int intellect, int hardiness, int experience, int movement)
    {
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hardiness = hardiness;
        this.experience = experience;
        this.movement = movement;
    }

    public PrimaryStats()
    {
        this.strength = 0;
        this.agility = 0;
        this.intellect = 0;
        this.hardiness = 0;
        this.experience = 0;
        this.movement = 0;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getAgility()
    {
        return agility;
    }

    public int getIntellect()
    {
        return intellect;
    }

    public int getHardiness()
    {
        return hardiness;
    }

    public int getExperience()
    {
        return experience;
    }

    public int getMovement()
    {
        return movement;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
    }

    public void setIntellect(int intellect)
    {
        this.intellect = intellect;
    }

    public void setHardiness(int hardiness)
    {
        this.hardiness = hardiness;
    }

    public void setExperience(int experience)
    {
        this.experience = experience;
    }

    public void setMovement(int movement)
    {
        this.movement = movement;
    }
}
