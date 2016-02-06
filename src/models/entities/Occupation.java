package models.entities;

public abstract class Occupation {
    
    /* ATTRIBUTES */
    private StatModifiers statMods;

    /* METHODS */

    /* Accessors */
    public StatModifiers getStatMods() {
	return statMods;
    }

    /* Mutators */
    public void setStatMods(StatModifiers statMods) {
	this.statMods = statMods;
    }
    
    public abstract String toString();
        
}
