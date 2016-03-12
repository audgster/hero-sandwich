package com.herosandwich.models;

import com.herosandwich.creation.entity.CharacterFactory;
import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.occupation.Property;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Summoner;


/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Tester {

    public static void main(String[] args){
        DeriveStatStrategy statStrategy = new ModiferWithWeightStatStrategy(10);
        Summoner occupation = new Summoner();
        CharacterFactory factory = new CharacterFactory();
        Character dave = factory.vendCustomInstance("DaveTheBoss", 3, 10, 10, 10, 10, 10, 10, statStrategy, occupation);
        occupation.boonSpell();
    }

}
