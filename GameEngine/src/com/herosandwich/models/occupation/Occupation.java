package com.herosandwich.models.occupation;


import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;

public abstract class Occupation{
    protected Character owner;

    public Occupation(){}

    public Occupation(Character owner){
        this.owner = owner;
    }

    public boolean successfulAction(int skillLevel){
        int prob = (int) Math.ceil(Math.random() * 100) + skillLevel;
        if(prob > 50){
            return true;
        }
        return false;
    }

    /*
     * General Skills
     */
    public final void bindWounds(){
        if(successfulAction(owner.getNumberOfSkillPoints(Skill.BIND_WOUNDS))){

        }
    }

    public final void bargain(){
        if(successfulAction(owner.getNumberOfSkillPoints(Skill.BARGAIN))){

        }
    }

    public final void observation(){
        if(successfulAction(owner.getNumberOfSkillPoints(Skill.OBSERVATION))){

        }
    }


    public abstract void updateOccupationSkills();

    public void setOwner(Character owner){
        this.owner = owner;
    }

    public abstract String getDescription();

}
