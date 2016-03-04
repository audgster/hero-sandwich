package com.herosandwich.models.entity;

public class Player extends Character {

    // Overriding for the freeing of skill points
    public boolean modifyLevel(int level)
    {
        boolean result = super.modifyLevel(level);

        if (result && level > 0)
        {
            giveAvailablePoints(3 * level);
        }

        return result;
    }

    // Overriding for the freeing of skill points
    public boolean modifyExperience(int delta)
    {
        int oldLevel = getLevel();

        boolean result = super.modifyExperience(delta);

        int newLevel = getLevel();

        int diff = newLevel - oldLevel;

        if (diff > 0)
        {
            giveAvailablePoints(diff * 3);
        }

        return result;
    }
}
