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
    private List statMods;
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
    
    /* Primary Stats Accessors */
    /* ========================= */
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
	return 0;
    }
    @Override
    public int getLife() {
	return 0;
    }
    @Override
    public int getMana() {
	return 0;
    }
    @Override
    public int getOffRating() {
	return 0;
    }
    @Override
    public int getDefRating() {
	return 0;
    }
    @Override
    public int getArmorRating() {
	return 0;
    }
    /* ========================= */

    /* Mutators */
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
