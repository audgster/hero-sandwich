package com.herosandwich.creation.init;

/**
 * Created by simonnea on 3/13/16.
 */
public class NpcStats
{
    public enum Strength
    {
        VERY_WEAK,
        WEAK,
        AVERAGE,
        STRONG,
        VERY_STRONG,
        BOSS
    }

    public static int lives = 1;
    public static int strength = 3;
    public static int agility = 3;
    public static int intellect = 3;
    public static int hardiness = 3;
    public static int experience = 0;
    public static int movement = 15;
}
