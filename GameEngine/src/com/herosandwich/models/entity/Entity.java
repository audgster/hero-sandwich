package com.herosandwich.models.entity;

import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.occupation.Property;
import com.herosandwich.models.occupation.Smasher;

import java.util.HashMap;
import java.util.List;

public abstract class Entity
{
    /*
    * Stats
    * */
    private EntityStats stats;
    private Property occupation;
    private Inventory inventory;
    private Equipment equipment;

    public Entity()
    {
        stats = new EntityStats();
        occupation = new Smasher();
        inventory = new Inventory();
        equipment = new Equipment();
    }

    public Entity(Property occupation)
    {
        this.occupation = occupation;
        stats = new EntityStats();
        inventory = new Inventory();
        equipment = new Equipment();
    }

    /*
    * Accessors
    * */

    //Primary Stats
    public int getLives()
    {
        return stats.getLives();
    }

    public int getStrength()
    {
        return stats.getStrength();
    }

    public int getAgility()
    {
        return stats.getAgility();
    }

    public int getIntellect()
    {
        return stats.getIntellect();
    }

    public int getHardiness()
    {
        return stats.getHardiness();
    }

    public int getExperience()
    {
        return stats.getExperience();
    }

    public int getMovement()
    {
        return stats.getMovement();
    }

    // Derived Stats
    public int getLevel()
    {
        return stats.getLevel();
    }

    public int getMaxLife()
    {
        return stats.getLife();
    }

    public int getMaxMana()
    {
        return stats.getMana();
    }

    public int getOffensiveRating()
    {
        return stats.getOffensiveRating();
    }

    public int getDefensiveRating()
    {
        return stats.getDefensiveRating();
    }

    public int getArmorRating()
    {
        return stats.getArmorRating();
    }

    public Property getOccupation(){ return occupation; }

    public List<TakeableItem> getInventory(){ return inventory.getInventory(); }

    public HashMap<EquipmentSlots, EquipableItem> getEquipment(){ return equipment.getEquipment(); }

    public EquipableItem getEquipedItem(EquipmentSlots location){
        return equipment.getEquipableItem(location);
    }

    public void insertItemToInventory(TakeableItem item){
        inventory.insertItem(item);
    }

    public void equipItem(EquipableItem item, EquipmentSlots location){
        inventory.removeItem(item);
        equipment.insertItem(item, location);
    }

    public TakeableItem removeItemFromInventory(TakeableItem item){
        return inventory.removeItem(item);
    }

    public void removeItemFromEquipment(EquipmentSlots location){
        TakeableItem item = equipment.removeItem(location);
        if(item != null){
            inventory.insertItem(item);
        }
    }

    /*
    * Modifiers
    * */

    //Primary stat modifiers
    public boolean modifyLives(int delta)
    {
        return stats.changeLives(delta);
    }

    public boolean modifyStrength(int delta)
    {
        return stats.changeStrength(delta);
    }

    public boolean modifyAgilty(int delta)
    {
        return stats.changeAgility(delta);
    }

    public boolean modifyIntellect(int delta)
    {
        return stats.changeIntellect(delta);
    }

    public boolean modifyExperience(int delta)
    {
        return stats.changeExperience(delta);
    }

    public boolean modifyMovement(int delta)
    {
        return stats.changeMovement(delta);
    }

    //Derived stat modifiers
    public boolean modifyLevel(int level)
    {
        return stats.addDerivedStat(new DerivedStats(level,0,0,0,0,0));
    }

    public boolean modifyMaxLife(int life)
    {
        return stats.addDerivedStat(new DerivedStats(0,life,0,0,0,0));
    }

    public boolean modifyMaxMana(int mana)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,mana,0,0,0));
    }

    public boolean modifyOffensiveRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,rating,0,0));
    }

    public boolean modifyDefensiveRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,0,rating,0));
    }

    public boolean modifyArmorRating(int rating)
    {
        return stats.addDerivedStat(new DerivedStats(0,0,0,0,0,rating));
    }

    /*
    * Methods
    * */
}
