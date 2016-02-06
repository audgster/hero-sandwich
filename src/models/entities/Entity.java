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
        occupation = new Smasher();
        stats = new EntityStats();
        stats.addStatMod( occupation.getStatMods() );
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

    public boolean addItem(Item item){
        return inventory.add(item);
    }
    public void removeItem(Item item){
        inventory.remove(item);
    }
    public boolean equip(EquipableItem item){
        boolean canEquip = false;
            if(item.getOccupationRestriction() == "" || item.getOccupationRestriction() == occupation.toString()){
                if(stats.compare(item.getStatsRestrictions())){
                    if(equipment.addItem(item)){
                        inventory.remove(item);
                        canEquip = true;
                    }
                }
            }
            return canEquip;
    }
    //boolean equip(Item item) {}
    /* unequip(:Item): boolean
    ** Parameters
    ** in: the Item to unequip
    ** out: a boolean representing whether or not the unequip action was successful
    */

    public boolean unequip(EquipableItem item){
        if(inventory.isFull()){
            return false;
        }
        else{
            inventory.add(item);
            equipment.remove(item);
            return true;
        }
    }
    //boolean unequip(Item item) {}
    /* dropItem(:Item): boolean
    ** Parameters
    ** in: the Item to drop
    ** out: a boolean representing whether or not the drop item action was successful
    */
    public void dropItem(Item item){
        inventory.remove(item);
    }
    //boolean dropItem(Item item) {}
    /* toString(): String
    ** out: a string representing the Entities:
    ** 1) Occupation
    ** 2) Stats
    ** 3) Inventory
    ** 4) Equipment
    */

    /* Accessors */
    public EntityIdentifier getEntityType() {
	return eIdentifier;
    }

    public Inventory getInventory() {
	return inventory;
    }
    
    public Direction getEntityDirection() {return directionFacing;}

    public void setEntityDirection(Direction direction)
    {
        directionFacing = direction;
    }

    public String toString() {
	String str = name;
	return str;
    }

    @Override
    public String getImageId() {
        return "Entity_" + occupation.getClass().getSimpleName() + "_" + eIdentifier.toString().toLowerCase();
    }
}
