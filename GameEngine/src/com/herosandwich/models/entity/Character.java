package com.herosandwich.models.entity;

import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.inventory.Inventory;

import java.util.HashMap;

public class Character extends Entity {

    /*
    * Skill points
    * */
    private HashMap<String, Integer> skillPoints;
    private int availablePoints;

    public Character()
    {
        skillPoints = new HashMap<>();
    }

    public Character(Character character)
    {
        this.skillPoints = character.getSkillPoints();
    }

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

    private HashMap<String, Integer> getSkillPoints()
    {
        return this.skillPoints;
    }
}
