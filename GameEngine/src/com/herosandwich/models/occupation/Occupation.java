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

    /*
    * General Skills
    */
    public final void bindWounds(){
        if(successfulAction(Skill.BIND_WOUNDS) ){

        }
    }

    public final void bargain(){
        if(successfulAction(Skill.BARGAIN)){

        }
    }

    public final void observation(){
        if(successfulAction(Skill.OBSERVATION)){

        }
    }

    //probability of action success. More likely to be successful if occupation has
    //a high level for that skill!!
    public boolean successfulAction(Skill skill){
        int skillLevel = getLevelOfSkill(skill);
        int prob = (int) Math.ceil(Math.random() * 100) + skillLevel;
        if(prob > 50){
            return true;
        }
        return false;
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
