package models.entities;

import models.items.Item;
import util.Direction;

public class Entity {
    /* ATTRIBUTES */
    private String name;
    private Occupation occupation;
    private Stats stats;
    private Inventory inventory;
    private Equipment equipment;
    
    /* METHODS */

    /* move(:Direction)
    ** Description pending...
    */
    void move(Direction direction) {}
    /* modifyStats(:StatModifier)
    ** Description pending...
    */
    void modifyStats(StatModifier statMod) {}
    /* takeDamage(:int):int
    ** Parameters
    ** in: damage taken
    ** out: entities's remaining life after taking damage (currentLife)
    */
    int takeDamage(int amount) {}
    /* healDamage(:int): int
    ** Parameters
    ** in: damage healed
    ** out: entities's remaining life after healing damage (currentLife)
    */
    int healDamage(int amount) {}
    /* loseLife: int
    ** Parameters
    ** out: number of lives entities has remaining after losing one (livesLeft)
    */
    int loseLife() {}
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
    boolean equip(Item item) {}
    /* unequip(:Item): boolean
    ** Parameters
    ** in: the Item to unequip
    ** out: a boolean representing whether or not the unequip action was successful
    */
    boolean unequip(Item item) {}
    /* dropItem(:Item): boolean 
    ** Parameters
    ** in: the Item to drop
    ** out: a boolean representing whether or not the drop item action was successful
    */
    boolean dropItem(Item item) {}        
    /* toString(): String
    ** out: a string representing the Entities: 
    ** 1) Occupation
    ** 2) Stats
    ** 3) Inventory
    ** 4) Equipment
    */
    String toString() {}
}
