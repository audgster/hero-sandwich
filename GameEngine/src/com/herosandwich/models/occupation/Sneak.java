package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Npc;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.models.map.aoe.Trap;
import java.util.List;

public class Sneak extends Occupation{
    private boolean creep_mode;

    public Sneak(){
        super();
        learned_skills.add(Skill.CREEP);
        learned_skills.add(Skill.DETECTION);
        learned_skills.add(Skill.REMOVE_TRAP);
        learned_skills.add(Skill.RANGED_WEAPON);
        creep_mode = false;
        //when a character is created all skill levels are zero
        updateOccupationSkills();
    }

    public Sneak(Character owner){
        super(owner);
        learned_skills.add(Skill.CREEP);
        learned_skills.add(Skill.DETECTION);
        learned_skills.add(Skill.REMOVE_TRAP);
        learned_skills.add(Skill.RANGED_WEAPON);
        creep_mode = false;
        //when a character is created all skill levels are zero
        updateOccupationSkills();
    }

    //increase Character's Creep Skill. Character movement is also slowed.
    //This will be used on a toggle mechanism, it will stay active
    //when creep_mode is true!
    public void creep(){
        int base = 10;
        int creepIncrease = base + occupationSkills.get(Skill.CREEP);
        if(creep_mode = true ){
            owner.allocateSkillPoints(Skill.CREEP, creepIncrease);
            owner.modifyMovement(-5);
            creep_mode = !creep_mode;
        }else{
            //reset value of creep skill and movement speed back to normal
            owner.allocateSkillPoints(Skill.CREEP, -creepIncrease);
            owner.modifyMovement(5);
            creep_mode = !creep_mode;
        }
    }

    //If successful discoveries a trap!
    public void detectTrap(){
        if(successfulAction(Skill.DETECTION) ){

       }
    }


    //If successful deactivates a trap!
    public void removeTrap(Trap trap){
        if(successfulAction(Skill.REMOVE_TRAP) ){
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
       // if(successfulAction(this.pickPocketSkill) ){
            Inventory npcInventory = npc.getInventory();
            List npcInventoryList = npcInventory.getInventory();

            int randomSlot = (int) Math.ceil(Math.random() * (npcInventoryList.size() - 1));
            TakeableItem npcItem = npcInventory.removeItem((TakeableItem) npcInventoryList.get(randomSlot));
            owner.insertItemToInventory(npcItem);
        //}
    }

    //this will get fixed with damageCalculator
    public int rangedWeaponAttack(SneakWeapon weapon){
        int damage = 0;
        //if(successfulAction(this.rangedWeaponSkill) ){
            damage += owner.getOffensiveRating(); //damage from entity
            //damage += weapon.getWeaponsOffensiveRating(); // additional damage from weapon
       // }
        return damage;
    }

    public boolean getCreepMode(){
        return creep_mode;
    }

    @Override
    public String toString() {
        return "Sneak";
    }

    public String getDescription(){ return "This sandwich is low fat and keeps a low profile.";}
}
