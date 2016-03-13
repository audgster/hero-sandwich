package com.herosandwich.models.equipment;

/**
 * Created by simonnea on 3/4/16.
 */
public enum EquipmentSlots
{
    HEAD,
    CHEST,
    LEFT_HAND,
    RIGHT_HAND,
    LEGGINGS,
    FEET;

    public static EquipmentSlots convertFromString(String s)
    {
        s = s.toLowerCase();

        switch (s)
        {
            case "head":
                return EquipmentSlots.HEAD;
            case "chest":
                return EquipmentSlots.CHEST;
            case "left_hand":
                return EquipmentSlots.LEFT_HAND;
            case "right_head":
                return EquipmentSlots.RIGHT_HAND;
            case "leggings":
                return EquipmentSlots.LEGGINGS;
            case "feet":
                return EquipmentSlots.FEET;
            default:
                throw new IllegalArgumentException("Could not parse string " + s + "to an EquipmentSots enum");
        }
    }
}
