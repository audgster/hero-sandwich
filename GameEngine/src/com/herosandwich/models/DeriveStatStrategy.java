package com.herosandwich.models;

public abstract class DeriveStatStrategy
{
    public abstract int deriveLevel(int exp);

    public abstract int deriveLife(int level, int hardiness);

    public abstract int deriveMana(int level, int intellect);

    public abstract int deriveOffensiveRating(int level, int strength);

    public abstract int deriveDefensiveRating(int level, int agility);

    public abstract int deriveArmorRating(int hardiness);
}
