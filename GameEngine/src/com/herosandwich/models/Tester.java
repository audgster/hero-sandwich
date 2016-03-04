package com.herosandwich.models;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Player;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Sneak;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Tester {

    public static void main(String args[]){
        Entity i = new Player();
        if(  i.getOccupation() instanceof Sneak){
          System.out.println("yep");
        }else{
            System.out.println("No good");
        }
    }


}
