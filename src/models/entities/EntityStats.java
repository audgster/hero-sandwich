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
    private StatModifiers occupationStatMods;
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
	occupationStatMods = new StatModifiers();
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
	occupationStatMods = new StatModifiers();
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
	
	// Occupation multipliers
	modStr *= occupationStatMods.getStrength();
		
	// All other modifiers
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modStr += statMods.get(i).getStrength();
	}	
	return modStr;
    }
    
    public int getModAgility() {
	
	int modAgl = getAgility();
	
	// Occupation multipliers
	modAgl *= occupationStatMods.getAgility();
	
	// All other modifiers
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modAgl += statMods.get(i).getAgility();
	}
	return modAgl;	
    }
    
    public int getModIntellect() {
	
	int modIntel = getIntellect();
	
	// Occupation multipliers	
	modIntel *= occupationStatMods.getIntellect();
	
	// All other modifiers	
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modIntel += statMods.get(i).getIntellect();
	}
	return modIntel;
    }
    
    public int getModHardiness() {
	
	int modHar = getHardiness();
	
	// Occupation multipliers
	modHar *= occupationStatMods.getHardiness();
	
	// All other modifiers	
	for ( int i = 0; i != statMods.size(); ++i ) {
	    modHar += statMods.get(i).getHardiness();
	}
	return modHar;
    }
    
    public int getModMovement() {
	
	int modMov = getMovement();
	
	// Occupation multipliers	
	modMov *= occupationStatMods.getMovement();
	
	// All other modifiers	
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
	int experiencePerLevel = 100;
	return xp / experiencePerLevel;
    }
    @Override
    public int getLife() {
	int modLife = 0;
	for (int i = 0; i != statMods.size(); ++i) { modLife += statMods.get(i).getLife(); }
	return getLevel() * getModHardiness() + modLife;
    }
    @Override
    public int getMana() {
	int modMana = 0;
	for (int i = 0; i != statMods.size(); ++i) { modMana += statMods.get(i).getMana(); }	
	return getLevel() * getModIntellect() + modMana;
    }
    @Override
    public int getOffRating() {
	int modOffRating = 0;
	for (int i = 0; i != statMods.size(); ++i) { modOffRating += statMods.get(i).getOffRating(); }	
	return getLevel() * getModStrength() + modOffRating;
    }
    @Override
    public int getDefRating() {
	int modDefRating = 0;
	for (int i = 0; i != statMods.size(); ++i) { modDefRating += statMods.get(i).getDefRating(); }	
	return getLevel() * getModAgility() + modDefRating;
    }
    @Override
    public int getArmorRating() {
	int modArmorRating = 0;
	for (int i = 0; i != statMods.size(); ++i) { modArmorRating += statMods.get(i).getArmorRating(); }	
	return getModHardiness() + modArmorRating;
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
    public void setOccupationMods(StatModifiers statMod) {
	occupationStatMods = statMod;
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
