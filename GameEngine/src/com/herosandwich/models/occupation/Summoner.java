package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
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
    public void baneSpell(){
        if(successfulAction(this.baneSkill) ){
            //character.modifyCurrentMana(-10);

        }
    }

    //uses mana!
    public void boonSpell(){
        if(successfulAction(this.boonSkill) ){
            // magic that heals, temporarily grants (partial) immunities and defensive bonuses!
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10; i++){
                        owner.modifyCurrentLife(-2);
                        System.out.println(owner.getCurrentLife());
                        try{
                            Thread.sleep(1000);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
            t1.start();
            //enchantmentSkill.modifyCurrentLife(2);//increase life by 2 per second
        }
    }

    public void enchantmentSpell(){
        if(successfulAction(this.enchantmentSkill) ){
          //  enchantmentSkill.modifyCurrentMana(-10);
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
    public String toString() {
        return "Summoner";
    }
}
