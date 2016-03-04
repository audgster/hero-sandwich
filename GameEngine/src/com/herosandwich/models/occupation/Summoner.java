package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Entity;

public class Summoner extends Property{
    private int baneSkill = 1;
    private int boonSkill = 1;
    private int enchantmentSkill = 1;
    private int staffSkill = 1;

    public void attackWithStaff(){
        if(successfulAction(this.staffSkill) ){

        }
    }

    // bane - magic that does damage or harm.
    public void baneSpell(){
        if(successfulAction(this.baneSkill) ){

        }
    }

    public void boonSpell(){
        if(successfulAction(this.boonSkill) ){

        }
    }

    public void enchantmentSpell(){
        if(successfulAction(this.enchantmentSkill) ){

        }
    }


    public void levelUp(int baneIncrease, int boonIncrease, int enchantmentIncrease, int staffIncrease){
        this.baneSkill += baneIncrease;
        this.boonSkill += boonIncrease;
        this.enchantmentSkill += enchantmentIncrease;
        this.staffSkill += staffIncrease;
    }
}
