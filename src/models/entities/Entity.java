package models.entities;

import models.items.Item;
import util.Direction;
import util.TerrainGroup;

public class Entity {
    /* ATTRIBUTES */
    private String name;
    private Occupation occupation;
    private EntityStats stats;
    private Inventory inventory;
    private Equipment equipment;
    private TerrainGroup tGroup;
    
    /* METHODS */

    /* Default constructor */
    public Entity() {
	occupation = new Smasher();
	stats = new EntityStats();
	stats.addStatMod( occupation.getStatMods() );
	inventory = new Inventory();
	equipment = new Equipment();
	tGroup = TerrainGroup.GROUND;
    }    

    /* modifyStats(:StatModifier)
    ** Adds a StatModifiers object to the Entity's Stats
    */
    void modifyStats(StatModifiers statMod) {
	stats.addStatMod(statMod);
    }
    /* takeDamage(:int):int
    ** Parameters
    ** in: damage taken
    ** out: entities's remaining life after taking damage (currentLife)
    */
    int takeDamage(int amount) {
	stats.setCurrentLife( stats.getCurrentLife() - amount );
	int remainingLife = stats.getCurrentLife();	
	if (remainingLife <= 0) {
	    if ( loseLife() == 0 ) { // if no lives are remaining
		// Load from last save
	    }
	}
	return remainingLife;
    }
    /* healDamage(:int): int
    ** Parameters
    ** in: damage healed
    ** out: entities's remaining life after healing damage (currentLife)
    */
    int healDamage(int amount) {
	int currentLife = stats.getCurrentLife();
	int lifePlusHeal = currentLife + amount;
	if ( lifePlusHeal > stats.getLife() ) { // if healing pushes life over max
	    stats.setCurrentLife( stats.getLife() ); // set to max
	} else {
	    stats.setCurrentLife( currentLife + lifePlusHeal );
	}
	return stats.getCurrentLife();
    }
    /* loseLife: int
    ** Parameters
    ** out: number of lives entities has remaining after losing one (livesLeft)
    */
    int loseLife() {
	return stats.loseLife();
    }
    /* gainXp(:int): int
    ** Parameters
    ** in: the amount of XP gained
    ** out: the total amount of XP the entity has after the addition
    */
    int gainXp(int amount) {
	return stats.addXp(amount);
    }
    /* equip(:Item): boolean
    ** Parameters
    ** in: the Item to equip
    ** out: a boolean representing whether or not the equip action was successful
    */

    public void levelUp() {}

    //boolean equip(Item item) {}
    /* unequip(:Item): boolean
    ** Parameters
    ** in: the Item to unequip
    ** out: a boolean representing whether or not the unequip action was successful
    */
    //boolean unequip(Item item) {}
    /* dropItem(:Item): boolean 
    ** Parameters
    ** in: the Item to drop
    ** out: a boolean representing whether or not the drop item action was successful
    */
    //boolean dropItem(Item item) {}        
    /* toString(): String
    ** out: a string representing the Entities: 
    ** 1) Occupation
    ** 2) Stats
    ** 3) Inventory
    ** 4) Equipment
    */

    /* Accessors */
    public TerrainGroup getTerrainGroup() {
	return tGroup;
    }
    
    public String toString() {
	String str = name;
	return str;
    }

    public String getEntityType() { return "entityType"; }
}