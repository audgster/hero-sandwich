package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;

public class Smasher extends Occupation {

    public Smasher(){
        super();
        learned_skills.add(Skill.ONE_HANDED_WEAPON);
        learned_skills.add(Skill.TWO_HANDED_WEAPON);
        learned_skills.add(Skill.BRAWL);
        //when a character is created all skill levels are zero
    }


    public Smasher(Character owner){
        super(owner);
        learned_skills.add(Skill.ONE_HANDED_WEAPON);
        learned_skills.add(Skill.TWO_HANDED_WEAPON);
        learned_skills.add(Skill.BRAWL);
        //when a character is created all skill levels are zero
        updateOccupationSkills();
    }

//    public int successfulAttack(){
//        owner.getRightHand();
//        return 0;
//    }

    //maybe state pattern.
//    public boolean attack(){
//        if(successfulAction(oneHandedWeaponSkill) ){
//
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "Smasher";
    }

    public String getDescription(){ return "A sandwich who loves to smash things!";}
}