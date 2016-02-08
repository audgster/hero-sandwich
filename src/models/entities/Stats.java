package models.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Stats {
    /* ATTRIBUTES */
    private int strength;
    private int agility;
    private int intellect;
    private int hardiness;
    private int movement;

    /* METHODS */

    /* Default constructor */
    public Stats() {
	strength = 112;
	agility = 111;
	intellect = 199;
	hardiness = 1001;
	movement = 10;
    }

    /* Fully parameterized constructor */
    public Stats(int str, int agl, int intel, int har, int mov) {
	strength = str;
	agility = agl;
	intellect = intel;
	hardiness = har;
	movement = mov;
    }

    /* Compares the Stats of the caller with those of the
     * Stats parameter. Returns true iff:
     * caller stats  >= parameter stats
     */
    public boolean checkRestrictions(Stats stats) {

	boolean failedCheck = false;

	if ( strength < stats.getStrength() ) {
	    return failedCheck;
	}
	if ( agility < stats.getAgility() ) {
	    return failedCheck;
	}
	if ( intellect < stats.getIntellect() ) {
	    return failedCheck;
	}
	if ( hardiness < stats.getHardiness() ) {
	    return failedCheck;
	}
	if ( movement < stats.getMovement() ) {
	    return failedCheck;
	}
	return !failedCheck;
    }

    /* Accessors */
    public int getStrength() {
	return strength;
    }
    public int getAgility () {
	return agility;
    }
    public int getIntellect() {
	return intellect;
    }
    public int getHardiness() {
	return hardiness;
    }
    public int getMovement() {
	return movement;
    }

    public abstract int getLife();
    public abstract int getMana();
    public abstract int getOffRating();
    public abstract int getDefRating();
    public abstract int getArmorRating();

    /* Mutators */
    public void setStrength(int str) {
	strength = str;
    }
    public void setAgility(int agl) {
	agility = agl;
    }
    public void setIntellect(int intel) {
	intellect = intel;
    }
    public void setHardiness(int har) {
	hardiness = har;
    }
    public void setMovement(int mov) {
	movement = mov;
    }


    public String toString() {
	StringBuilder strBuilder = new StringBuilder();
	strBuilder.append("Stats");
	strBuilder.append("\nStrength: " + strength);
	strBuilder.append("\nAgility: " + agility);
	strBuilder.append("\nIntelligence: " + intellect);
	strBuilder.append("\nHardiness: " + hardiness);
	strBuilder.append("\nMovement: " + movement);
	String str = strBuilder.toString();
	return str;
    }
}
