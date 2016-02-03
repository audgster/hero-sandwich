package models.entities;

public class StatModifiers extends Stats {
    
    /* ATTRIBUTES */
    /* ========================= */

    /* ========================= */
    
    /* METHODS */

    /* Default constructors */
    public StatModifiers() {
	super();
	life = 0;
	mana = 0;
	offRating = 0;
	defRating = 0;
	armorRating = 0;	
    }

    /* Fully parameterized constructor */
    public StatModifiers(int str, int agl, int intel, int har, int mov,
			 int life, int mana,
			 int offRating, int defRating, int armorRating) {
	super(str, agl, intel, har, mov);
	this.life = life;
	this.mana = mana;
	this.offRating = offRating;
	this.defRating = defRating;
	this.armorRating = armorRating;
    }
    
    
    /* Accessors */
    /* ========================= */
    @Override
    public int getLife() {
	return life;
    }
    @Override    
    public int getMana() {
	return mana;
    }
    @Override    
    public int getOffRating() {
	return offRating;
    }
    @Override    
    public int getDefRating() {
	return defRating;
    }
    @Override    
    public int getArmorRating() {
	return armorRating;
    }
    /* ========================= */

    /* Mutators */
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
	strBuilder.append("[StatModifiers:");
	strBuilder.append(" " + offRating + " ");
	strBuilder.append(" " + defRating + " ");
	strBuilder.append(" " + armorRating + " ");
	strBuilder.append("]");
	String str = strBuilder.toString() + super.toString();
	return str;
    }
}
