package models.entities;

public class Smasher extends Occupation {
    
    
    /* Default constructor */
    public Smasher() {
	// These values will be multiplied by their Entities base stats
	int str = 1;
	int agl = 3;
	int intel = 7;
	int har = 1;
	int mov = 1;
	super.setStatMods( new StatModifiers(str, agl, intel, har, mov, 1, 1, 1, 1, 1) );
    }
    
    @Override
    public String toString(){
    	return "Smasher";
    }
}
