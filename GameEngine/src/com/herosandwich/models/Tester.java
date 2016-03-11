package com.herosandwich.models;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.entity.EntityStats;
import com.herosandwich.models.entity.PrimaryStats;
import com.herosandwich.models.occupation.Summoner;


/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Tester {

    public static void main(String[] args){
        Summoner summoner = new Summoner();
        DerivedStats derivedStats = new DerivedStats(1,50,30,2,2,2);
        PrimaryStats primaryStats = new PrimaryStats(5,30,10,10,2,3,1);
        EntityStats stats = new EntityStats(primaryStats, derivedStats);
        Character matt = new Character("matt",stats, summoner);
        System.out.println(matt.getName());

        System.out.println(matt.getCurrentLife());
        summoner.boonSpell();
    }

}
