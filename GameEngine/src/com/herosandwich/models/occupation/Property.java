package com.herosandwich.models.occupation;


import com.herosandwich.models.entity.Character;

public abstract class Property{
    protected Character owner;

    public Property(){}

    public Property(Character owner){
        this.owner = owner;
    }

    public boolean successfulAction(int skillLevel){
        int prob = (int) Math.ceil(Math.random() * 100) + skillLevel;
        if(prob > 50){
            return true;
        }
        return false;
    }

    public abstract void updateOccupationSkills();

    public void setOwner(Character owner){
        this.owner = owner;
    }
}
