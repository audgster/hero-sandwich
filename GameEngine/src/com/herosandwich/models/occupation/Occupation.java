package com.herosandwich.models.occupation;


import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Occupation{
    protected Character owner;
    protected HashMap<Skill, Integer> occupationSkills;
    protected List<Skill> learned_skills;

    public Occupation(){
        occupationSkills = new HashMap<>();
        learned_skills = new ArrayList<>();
        learned_skills.add(Skill.BIND_WOUNDS);
        learned_skills.add(Skill.BARGAIN);
        learned_skills.add(Skill.OBSERVATION);
    }

    public Occupation(Character owner){
        this.owner = owner;
        occupationSkills = new HashMap<>();
        learned_skills = new ArrayList<>();
        learned_skills.add(Skill.BIND_WOUNDS);
        learned_skills.add(Skill.BARGAIN);
        learned_skills.add(Skill.OBSERVATION);
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

    public final void updateOccupationSkills(){
        for(Skill skill : learned_skills){
            if(occupationSkills.containsKey(skill)){
                occupationSkills.replace(skill, owner.getNumberOfSkillPoints(skill));
            }else{
                occupationSkills.put(skill, owner.getNumberOfSkillPoints(skill));
            }
        }
    }

    public int getLevelOfSkill(Skill skill){
        return occupationSkills.get(skill);
    }

    public void setOwner(Character owner){
        this.owner = owner;
    }

    public abstract String getDescription();

}
