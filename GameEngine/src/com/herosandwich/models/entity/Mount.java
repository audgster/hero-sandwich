package com.herosandwich.models.entity;

import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.occupation.Occupation;
import com.herosandwich.util.visitor.EntityVisitor;

public class Mount extends Character
{
    private Character rider;
    private int movement;

    /*
    * Constructors
    * */

    public Mount()
    {
        super();
        this.rider = null;
        this.movement = 1;
    }

    public Mount(String name, int movement)
    {
        setName(name);
        this.rider = null;
        this.movement = movement;
    }

    public Mount(String name, Character rider, int movement)
    {
        setName(name);
        this.rider = rider;
        this.movement = movement;
    }

    public Mount(Mount mount)
    {
        setName(mount.getName());
        this.rider = mount.getRider();
        this.movement = mount.getMovement();
    }

    /*
    * Accessors
    * */

    public Character getRider()
    {
        return this.rider;
    }

    @Override
    public int getMovement()
    {
        return this.movement;
    }

    @Override
    public int getLives()
    {
        return rider.getLives();
    }

    @Override
    public int getStrength()
    {
        return rider.getStrength();
    }

    @Override
    public int getAgility()
    {
        return rider.getAgility();
    }

    @Override
    public int getIntellect()
    {
        return rider.getIntellect();
    }

    @Override
    public int getHardiness()
    {
        return rider.getHardiness();
    }

    @Override
    public int getExperience()
    {
        return rider.getExperience();
    }

    @Override
    public int getLevel()
    {
        return rider.getLevel();
    }

    @Override
    public int getMaxLife()
    {
        if (rider != null) {
            return rider.getMaxLife();
        }

        return 0;
    }

    @Override
    public int getMaxMana()
    {
        if (rider != null) {
            return rider.getMaxMana();
        }

        return 0;
    }

    @Override
    public int getOffensiveRating()
    {
        return rider.getOffensiveRating();
    }

    @Override
    public int getDefensiveRating()
    {
        return rider.getDefensiveRating();
    }

    @Override
    public int getArmorRating()
    {
        return rider.getArmorRating();
    }

    @Override
    public Occupation getOccupation()
    {
        return rider.getOccupation();
    }

    @Override
    public Inventory getInventory()
    {
        return rider.getInventory();
    }

    @Override
    public Equipment getEquipment()
    {
        return rider.getEquipment();
    }

    @Override
    public EquipableItem getEquipedItem(EquipmentSlots location)
    {
        return rider.getEquipedItem(location);
    }

    @Override
    public boolean insertItemToInventory(TakeableItem item)
    {
        return rider.insertItemToInventory(item);
    }

    @Override
    public boolean equipItem(EquipableItem item){
        return rider.equipItem(item);
    }

    @Override
    public TakeableItem removeItemFromInventory(TakeableItem item)
    {
        return rider.removeItemFromInventory(item);
    }

    @Override
    public boolean removeItemFromEquipment(EquipmentSlots location)
    {
        return rider.removeItemFromEquipment(location);
    }

    @Override
    public int getNumberOfSkillPoints(Skill skill)
    {
        if (rider != null) {
            return rider.getNumberOfSkillPoints(skill);
        }
        return 0;
    }

    /*
    * Modifiers
    * */

    @Override
    public boolean modifyLives(int delta)
    {
        return rider.modifyLives(delta);
    }

    @Override
    public boolean modifyStrength(int delta)
    {
        return rider.modifyStrength(delta);
    }

    @Override
    public boolean modifyAgilty(int delta)
    {
        return rider.modifyAgilty(delta);
    }

    @Override
    public boolean modifyIntellect(int delta)
    {
        return rider.modifyIntellect(delta);
    }

    @Override
    public boolean modifyExperience(int delta)
    {
        return rider.modifyExperience(delta);
    }

    @Override
    public boolean modifyMovement(int delta)
    {
        int newMovement = this.movement + delta;

        if (newMovement > 0)
        {
            this.movement = newMovement;
            return true;
        }

        return false;
    }

    @Override
    public boolean modifyLevel(int level)
    {
        return rider.modifyMovement(level);
    }

    @Override
    public boolean modifyMaxLife(int life)
    {
        return rider.modifyMaxLife(life);
    }

    @Override
    public boolean modifyMaxMana(int mana)
    {
        return rider.modifyMaxMana(mana);
    }

    @Override
    public boolean modifyOffensiveRating(int rating)
    {
        return rider.modifyOffensiveRating(rating);
    }

    @Override
    public boolean modifyDefensiveRating(int rating)
    {
        return rider.modifyDefensiveRating(rating);
    }

    @Override
    public boolean modifyArmorRating(int rating)
    {
        return rider.modifyArmorRating(rating);
    }

    /*
    * Methods
    * */

    public Character ejectRider()
    {
        Character currRider = this.rider;
        this.rider = null;
        return currRider;
    }

    public Character mount(Character newRider)
    {
        this.rider = newRider;

        rider.updatePosition(this.getPosition());

        return this;
    }

    @Override
    public void accept(EntityVisitor visitor)
    {
        visitor.visitMount(this);
    }
}
