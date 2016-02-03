package models.entities;

public class EntityStats extends Stats {
    
    /* ATTRIBUTES */
    /* ========================= */
    private int livesLeft;
    private int xp;
    private int currentLife;
    private int currentMana;
    /* ========================= */
    
    /* METHODS */
    
    /* Default constructor */
    public EntityStats() {
	super();
	livesLeft = 3;
	xp = 0;
	currentLife = 10;
	currentMana = 5;
    }
    
    /* Fully parameterized constructor */
    public EntityStats(int str, int agl, int intel, int har, int mov,
		       int livesLeft, int xp, int curLife, int curMana) {
	super(str, agl, intel, har, mov);
	this.livesLeft = livesLeft;
	this.xp = xp;
	this.currentLife = curLife;
	this.currentMana = curMana;
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
    };
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

    @Override    
    public void setLife(int life) {
	this.life = life;
    }
    @Override    
    public void setMana(int mana) {
	this.mana = mana;
    }
    @Override    
    public void setOffRating(int offRating) {
	this.offRating = offRating;
    }
    @Override    
    public void setDefRating(int defRating) {
	this.defRating = defRating;
    }
    @Override    
    public void setArmorRating(int armorRating) {
	this.armorRating = armorRating;
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
