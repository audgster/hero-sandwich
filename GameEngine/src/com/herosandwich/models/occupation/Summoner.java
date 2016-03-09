package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;

public class Summoner extends Property{
    private int baneSkill;
    private int boonSkill;
    private int enchantmentSkill;
    private int staffSkill;

    public Summoner(Character c){
        super(c);
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

    @Override
    public void updateOccupationSkills(){
        this.baneSkill = character.getNumberOfSkillPoints(Skill.BANE);
        this.boonSkill = character.getNumberOfSkillPoints(Skill.BOON);
        this.enchantmentSkill = character.getNumberOfSkillPoints(Skill.ENCHANTMENT);
        this.staffSkill = character.getNumberOfSkillPoints(Skill.STAFF);
    }

    public String toString(){
        return "Summoner";
    }
}
