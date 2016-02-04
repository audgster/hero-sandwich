package models.entities;

import java.util.List;
import java.util.ArrayList;

public class EntityStats extends Stats {
    
    /* ATTRIBUTES */
    /* ========================= */
    private int livesLeft;
    private int xp;
    private int currentLife;
    private int currentMana;
    private List<StatModifiers> statMods;
    /* ========================= */
    
    /* METHODS */
    
    /* Default constructor */
    public EntityStats() {
	super();
	livesLeft = 3;
	xp = 0;
	currentLife = 10;
	currentMana = 5;
	statMods = new ArrayList();	
    }
    
    /* Fully parameterized constructor */
    public EntityStats(int str, int agl, int intel, int har, int mov,
		       int livesLeft, int xp, int curLife, int curMana) {
	super(str, agl, intel, har, mov);
	this.livesLeft = livesLeft;
	this.xp = xp;
	this.currentLife = curLife;
	this.currentMana = curMana;
	statMods = new ArrayList();	
    }

    public int addXp(int amount) {
	xp += amount;
	return xp;
    }
    
    /* Primary Stats Accessors */
    /* ========================= */
    public int getModStrength() {
	int modStr = getStrength();
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modStr += statMods.get(i).getStrength();
	}
	return modStr;
    }
    public int getModAgility() {
	int modAgl = getAgility();
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modAgl += statMods.get(i).getAgility();
	}
	return modAgl;	
    }
    public int getModIntellect() {
	int modIntel = getIntellect();
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modIntel += statMods.get(i).getIntellect();
	}
	return modIntel;
    }
    public int getModHardiness() {
	int modHar = getHardiness();
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modHar += statMods.get(i).getHardiness();
	}
	return modHar;
    }
    public int getModMovement() {
	int modMov = getMovement();
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modMov += statMods.get(i).getMovement();
	}
	return modMov;
    }
    public int getLivesLeft() {
	return livesLeft;
    }
    public int getXp() {
	return xp;
    }
    public int getCurrentLife() {
	return currentLife;
    }
    public int getCurrentMana() {
	return currentMana;
    }

    public List getStatMods() {
	return statMods;
    }
    /* ========================= */
    
    /* Derived Stats Accessors */
    /* ========================= */
    public int getLevel() {
	return xp / 100;
    }
    @Override
    public int getLife() {
	return getLevel() * getModHardiness();
    }
    @Override
    public int getMana() {
	return getLevel() * getModIntellect();
    }
    @Override
    public int getOffRating() {
	return getLevel() * getModStrength();
    }
    @Override
    public int getDefRating() {
	return getLevel() * getModAgility();
    }
    @Override
    public int getArmorRating() {
	return getModHardiness(); // * equipment
    }
    /* ========================= */

    /* Mutators */
    /* Decrements the lives remaining, and returns the number of lives 
     *  remaining after the decrement      
     */
    public int loseLife() {
	--livesLeft;
	return livesLeft;
    }
    public void setLivesLeft(int livesLeft) {
	this.livesLeft = livesLeft;	
    }
    public void setXp(int xp) {
	this.xp = xp;	
    }
    public void setCurrentLife(int currentLife) {
	this.currentLife = currentLife;
    }
    public void setCurrentMana(int currentMana) {
	this.currentMana = currentMana;	
    }
    public void addStatMod(StatModifiers statMod) {
	statMods.add(statMod);
    }
    
    @Override
    public String toString() {
	StringBuilder strBuilder = new StringBuilder();
	strBuilder.append("[EntityStats:");
	strBuilder.append(" " + livesLeft + " ");
	strBuilder.append(" " + xp + " ");
	strBuilder.append(" " + currentLife + " ");
	strBuilder.append(" " + currentMana + " ");
	strBuilder.append("]");
	String str = strBuilder.toString() + super.toString();
	return str;
    }
}
