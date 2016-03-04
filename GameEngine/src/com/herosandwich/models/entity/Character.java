package com.herosandwich.models.entity;

import java.util.HashMap;

public class Character extends Entity {
    private HashMap<String, Integer> skillPoints;
    private int availablePoints;

    public void giveAvailablePoints(int points)
    {
        if (points > 0)
            availablePoints += points;
    }

    public int getNumberOfSkillPoints(String skill)
    {
        if (skillPoints.containsKey(skill))
            return skillPoints.get(skill);

        return 0;
    }

    public void allocateSkillPoints(String skill, int numberOfPoints)
    {
        if (numberOfPoints > availablePoints)
            return;

        Integer points = skillPoints.get(skill) + numberOfPoints;
        skillPoints.replace(skill, points);
        availablePoints -= points;
    }
}
