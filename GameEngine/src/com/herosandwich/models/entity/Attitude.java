package com.herosandwich.models.entity;

public enum Attitude
{
    VERY_FRIENDLY,
    FRIENDLY,
    NEUTRAL,
    HOSTILE,
    VERY_HOSTILE;

    public static Attitude convertFromString(String s)
    {
        s = s.toLowerCase();

        switch (s)
        {
            case "very_friendly":
                return Attitude.VERY_FRIENDLY;
            case "friendly":
                return Attitude.FRIENDLY;
            case "neutral":
                return Attitude.NEUTRAL;
            case "hostile":
                return Attitude.HOSTILE;
            case "very_hostile":
                return Attitude.VERY_HOSTILE;
            default:
                throw new IllegalArgumentException("Cannot convert string " + s + " to enum type Attitude");
        }
    }
}
