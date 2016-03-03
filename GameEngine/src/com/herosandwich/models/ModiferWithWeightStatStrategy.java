package com.herosandwich.models;

public class ModiferWithWeightStatStrategy extends DeriveStatStrategy
{
    int baseModifier;

    public ModiferWithWeightStatStrategy(int modifier)
    {
        baseModifier = modifier;
    }

    @Override
    public int deriveLevel(int exp) {
        return exp / 100 + 1;
    }

    @Override
    public int deriveLife(int level, int hardiness)
    {
        int levelPart = (int) (level * baseModifier * .4);
        int hardPart = (int) (hardiness * baseModifier * .6);

        return levelPart + hardPart;
    }

    @Override
    public int deriveMana(int level, int intellect) {
        int levelPart = (int) (level * baseModifier * .5);
        int intelPart = (int) (intellect * baseModifier * .5);

        return levelPart + intelPart;
    }

    @Override
    public int deriveOffensiveRating(int level, int strength) {
        int levelPart = (int) (level * baseModifier * .35);
        int strengthPart = (int) (strength * baseModifier * .65);

        return levelPart + strengthPart;
    }

    @Override
    public int deriveDefensiveRating(int level, int agility) {
        int levelPart = (int) (level * baseModifier * .6);
        int agilityPart = (int) (agility * baseModifier * .4);

        return levelPart + agilityPart;
    }

    @Override
    public int deriveArmorRating(int hardiness) {
        return hardiness * baseModifier;
    }
}
