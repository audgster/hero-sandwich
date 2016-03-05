package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.BrawlWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.OneHandedWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.TwoHandedWeapon;

public class Smasher extends Property{
    //Skills will range from 1 to 100
    private int brawlSkill = 1;
    private int enragedSkill = 1;
    private int oneHandedWeaponSkill = 1;
    private int twoHandedWeaponSkill = 1;

    //maybe state pattern.
    public int attack(Entity entity, OneHandedWeapon weapon){
        int damage = 0;
        if(successfulAction(oneHandedWeaponSkill) ){
            damage += entity.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
            damage *=1.5;// One handed weapons are stronger than normal
        }
        return damage;
    }

    //still need to delay twohandedWeapon :/
    public int attack(Entity entity, TwoHandedWeapon weapon){
        int damage = 0;
        if(successfulAction(twoHandedWeaponSkill) ){
            damage += entity.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
            damage *=2;// Two handed weapons are very powerful than normal
        }
        return damage;
    }

    public int attack(Entity entity, BrawlWeapon weapon){
        int damage = 0;
        if(successfulAction(brawlSkill) ){
            damage += entity.getOffensiveRating();
            damage += weapon.getWeaponsOffensiveRating();
           // One handed weapons are stronger than normal
        }
        return damage;
    }

    //increased damage for a short period
    //should then modify back to normal afterwards!
    public void enrage(Entity entity){
        if(successfulAction(enragedSkill) ){
            int extraOffense = 20 + enragedSkill;
            entity.modifyArmorRating(extraOffense);
        }
    }

    @Override
    public void levelUp(int brawlIncrease, int enrageIncrease, int oneHeadedIncrease, int twoHandedIncrease ){
        this.brawlSkill += brawlIncrease;
        this.enragedSkill += enrageIncrease;
        this.oneHandedWeaponSkill += oneHeadedIncrease;
        this.twoHandedWeaponSkill += twoHandedIncrease;

    }
}
