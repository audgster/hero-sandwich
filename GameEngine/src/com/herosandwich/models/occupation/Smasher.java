package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.BrawlWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.OneHandedWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.TwoHandedWeapon;

public class Smasher extends Property{
    //Skills will range from 1 to 100
    private int brawlSkill;
    private int oneHandedWeaponSkill;
    private int twoHandedWeaponSkill;


    public Smasher(Character c){
        super(c);
        this.brawlSkill = 0;
        this.oneHandedWeaponSkill = 0;
        this.twoHandedWeaponSkill  = 0;
    }

    //maybe state pattern.
    public int attack(OneHandedWeapon weapon){
        int damage = 0;
        if(successfulAction(oneHandedWeaponSkill) ){
            damage += character.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
            damage *=1.5;// One handed weapons are stronger than normal
        }
        return damage;
    }

    //still need to delay twohandedWeapon :/
    public int attack(TwoHandedWeapon weapon){
        int damage = 0;
        if(successfulAction(twoHandedWeaponSkill) ){
            damage += character.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
            damage *=2;// Two handed weapons are very powerful than normal
        }
        return damage;
    }

    public int attack(BrawlWeapon weapon){
        int damage = 0;
        if(successfulAction(brawlSkill) ){
            damage += character.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
           // One handed weapons are stronger than normal
        }
        return damage;
    }


    @Override
    public void updateOccupationSkills(){
        this.brawlSkill = character.getNumberOfSkillPoints(Skill.BRAWL);
        this.oneHandedWeaponSkill = character.getNumberOfSkillPoints(Skill.ONE_HANDED_WEAPON);
        this.twoHandedWeaponSkill = character.getNumberOfSkillPoints(Skill.TWO_HANDED_WEPON);
    }

}
