package models.entities;

public abstract class Occupation {
    /* ATTRIBUTES */
    /* ========================= */
    private StatModifiers statMods;
    /* ========================= */

    /* METHODS */
    /* ========================= */    

    /* Accessors */
    public StatModifiers getStatMods() {
	return statMods;
    }
    public abstract String toString();
    
    /* ========================= */
}
