package com.herosandwich.models.entity;

public class Player extends Character {

    private int availablePoints;

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

    private void giveAvailablePoints(int points)
    {
        if (points > 0)
            availablePoints += points;
    }

    public boolean allocateSkillPoints(String skill, int numberOfPoints)
    {
        if (numberOfPoints > availablePoints)
            return false;

        boolean result = super.allocateSkillPoints(skill, numberOfPoints);
        availablePoints -= numberOfPoints;
        getOccupation().updateOccupationSkills();

        return result;
    }
}
