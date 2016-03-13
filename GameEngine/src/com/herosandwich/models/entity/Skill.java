package com.herosandwich.models.entity;

/**
 * Created by matthewdiaz on 3/7/16.
 */
public enum Skill
{
    BANE,
    BARGAIN,
    BIND_WOUNDS,
    BOON,
    BRAWL,
    CREEP,
    DETECTION,
    ENCHANTMENT,
    ONE_HANDED_WEAPON,
    OBSERVATION,
    PICK_POCKET,
    STAFF,
    RANGED_WEAPON,
    REMOVE_TRAP,
    TWO_HANDED_WEAPON;

    public static Skill convertFromString(String s)
    {
        s = s.toLowerCase();

        switch (s)
        {
            case "bane":
                return Skill.BANE;
            case "bargain":
                return Skill.BARGAIN;
            case "bind_wounds":
                return Skill.BIND_WOUNDS;
            case "boon":
                return Skill.BOON;
            case "brawl":
                return Skill.BRAWL;
            case "creep":
                return Skill.CREEP;
            case "detection":
                return Skill.DETECTION;
            case "enchantment":
                return Skill.ENCHANTMENT;
            case "one_handed_weapon":
                return Skill.ONE_HANDED_WEAPON;
            case "observation":
                return Skill.OBSERVATION;
            case "pick_pocket":
                return Skill.PICK_POCKET;
            case "staff":
                return Skill.STAFF;
            case "ranged_weapon":
                return Skill.RANGED_WEAPON;
            case "remove_trap":
                return Skill.REMOVE_TRAP;
            case "two_handed_weapon":
                return Skill.TWO_HANDED_WEAPON;
            default:
                throw new IllegalArgumentException("Cannot convert string: " + s + " to type Skill");
        }
    }
}
