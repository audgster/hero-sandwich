package com.herosandwich.models.occupation;

import com.herosandwich.models.items.Item;

public class Smasher extends Property{
    //Skills will range from 1 to 100
    private int brawlSkill = 1;
    private int enragedSkill = 1;
    private int oneHandedWeaponSkill = 1;
    private int twoHandedWeaponSkill = 1;

    //possibly visitor pattern!!
    public void attack(){
        if(true){
            oneHandedAttack();
        }else if(false){
            twoHandedAttack();
        }else{
            brawl();
        }
    }

    private void brawl(){
        if(successfulAction(brawlSkill) ){

        }
    }

    private void oneHandedAttack(){
        if(successfulAction(oneHandedWeaponSkill) ){

        }
    }

    private void twoHandedAttack(){
        if(successfulAction(twoHandedWeaponSkill) ){

        }
    }

    //increased damage for a short period
    public void enrage(){
        if(successfulAction(enragedSkill) ){

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
