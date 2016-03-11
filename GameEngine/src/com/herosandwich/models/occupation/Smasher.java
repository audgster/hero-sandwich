package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.BrawlWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.TwoHandedWeapon;

public class Smasher extends Property{
    //Skills will range from 0 to 100
    private int brawlSkill;
    private int oneHandedWeaponSkill;
    private int twoHandedWeaponSkill;

    public Smasher(){
        this.brawlSkill = 0;
        this.oneHandedWeaponSkill = 0;
        this.twoHandedWeaponSkill = 0;
    }


    public Smasher(Character owner){
        super(owner);
        updateOccupationSkills();
    }

    //maybe state pattern.
    public int attack(){
       // EquipableItem item = character.getEquipedItem(EquipmentSlots.LEFTARM);

        int damage = 0;
        if(successfulAction(oneHandedWeaponSkill) ){
         //   damage += character.getOffensiveRating();
           // damage += item.getWeaponsOffensiveRating();
            damage *=1.5;// One handed weapons are stronger than normal
        }
        return damage;
    }

    //still need to delay twohandedWeapon :/
    public int attack(TwoHandedWeapon weapon){
        int damage = 0;
        if(successfulAction(twoHandedWeaponSkill) ){
         //   damage += character.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
            damage *=2;// Two handed weapons are very powerful than normal
        }
        return damage;
    }

    public int attack(BrawlWeapon weapon){
        int damage = 0;
        if(successfulAction(brawlSkill) ){
         //   damage += character.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
           // One handed weapons are stronger than normal
        }
        return damage;
    }


    @Override
    public void updateOccupationSkills(){
        this.brawlSkill = owner.getNumberOfSkillPoints(Skill.BRAWL);
        this.oneHandedWeaponSkill = owner.getNumberOfSkillPoints(Skill.ONE_HANDED_WEAPON);
        this.twoHandedWeaponSkill = owner.getNumberOfSkillPoints(Skill.TWO_HANDED_WEPON);
    }

    @Override
    public String toString()
    {
        return "smasher";
    }
}
