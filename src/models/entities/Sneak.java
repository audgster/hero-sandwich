package models.entities;

import java.util.ArrayList;
import java.util.List;

public class Sneak extends Occupation {

    /* Default constructor */
    public Sneak() {
	// These values will be multiplied by their Entities base stats	
	int strength = 1;
	int agility = 3;
	int intelligence = 7;
	int hardiness = 1;
	int movement = 1;
	super.setStatMods( new StatModifiers(strength, agility, intelligence, hardiness, movement, 1, 1, 1, 1, 1) );
    }    

    public String toString(){
    	return "Sneak";
    }
}
