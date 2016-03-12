package com.herosandwich.models.entity;

import com.herosandwich.util.visitor.EntityVisitor;

public class Player extends Character {

    private int availablePoints;

    public Player()
    {
        super();
        availablePoints = 0;
    }

    public Player(Character character, int availablePoints)
    {
        super(character);

        this.availablePoints = availablePoints;
    }

    public Player(Player player)
    {
        super(player);
        this.availablePoints = player.getAvailablePoints();
    }

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

    public boolean allocateSkillPoints(Skill skill, int numberOfPoints)
    {
        if (numberOfPoints > availablePoints)
            return false;

        boolean result = super.allocateSkillPoints(skill, numberOfPoints);
        availablePoints -= numberOfPoints;
        getOccupation().updateOccupationSkills();

        return result;
    }

    public int getAvailablePoints()
    {
        return this.availablePoints;
    }

    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visitPlayer(this);
    }
}
