package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Npc;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.aoe.InstantDamageAoETrap;
import com.herosandwich.models.map.aoe.Trap;
import com.herosandwich.util.visitor.TileVisitor;

import java.util.List;

public class Sneak extends Occupation{
    private int creepSkill;
    private int detectionSkill;
    private int removeTrapSkill;
    private int pickPocketSkill;
    private int rangedWeaponSkill;

    public Sneak(){
        this.creepSkill = 0;
        this.detectionSkill = 0;
        this.removeTrapSkill = 0;
        this.pickPocketSkill = 0;
        this.rangedWeaponSkill = 0;
    }

    public Sneak(Character owner){
        super(owner);
        updateOccupationSkills();
    }


    //increase Character's Creep Skill. Character movement is also slowed.
    //For now creep mode will last for 5 seconds after being activated. After
    //those 5 seconds are complete the stats go back to normal
    public void creep(){
        if(successfulAction(this.creepSkill) ){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int creepIncrease = 10 + creepSkill;
                    owner.allocateSkillPoints(Skill.CREEP, creepIncrease);
                    owner.modifyMovement(-5);
                    try{
                        Thread.sleep(5000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    //reset value of creep skill and movement speed back to normal
                    owner.allocateSkillPoints(Skill.CREEP, -creepIncrease);
                    owner.modifyMovement(5);
                }
            });
            thread.start();
        }

    }

    //If successful discoveries a trap!
    public void detectTrap(){
        if(successfulAction(this.detectionSkill) ){

        }
    }


    //If successful deactivates a trap!
    public void removeTrap(Trap trap){
        if(successfulAction(this.removeTrapSkill) ){
            if(trap.isDiscovered()){

            }
            trap.deactivate();
        }
    }

    /*
     * A successful Pick Pocket will randomly select and remove item from an npc's inventory
      * and insert it to owner's inventory
     */
    public void pickPocket(Npc npc){
        if(successfulAction(this.pickPocketSkill) ){
            Inventory npcInventory = npc.getInventory();
            List npcInventoryList = npcInventory.getInventory();

            int randomSlot = (int) Math.ceil(Math.random() * (npcInventoryList.size() - 1));
            TakeableItem npcItem = npcInventory.removeItem((TakeableItem) npcInventoryList.get(randomSlot));
            owner.insertItemToInventory(npcItem);
        }
    }

    //this will get fixed with damageCalculator
    public int rangedWeaponAttack(SneakWeapon weapon){
        int damage = 0;
        if(successfulAction(this.rangedWeaponSkill) ){
            damage += owner.getOffensiveRating(); //damage from entity
            //damage += weapon.getWeaponsOffensiveRating(); // additional damage from weapon
        }
        return damage;
    }

    @Override
    public void updateOccupationSkills(){
        this.creepSkill = owner.getNumberOfSkillPoints(Skill.CREEP);
        this.detectionSkill = owner.getNumberOfSkillPoints(Skill.DETECTION);
        this.pickPocketSkill = owner.getNumberOfSkillPoints(Skill.PICK_POCKET);
        this.rangedWeaponSkill = owner.getNumberOfSkillPoints(Skill.RANGED_WEAPON);
        this.removeTrapSkill = owner.getNumberOfSkillPoints(Skill.REMOVE_TRAP);
    }


    @Override
    public String toString() {
        return "Sneak";
    }

    public String getDescription(){ return "A sandwich who loves to smash things";}
}
