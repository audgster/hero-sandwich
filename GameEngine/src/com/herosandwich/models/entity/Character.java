package com.herosandwich.models.entity;

import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;
import com.herosandwich.models.occupation.Property;
import com.herosandwich.models.occupation.Smasher;
import com.herosandwich.util.visitor.EntityVisitor;

import java.util.HashMap;

public class Character extends Entity {

    /*
    * Occupation
    * */
    private Property occupation;

    /*
    * Equipment and Inventory
    * */
    private Inventory inventory;
    private Equipment equipment;

    /*
    * Skill points
    * */
    private HashMap<Skill, Integer> skillPoints;

    public Character()
    {
        super();

        skillPoints = new HashMap<>();

        inventory = new Inventory();
        equipment = new Equipment();

        occupation = new Smasher(this);
    }

    public Character(Entity entity, Property occupation)
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
    }

    /*
    * Occupation
    * */

    public Property getOccupation()
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
        //check for correct occupation
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
        if(inventory.removeItem(item) != null) {
            TakeableItem itemReplaced = equipment.insertItem(item);
            //addDerivedStat()

            if (itemReplaced != null)
                return inventory.insertItem(itemReplaced);

            return true;
        }
        return false;
    }

    public TakeableItem removeItemFromInventory(TakeableItem item)
    {
        return inventory.removeItem(item);
    }

    public boolean removeItemFromEquipment(EquipmentSlots location)
    {
        TakeableItem item = equipment.removeItem(location);
        if(item != null){
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

        getOccupation().updateOccupationSkills();

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
