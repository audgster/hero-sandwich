package com.herosandwich.models.occupation;



public abstract class Property{

    public boolean successfulAction(int skillLevel){
        int prob = (int) Math.ceil(Math.random() * 100) + skillLevel;
        if(prob > 50){
            return true;
        }
        return false;
    }

    public abstract void levelUp(int skill1lIncrease, int skill2Increase, int skill3Increase, int skill4Increase );
}
