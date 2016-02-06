package models.entities;

import models.items.*;
import util.Direction;
import util.EntityIdentifier;
import util.TerrainGroup;
import views.Drawable;

public class Entity implements Drawable
{
    /* ATTRIBUTES */
    private String name;
    private Occupation occupation;
    private EntityStats stats;
    private Inventory inventory;
    private Equipment equipment;
    private EntityIdentifier eIdentifier;

    private Direction directionFacing;

    /* METHODS */

    /* Default constructor */
    public Entity() {
	name = "Roast Beef";
        occupation = new Smasher();
        stats = new EntityStats();
        stats.setOccupationMods( occupation.getStatMods() );
        inventory = new Inventory();
        equipment = new Equipment();
        eIdentifier = EntityIdentifier.GROUND;
        directionFacing = Direction.NORTH;
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
    public int takeDamage(int amount) {
	stats.setCurrentLife( stats.getCurrentLife() - amount );
	int remainingLife = stats.getCurrentLife();
	if (remainingLife <= 0) {
	    loseLife();
	}
	return remainingLife;
    }
    
    /* healDamage(:int): int
    ** Parameters
    ** in: damage healed
    ** out: entities's remaining life after healing damage (currentLife)
    */
    public int healDamage(int amount) {
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
	int livesRemaining = stats.loseLife();
	if ( livesRemaining == 0  ) {
	    // Game Over
	}
	return livesRemaining;
    }
    
    /* gainXp(:int): int
    ** Parameters
    ** in: the amount of XP gained
    ** out: the total amount of XP the entity has after the addition
    */
    int gainXp(int amount) {
	int oldLevel = stats.getLevel();
	int newXp = stats.addXp(amount);
	int newLevel = stats.getLevel();
	if (newLevel > oldLevel) {
	    levelUp();
	}
	return newXp;
    }

    /* levelUp()
     * Instantly restores the Entity's life and mana to full
     * Increases all of the Entity's base stats by a fixed amount
     * Unlocks new Occupation skills
     */
    public void levelUp() {

	// Restore life & mana
	stats.setCurrentLife( stats.getLife() );
	stats.setCurrentMana( stats.getMana() );

	// Increase primary stats
	stats.setStrength( stats.getStrength() + 1 );
	stats.setAgility( stats.getAgility() + 1 );	
	stats.setIntellect( stats.getIntellect() + 1 );
	stats.setHardiness( stats.getHardiness() + 1 );
	stats.setMovement( stats.getMovement() + 1 );

	// Unlock new skills
    }

    /* addItem(:Item): boolean
    ** Parameters
    ** in: the Item to add to this Entity's Inventory
    ** out: a boolean representing whether or not the item was added (it cannot be if Inventory is full)
    */
    public boolean addItem(Item item){
        return inventory.add(item);
    }

    /* equip(:Item): boolean
    ** Parameters
    ** in: the Item to equip
    ** out: a boolean representing whether or not the equip action was successful
    */    
    public boolean equip(EquipableItem item){	
	boolean successful = true;
	if ( item.getOccupationRestriction() == "" || item.getOccupationRestriction() == occupation.toString() ){
	    if ( stats.checkRestrictions( item.getStatsRestrictions() ) ){
		if ( equipment.equip(item) ){
		    inventory.remove(item);
		    modifyStats( item.getStatModifiers() );
		    return successful;
		}
	    }
	}
	return !successful;
    }

    /* unequip(:Item): boolean
    ** Parameters
    ** in: the Item to unequip
    ** out: a boolean representing whether or not the unequip action was successful
    */
    public boolean unequip(EquipableItem item){
	boolean successful = true;
        if ( inventory.isFull() ){
	    return !successful;
        }
	equipment.unequip(item);
	inventory.add(item);
	return successful;
    }


    /* Accessors */
    public EntityIdentifier getEntityType() {
	return eIdentifier;
    }

    public Occupation getOccupation() {
	return occupation;
    }

    public EntityStats getEntityStats() {
	return stats;
    }
    
    public Inventory getInventory() {
	return inventory;
    }
    
    public Direction getEntityDirection() {return directionFacing;}

    public void setEntityDirection(Direction direction)
    {
        directionFacing = direction;
    }

    /* toString(): String
    ** out: a string representing the Entities:
    ** 1) Name
    ** 2) Occupation
    ** 3) Stats
    ** 4) Inventory
    ** 5) Equipment
    */
    public String toString() {
	StringBuilder strBuilder = new StringBuilder();
	strBuilder.append("Name: " + name + "\n");
	strBuilder.append("Occupation: " + occupation.toString() + "\n");
	strBuilder.append(stats.toString() + "\n");
	strBuilder.append(inventory.toString() + "\n");
	strBuilder.append(equipment.toString() + "\n");
	String str = strBuilder.toString();
	return str;
    }

    @Override
    public String getImageId() {
        return "Entity_" + occupation.getClass().getSimpleName() + "_" + eIdentifier.toString().toLowerCase();
    }
}
