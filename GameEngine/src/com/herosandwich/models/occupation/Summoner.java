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
            // magic that heals, temporarily grants (partial) immunities and defensive bonuses, improves stats, and other beneficial things.
            //character.modifyCurrentMana(-10);

            //enchantmentSkill.modifyCurrentLife(2);//increase life by 2 per second
        }
    }

    public void enchantmentSpell(){
        if(successfulAction(this.enchantmentSkill) ){
          //  enchantmentSkill.modifyCurrentMana(-10);
        }
    }

    @Override
    public void updateOccupationSkills(Character c){
        this.baneSkill = c.getNumberOfSkillPoints(Skill.BANE);
        this.boonSkill = c.getNumberOfSkillPoints(Skill.BOON);
        this.enchantmentSkill = c.getNumberOfSkillPoints(Skill.ENCHANTMENT);
        this.staffSkill = c.getNumberOfSkillPoints(Skill.STAFF);
    }

    @Override
    public String toString()
    {
        return "summoner";
    }
}
