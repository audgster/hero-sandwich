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
    /* move(:Direction)
    ** Description pending...
    */
    void move(Direction direction) {}
    /* modifyStats(:StatModifier)
    ** Description pending...
    */
    void modifyStats(StatModifiers statMod) {}
    /* takeDamage(:int):int
    ** Parameters
    ** in: damage taken
    ** out: entities's remaining life after taking damage (currentLife)
    */
    public int takeDamage(int amount) {return 0;}
    /* healDamage(:int): int
    ** Parameters
    ** in: damage healed
    ** out: entities's remaining life after healing damage (currentLife)
    */
    public int healDamage(int amount) {return 0;}

    /* loseLife: int
    ** Parameters
    ** out: number of lives entities has remaining after losing one (livesLeft)
    */
    public int loseLife() {return 0;}

    /* gainXp(:int)
    ** Parameters
    ** in: the amount of XP gained
    */
    void gainXp(int amount) {}
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
