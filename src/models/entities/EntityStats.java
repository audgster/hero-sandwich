package models.entities;

import org.omg.CORBA.DynAnyPackage.Invalid;
import util.exceptions.InvalidStatException;

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
        occupationStatMods = new Smasher().getStatMods();
        statMods = new ArrayList<>();
        setDefaults();
    }

    /* Fully parameterized constructor */
    public EntityStats(int str, int agl, int intel, int har, int mov,
                       int livesLeft, int xp, int curLife, int curMana, Occupation occupation) {
        super(str, agl, intel, har, mov);

        occupationStatMods = occupation.getStatMods();
        statMods = new ArrayList<>();

        try {
            setLivesLeft(livesLeft);
            setXp(xp);
            setCurrentLife(getLife());
            setCurrentMana(getMana());
        }
        catch (InvalidStatException ex)
        {
            ex.printStackTrace();
            setDefaults();
        }
    }

    private void setDefaults()
    {
        try {
            setLivesLeft(3);
            setXp(xp);
            setCurrentLife(getLife());
            setCurrentMana(getMana());
        }
        catch (InvalidStatException ex)
        {
            ex.printStackTrace();
        }
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
        for (int i = 0; i != statMods.size(); ++i) {
            modStr += statMods.get(i).getStrength();
        }
        return modStr;
    }

    public int getModAgility() {

        int modAgl = getAgility();

        // Occupation multipliers
        modAgl *= occupationStatMods.getAgility();

        // All other modifiers
        for (int i = 0; i != statMods.size(); ++i) {
            modAgl += statMods.get(i).getAgility();
        }
        return modAgl;
    }

    public int getModIntellect() {

        int modIntel = getIntellect();

        // Occupation multipliers
        modIntel *= occupationStatMods.getIntellect();

        // All other modifiers
        for (int i = 0; i != statMods.size(); ++i) {
            modIntel += statMods.get(i).getIntellect();
        }
        return modIntel;
    }

    public int getModHardiness()
    {
        int modHar = getHardiness();

        // Occupation multipliers
        int x = occupationStatMods.getHardiness();
        modHar *= occupationStatMods.getHardiness();

        // All other modifiers
        for (int i = 0; i != statMods.size(); ++i) {
            modHar += statMods.get(i).getHardiness();
        }
        return modHar;
    }

    public int getModMovement() {

        int modMov = getMovement();

        // Occupation multipliers
        modMov *= occupationStatMods.getMovement();

        // All other modifiers
        for (int i = 0; i != statMods.size(); ++i) {
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

    public List<StatModifiers> getStatMods() {
        return statMods;
    }
    
    /* ========================= */

    /* Derived Stats Accessors */
    /* ========================= */
    public int getLevel()
    {
        int experiencePerLevel = 100;
        return xp / experiencePerLevel + 1;
    }

    // Gets maximum life
    @Override
    public int getLife()
    {
        int modLife = 0;
        for (int i = 0; i != statMods.size(); ++i) {
            modLife += statMods.get(i).getLife();
        }

        return getLevel() * getModHardiness() + modLife;
    }

    // Gets maximum
    @Override
    public int getMana() {
        int modMana = 0;
        for (int i = 0; i != statMods.size(); ++i) {
            modMana += statMods.get(i).getMana();
        }
        return getLevel() * getModIntellect() + modMana;
    }

    @Override
    public int getOffRating() {
        int modOffRating = 0;
        for (int i = 0; i != statMods.size(); ++i) {
            modOffRating += statMods.get(i).getOffRating();
        }
        return getLevel() * getModStrength() + modOffRating;
    }

    @Override
    public int getDefRating() {
        int modDefRating = 0;
        for (int i = 0; i != statMods.size(); ++i) {
            modDefRating += statMods.get(i).getDefRating();
        }
        return getLevel() * getModAgility() + modDefRating;
    }

    @Override
    public int getArmorRating() {
        int modArmorRating = 0;
        for (int i = 0; i != statMods.size(); ++i) {
            modArmorRating += statMods.get(i).getArmorRating();
        }
        return getModHardiness() + modArmorRating;
    }
    /* ========================= */

    /* Mutators */
    /* Decrements the lives remaining, and returns the number of lives 
     *  remaining after the decrement      
     */
    public int loseLife()
    {
        if (livesLeft == 0)
            return 0;

        --livesLeft;
        // Restore life & mana
        try {
            setCurrentLife(getLife());
            setCurrentMana(getMana());
        }
        catch (InvalidStatException ex)
        {
            ex.printStackTrace();
        }
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) throws InvalidStatException
    {
        if (livesLeft < 0)
            throw new InvalidStatException("Lives left cannot be less than 0.");

        this.livesLeft = livesLeft;
    }

    public void setXp(int xp) throws InvalidStatException
    {
        if (xp < 0)
            throw new InvalidStatException("Experience cannot be negative.");
        this.xp = xp;
    }

    public void setCurrentLife(int currentLife) throws InvalidStatException
    {
        if (currentLife < 0)
            throw new InvalidStatException("Current life cannot be set to a value less than 0");

        int maxLife = getLife();

        if (currentLife > maxLife)
            this.currentLife = maxLife;
        else
            this.currentLife = currentLife;
        System.out.println("I AM HEREEE" + currentLife);
    }

    public void setCurrentMana(int currentMana) throws InvalidStatException
    {
        if (currentMana < 0)
            throw new InvalidStatException("Current mana cannot be set to a value less than 0.");

        int maxMana = getMana();

        if (currentMana > maxMana)
            this.currentMana = maxMana;
        else
            this.currentMana = currentMana;
    }

    public void addStatMod(StatModifiers statMod) {
        statMods.add(statMod);
    }

    public void setOccupationMods(StatModifiers statMod) {
        occupationStatMods = statMod;
    }

    /* Attemps to remove the StatModifiers with the same handle as the argument
     * If successful, returns the StatModifiers removed
     * Else, returns null
     */
    public StatModifiers removeStatMods(StatModifiers statMods) {
        StatModifiers removedStats = null;
        int index = this.statMods.indexOf(statMods);
        // if the StatModifiers is found
        if (index != -1) {
            removedStats = this.statMods.get(index);
            this.statMods.remove(index);
        }
        return removedStats;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(super.toString());
        strBuilder.append("\n[EntityStats:");
        strBuilder.append(" " + livesLeft + " ");
        strBuilder.append(" " + xp + " ");
        strBuilder.append(" " + currentLife + " ");
        strBuilder.append(" " + currentMana + " ");
        strBuilder.append("]\n");
        strBuilder.append("[ModifiedStats:");
        strBuilder.append(" " + getModStrength() + " ");
        strBuilder.append(" " + getModAgility() + " ");
        strBuilder.append(" " + getModIntellect() + " ");
        strBuilder.append(" " + getModHardiness() + " ");
        strBuilder.append(" " + getModMovement() + " ");
        strBuilder.append("]\n");
        strBuilder.append("[DerivedStats:");
        strBuilder.append(" " + getLevel() + " ");
        strBuilder.append(" " + getLife() + " ");
        strBuilder.append(" " + getMana() + " ");
        strBuilder.append(" " + getOffRating() + " ");
        strBuilder.append(" " + getDefRating() + " ");
        strBuilder.append(" " + getArmorRating() + " ");
        strBuilder.append("]");
        String str = strBuilder.toString();
        return str;
    }

	public List<String> getSaveState() {
		List<String> state = new ArrayList<String>();
		state.add("livesLeft: " + Integer.toString(livesLeft) + System.getProperty("line.separator") + " ");
		state.add("currentLife: " + currentLife + System.getProperty("line.separator") + " ");
		state.add("currentMana: " + Integer.toString(currentMana) + System.getProperty("line.separator") + " ");
		state.add("xp: " + Integer.toString(xp) + System.getProperty("line.separator") + " ");
        state.add("strength: " + getStrength() + System.getProperty("line.separator") + " ");
        state.add("agility: " + getAgility() + System.getProperty("line.separator") + " ");
        state.add("intellect: " + getIntellect() + System.getProperty("line.separator") + " ");
        state.add("hardiness: " + getHardiness() + System.getProperty("line.separator") + " ");
        state.add("movement: " + getMovement() + System.getProperty("line.separator") + " ");
		return state;
	}
}
