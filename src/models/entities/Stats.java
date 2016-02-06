package models.entities;

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
	strength = 0;
	agility = 0;
	intellect = 0;
	hardiness = 0;
	movement = 0;
    }

    /* Fully parameterized constructor */
    public Stats(int str, int agl, int intel, int har, int mov) {
	strength = str;
	agility = agl;
	intellect = intel;
	hardiness = har;
	movement = mov;
    }

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
	strBuilder.append("[Stats:");
	strBuilder.append(" " + strength + " ");
	strBuilder.append(" " + agility + " ");
	strBuilder.append(" " + intellect + " ");
	strBuilder.append(" " + hardiness + " ");
	strBuilder.append(" " + movement + " ");
	strBuilder.append("]");
	String str = strBuilder.toString();
	return str;
    }

    public boolean compare(StatModifiers stats){
      return false;
    }
}
