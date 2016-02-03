package models.entities;


/* DESCRIPTION 
 * --------------------------------------------------
 * StatModifiers are owned by EquipableItems, ConsumableItems, AreaEffects, 
 * and any other class whose role is (at least partially) to modify an Entity's
 * stats (EntityStats). The derived attributes present in EntityStats are
 * flat values in this class. They are to be used in the computation of 
 * an Entity's derived stats. Below is a list of said stats:
 * - life
 * - mana
 * - offRating
 * - defRating
 * - armorRating
 */
public class StatModifiers extends Stats {
    
    /* ATTRIBUTES */
    /* ========================= */    
    private int life;
    private int mana;
    private int offRating;
    private int defRating;
    private int armorRating;    
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
	// derived stats
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
    public void setLife(int life) {
	this.life = life;
    }
    public void setMana(int mana) {
	this.mana = mana;
    }
    public void setOffRating(int offRating) {
	this.offRating = offRating;
    }
    public void setDefRating(int defRating) {
	this.defRating = defRating;
    }
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
