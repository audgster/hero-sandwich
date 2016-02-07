package models.entities;

import models.items.*;
import util.Direction;
import util.EntityIdentifier;
import util.exceptions.InvalidStatException;
import views.Drawable;
import models.Subject;
import views.Listener;
import java.util.List;
import java.util.ArrayList;

public class Entity implements Drawable, Subject
{
    /* ATTRIBUTES */
    private String name;
    private Occupation occupation;
    private EntityStats stats;
    private Inventory inventory;
    private Equipment equipment;
    private EntityIdentifier eIdentifier;
    private Direction directionFacing;
  private List<Listener> subs; // Only the Avatar uses this

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
      subs = new ArrayList<Listener>();
    }

  /* Fully parameterized constructor */
    public Entity(String name, Occupation occupation, EntityStats entityStats, EntityIdentifier identifier, Direction direction)
    {
        this.name = name;
        this.occupation = occupation;
        stats = entityStats;
        stats.setOccupationMods( this.occupation.getStatMods() );
        inventory = new Inventory();
        equipment = new Equipment();
        eIdentifier = identifier;
        directionFacing = direction;
	   subs = new ArrayList<Listener>();
    }

  /* IMPLEMENT SUBJECT INTERFACE */

    public void addListener(Listener listener)
    {
        subs.add(listener);
    }
	
    public void removeListener(Listener listener)
    {
        boolean found = subs.remove(listener);

        if (!found)
            System.err.println("Entity " + name + " could not remove Listener [NOT FOUND]");
    }
  
    public void notifyListeners()
    {
        for(int i = 0; i < subs.size(); i++){
            subs.get(i).update();
        }
    }

  /* END SUBJECT INTERFACE */

    /* modifyStats(:StatModifier)
    ** Adds a StatModifiers object to the Entity's Stats
    */
    void modifyStats(StatModifiers statMod)
    {
        stats.addStatMod(statMod);
        notifyListeners();
    }
    
    /* takeDamage(:int):int
    ** Parameters
    ** in: damage taken
    ** out: entities's remaining life after taking damage (currentLife)
    */
    public int takeDamage(int amount)
    {
        int remainingLife = 0;

        try {
            int delta = stats.getCurrentLife() - amount;

            if (delta < 0) {
                loseLife();
            }
            else {
                stats.setCurrentLife(delta);
                remainingLife = delta;
            }

            notifyListeners();
        }
        catch (InvalidStatException ex)
        {
            ex.printStackTrace();
        }

        return remainingLife;
    }
    
    /* healDamage(:int): int
    ** Parameters
    ** in: damage healed
    ** out: entities's remaining life after healing damage (currentLife)
    */
    public int healDamage(int amount)
    {
        int currentLife = stats.getCurrentLife();
        int lifeToHeal = currentLife + amount;
        int maxLife = stats.getLife();

        if ( lifeToHeal >  maxLife) { // if healing pushes life over max
           lifeToHeal = maxLife;
        }

        try {
            stats.setCurrentLife(lifeToHeal);
        }
        catch (InvalidStatException ex)
        {
            ex.printStackTrace();
        }
        notifyListeners();
        return currentLife;
    }
    
    /* loseLife: int
    ** Parameters
    ** out: number of lives entities has remaining after losing one (livesLeft)
    */
    int loseLife()
    {
        int livesRemaining = stats.loseLife();
        notifyListeners();
        return livesRemaining;
    }
    
    /* gainXp(:int): int
    ** Parameters
    ** in: the amount of XP gained
    ** out: the total amount of XP the entity has after the addition
    */
    int gainXp(int amount)
    {
        int oldLevel = stats.getLevel();
        int newXp = stats.addXp(amount);
        int newLevel = stats.getLevel();

        if (newLevel > oldLevel)
        {
            levelUp();
        }

        notifyListeners();

        return newXp;
    }

    /* levelUp()
     * Instantly restores the Entity's life and mana to full
     * Increases all of the Entity's base stats by a fixed amount
     * Unlocks new Occupation skills
     */
    public void levelUp() {

	// Restore life & mana
        try {
            stats.setCurrentLife(stats.getLife());
            stats.setCurrentMana(stats.getMana());
        }
        catch (InvalidStatException ex)
        {
            ex.printStackTrace();
        }

        // Increase primary stats
        stats.setStrength( stats.getStrength() + 1 );
        stats.setAgility( stats.getAgility() + 1 );
        stats.setIntellect( stats.getIntellect() + 1 );
        stats.setHardiness( stats.getHardiness() + 1 );
        stats.setMovement( stats.getMovement() + 1 );

        // Unlock new skills

        notifyListeners();
    }

    /* addItem(:Item): boolean
    ** Parameters
    ** in: the Item to add to this Entity's Inventory
    ** out: a boolean representing whether or not the item was added (it cannot be if Inventory is full)
    */
    public boolean addItem(Item item)
    {
        boolean itemAdded = inventory.add(item);
        if (itemAdded)
        {
 	        notifyListeners();
        }

        return itemAdded;
    }

    /* equip(:Item): boolean
    ** Parameters
    ** in: the Item to equip
    ** out: a boolean representing whether or not the equip action was successful
    */    
    public boolean equip(EquipableItem item)
    {
        if ( item.getOccupationRestriction() == "" || item.getOccupationRestriction() == occupation.toString() )
        {
	        if ( stats.checkRestrictions( item.getStatsRestrictions() ) )
            {
		        if ( equipment.equip(item) )
                {
                    inventory.remove(item);
                    modifyStats( item.getStatModifiers() );
                    notifyListeners();
                    return true;
                }
            }
        }
        return false;
    }

    /* unequip(:Item): boolean
    ** Parameters
    ** in: the Item to unequip
    ** out: a boolean representing whether or not the unequip action was successful
    */
    public boolean unequip(EquipableItem item)
    {
        if ( inventory.isFull() )
        {
	        return false;
        }

        equipment.unequip(item);
        inventory.add(item);
        stats.removeStatMods( item.getStatModifiers() );

        notifyListeners();

        return true;
    }


    /* Accessors */
    public EntityIdentifier getEntityType()
    {
	    return eIdentifier;
    }

    public Occupation getOccupation()
    {
	    return occupation;
    }

    public EntityStats getEntityStats()
    {
	    return stats;
    }
    
    public Inventory getInventory()
    {
	    return inventory;
    }
    
    public Direction getEntityDirection()
    {
        return directionFacing;
    }

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
    public String toString()
    {
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
        return "Entity_" + occupation.getClass().getSimpleName() + "_" + getEntityDirection().toString();
    }
}
