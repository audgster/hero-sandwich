package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Entity;

public class Sneak extends Property{
    private int creepSkill = 1;
    private int detectionSkill = 1;
    private int pickPocketSkill = 1;
    private int weaponSkill = 1;

    public void creep(Entity entity){
        if(successfulAction(this.creepSkill) ){
            entity.modifyAgilty(30);
        }
        //needs to reset value of modification when exits creep mode
    }

    public void detectAndRemoveTrap(Entity npc){
        if(successfulAction(this.detectionSkill) ){

        }
    }

    public void pickPocket(){
        if(successfulAction(this.pickPocketSkill) ){

        }
    }

    public void rangedWeaponAttack(){
        if(successfulAction(this.weaponSkill) ){

        }
    }

    @Override
    public void levelUp(int creepIncrease, int detectionIncrease, int pickPocketIncrease, int weaponIncrease ){
        this.creepSkill += creepIncrease;
        this.detectionSkill +=  detectionIncrease;
        this.pickPocketSkill += pickPocketIncrease;
        this.weaponSkill += weaponIncrease;
    }
}
