package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Attitude;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Npc;
import com.herosandwich.models.entity.Skill;

public class Summoner extends Property{
    private int baneSkill;
    private int boonSkill;
    private int enchantmentSkill;
    private int staffSkill;

    public Summoner(){
        this.baneSkill = 0;
        this.boonSkill = 0;
        this.enchantmentSkill = 0;
        this.staffSkill = 0;
    }

    public Summoner(Character owner){
        super(owner);
        updateOccupationSkills();
    }

    public void attackWithStaff(){
        if(successfulAction(this.staffSkill) ){

        }
    }

    // bane - magic that does damage or harm.
    //Summoner's attack
    public void baneSpell(){
        if(successfulAction(this.baneSkill) ){
            owner.modifyCurrentMana(-5);
            //the damageCalculator will deal with this!
        }
    }

    // magic that heals Character over 10 seconds!
    public void boonSpell(){
        //boon spell is disallowed at full health
        if(owner.getCurrentLife() ==  owner.getMaxLife() ){
            return;
        }

        //do you have mana?

        if(successfulAction(this.boonSkill) ){
            //uses mana! Mana reduction depends on Strength of spell
            owner.modifyCurrentMana(-5);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int healingAmount = (int)(1 + (boonSkill*.2));

                    for(int i = 0; i < 10; i++){
                        owner.modifyCurrentLife(healingAmount);
                        System.out.println(owner.getCurrentLife());

                        //if after healing, current heal is the same as max heal
                        //end boon healing
                        if(owner.getCurrentLife() ==  owner.getMaxLife() ){
                            return;
                        }

                        try{
                            Thread.sleep(1000);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
            thread.start();
        }
    }

    public void enchantmentSpell(Npc npc){
        if(successfulAction(this.enchantmentSkill) ){
            //if successful will make npc more friendly
            owner.modifyCurrentMana(-5);
            npc.changeAttitude(true);
        }else{
            // if enchantment spell fails, make the target hostile
            npc.setAttitudeTowardsPlayer(Attitude.HOSTILE);
        }
    }

    @Override
    public void updateOccupationSkills(){
        this.baneSkill = owner.getNumberOfSkillPoints(Skill.BANE);
        this.boonSkill = owner.getNumberOfSkillPoints(Skill.BOON);
        this.enchantmentSkill = owner.getNumberOfSkillPoints(Skill.ENCHANTMENT);
        this.staffSkill = owner.getNumberOfSkillPoints(Skill.STAFF);
    }


    @Override
    public String toString()
    {
        return "summoner";

    }
}
