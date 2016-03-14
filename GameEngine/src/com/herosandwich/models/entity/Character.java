package com.herosandwich.models.entity;

import com.herosandwich.menus.areaviewdrawables.Listener;
import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.models.occupation.Sneak;
import com.herosandwich.util.visitor.EntityVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Character extends Entity {

    /*
    * Occupation
    * */
    private Occupation occupation;

    /*
    * Equipment and Inventory
    * */
    private Inventory inventory;
    private Equipment equipment;

    /*
    * Skill points
    * */
    private HashMap<Skill, Integer> skillPoints;

    /*
    * Currency
    * */
    private int currency;



    public Character()
    {
        super();

        skillPoints = new HashMap<>();

        inventory = new Inventory();
        equipment = new Equipment();

        occupation = new Smasher(this);
    }

    public Character(Entity entity, Occupation occupation)
    {
        super(entity);
        occupation.setOwner(this);
        this.occupation = occupation;
        skillPoints = new HashMap<>();
        inventory = new Inventory();
        equipment = new Equipment();
    }

    public Character(Character character)
    {
        super(character);

        this.occupation = character.getOccupation();
        this.skillPoints = character.getSkillPoints();
        this.inventory = character.getInventory();
        this.equipment = character.getEquipment();
        this.currency = character.getCurrency();
    }

    /*
    * Currency
    * */
    public boolean setCurrency(int currency)
    {
        if (currency >= 0) {
            this.currency = currency;
            return true;
        }
        return false;
    }

    public int getCurrency()
    {
        return this.currency;
    }

    public boolean modifyCurrency(int delta)
    {
        int newCurrency = getCurrency() + delta;

        return setCurrency(newCurrency);
    }

    /*
    * Occupation
    * */

    public Occupation getOccupation()
    {
        return occupation;
    }

    /*
    * Inventory and Equipment methods
    * */

    public Inventory getInventory()
    {
        return inventory;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public EquipableItem getEquipedItem(EquipmentSlots location)
    {
        return equipment.getEquipableItem(location);
    }

    public boolean insertItemToInventory(TakeableItem item)
    {
       return inventory.insertItem(item);
    }

    public boolean equipItem(EquipableItem item){
        //the following checks for correct occupation requirement
        String itemClass = item.getOccupationWeaponRestriction().toString().toLowerCase();
        if(itemClass.equalsIgnoreCase(OccupationWeaponRestriction.EVERYONE.toString())){
            return addToEquipment(item);
        }else if(itemClass.equalsIgnoreCase(getOccupation().toString())){
            return addToEquipment(item);
        }else{
            return false;
        }
    }

    private boolean addToEquipment(EquipableItem item){
        boolean inserted = false;
        if(inventory.removeItem(item) != null) {
            addDerivedStat(item.getDerivedStats());
            inserted = getEquipment().insertItem(item);
        }
        return inserted;
    }

    public TakeableItem removeItemFromInventory(TakeableItem item)
    {
        return inventory.removeItem(item);
    }

    public Weapon getRightHand(){
        EquipableItem item = equipment.getEquipableItem(EquipmentSlots.RIGHT_HAND);
        if((item != null) && (item.getEquipmentType() == EquipmentType.WEAPON)){
            return (Weapon)item;
        }
        return null;
    }

    public Weapon getLeftHand(){
        EquipableItem item = equipment.getEquipableItem(EquipmentSlots.RIGHT_HAND);
        if((item != null) && (item.getEquipmentType() == EquipmentType.WEAPON)){
            return (Weapon)item;
        }
        return null;
    }

    public boolean removeItemFromEquipment(EquipmentSlots location)
    {
        EquipableItem item = equipment.removeItem(location);
        if(item != null){
            removeDerivedStat(item.getDerivedStats());
            return inventory.insertItem(item);
        }

        return true;
    }

    /*
    * Skill Methods
    * */

    public int getNumberOfSkillPoints(Skill skill)
    {
        if (skillPoints.containsKey(skill))
            return skillPoints.get(skill);

        return 0;
    }

    public boolean allocateSkillPoints(Skill skill, int numberOfPoints)
    {
        if (numberOfPoints < 1)
            return false;

        if (skillPoints.containsKey(skill)) {
            Integer points = skillPoints.get(skill) + numberOfPoints;
            skillPoints.replace(skill, points);
        }
        else
        {
            skillPoints.put(skill, numberOfPoints);
        }
        Occupation occupation = getOccupation();

        if(occupation.toString().equals("Sneak")){
            Sneak sneak = (Sneak)occupation;
            if(sneak.getCreepMode()){
                sneak.creep();
                occupation.updateOccupationSkills();
                sneak.creep();
            }
        }else{
            occupation.updateOccupationSkills();
        }

        return true;
    }

    public HashMap<Skill, Integer> getSkillPoints()
    {
        return this.skillPoints;
    }


    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visitCharacter(this);
    }
}
