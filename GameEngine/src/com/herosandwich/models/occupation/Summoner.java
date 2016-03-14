package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Attitude;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Npc;
import com.herosandwich.models.entity.Skill;

public class Summoner extends Occupation{

    public Summoner(){
        super();
        learned_skills.add(Skill.BANE);
        learned_skills.add(Skill.BOON);
        learned_skills.add(Skill.ENCHANTMENT);
        learned_skills.add(Skill.STAFF);
        //when a character is created all skill levels are zero
    }

    public Summoner(Character owner){
        super(owner);
        learned_skills.add(Skill.BANE);
        learned_skills.add(Skill.BOON);
        learned_skills.add(Skill.ENCHANTMENT);
        learned_skills.add(Skill.STAFF);
        //when a character is created all skill levels are zero
        updateOccupationSkills();
    }

    public void attackWithStaff(){
        //if(successfulAction(this.staffSkill) ){

        //}
    }

    // bane - magic that does damage or harm.
    //Summoner's attack
    public void baneSpell(){
        //no mana? no spell :/
        if(owner.getCurrentMana() == 0){
            return;
        }

        if(successfulAction(Skill.BANE) ){
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

        //no mana? no spell :/
        if(owner.getCurrentMana() == 0){
            return;
        }

        if(successfulAction(Skill.BOON) ){
            //uses mana! Mana reduction depends on Strength of spell
            owner.modifyCurrentMana(-5);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int boonSkill = getLevelOfSkill(Skill.BOON);
                    int healingAmount = (int)(1 + (boonSkill*.3));

                    for(int i = 0; i < 10; i++){
                        owner.modifyCurrentLife(healingAmount);

                        //if after healing, current heal is the same as max heal
                        //end boon healing
                        if(owner.getCurrentLife() ==  owner.getMaxLife() ){ return; }

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
        //no mana? no spell :/
        if(owner.getCurrentMana() == 0){
            return;
        }

        if(successfulAction(Skill.ENCHANTMENT) ){
            //if successful will make npc more friendly
            owner.modifyCurrentMana(-5);
            npc.changeAttitude(true);
        }else{
            // if enchantment spell fails, make the target hostile
            npc.setAttitudeTowardsPlayer(Attitude.HOSTILE);
        }
    }

    @Override
    public String toString() {
        return "Summoner";

    }

    public String getDescription(){ return "A sandwich that can move around and talk? It must be magic.";}
}
