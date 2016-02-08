package models.entities;


import java.util.ArrayList;
import java.util.List;

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
    // private int duration; -- on wishlist -> used for temp buffs
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

    /* Array parameterized constructor
     * The indices of the array correspond to the order of the attributes in the fully parameterized
     * constructor (below).
     * If the full 10 stats are not provided, the remaining stats are initialized to 0 and a warning is printed
     */
    public StatModifiers(int[] stats) {
	try {
	    setStrength ( stats[0] );
	    setAgility  ( stats[1] );
	    setIntellect( stats[2] );
	    setHardiness( stats[3] );
	    setMovement ( stats[4] );
	    life = stats[5];
	    mana = stats[6];
	    offRating = stats[7];
	    defRating = stats[8];
	    armorRating = stats[9];
	} catch ( IndexOutOfBoundsException e ) {
	    System.err.println("Warning: Stats " + e.getMessage() + "-9 initialized to 0" );
	}
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
	strBuilder.append( super.toString() );
	strBuilder.append("\nLife: " + life);
	strBuilder.append("\nMana: " + mana);
	strBuilder.append("\nOffensive Rating: " + offRating);
	strBuilder.append("\nDefensive Rating: " + defRating);
	strBuilder.append("\nArmor Rating: " + armorRating);
	String str = strBuilder.toString();
	return str;
    }

	public List<String> getSaveState() {
		List<String> state = new ArrayList<String>();
		state.add("life: " + life + System.getProperty("line.separator") + " ");
		state.add("mana: " + mana + System.getProperty("line.separator") + " ");
		state.add("offensiveRating: " + offRating + System.getProperty("line.separator") + " ");
		state.add("defensiveRating: " + defRating + System.getProperty("line.separator") + " ");
		state.add("armorRating: " + armorRating + System.getProperty("line.separator") + " ");
		state.add("strength: " + getStrength() + System.getProperty("line.separator") + " ");
		state.add("agility: " + getAgility() + System.getProperty("line.separator") + " ");
		state.add("intellect: " + getIntellect() + System.getProperty("line.separator") + " ");
		state.add("hardiness: " + getHardiness() + System.getProperty("line.separator") + " ");
		state.add("movement: " + getMovement() + System.getProperty("line.separator") + " ");
		return state;
	}
}
