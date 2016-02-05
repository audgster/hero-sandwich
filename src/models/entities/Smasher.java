package models.entities;

public class Smasher extends Occupation {

    /* METHODS */
    /* ========================= */
    
    /* Default constructor */
    public Smasher() {
	int str = 5;
	int agl = 2;
	int intel = 1;
	int har = 4;
	int mov = 0;
	StatModifiers smasherStats = new StatModifiers(str, agl, intel, har, mov, 0, 0, 0, 0, 0);
    }

    public String toString(){
    	return "Smasher";
    }

    /* ========================= */
}
