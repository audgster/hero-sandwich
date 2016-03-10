package com.herosandwich.models.occupation;


import com.herosandwich.models.entity.Character;

public abstract class Property{


    public boolean successfulAction(int skillLevel){
        int prob = (int) Math.ceil(Math.random() * 100) + skillLevel;
        if(prob > 50){
            return true;
        }
        return false;
    }

    public abstract void updateOccupationSkills(Character c);
}
