package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.items.takeableItems.equipableItems.sneakWeapons.SneakWeapon;

import java.util.List;

public class Sneak extends Property{
    private int creepSkill;
    private int detectionSkill;
    private int pickPocketSkill;
    private int rangedWeaponSkill;

    public Sneak(){
        this.creepSkill = 0;
        this.detectionSkill = 0;
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

    //will complete when Tile exists!!
    public void detectAndRemoveTrap(){
        if(successfulAction(this.detectionSkill) ){

        }
    }

    /* very poor way of doing this. But first attempt!
     * Clay had a very cool idea that when entity interacts
     * player can pick the item that they want get from the npc!! :)
     */
    public void pickPocket(Character npc){
        if(successfulAction(this.pickPocketSkill) ){
            //List<TakeableItem> nPCItems =  npc.getInventory();
            //TakeableItem item = npc.removeItemFromInventory(nPCItems.get(0));
            //entity.insertItemToInventory(item);
        }
    }

    public int rangedWeaponAttack(SneakWeapon weapon){
        int damage = 0;
        if(successfulAction(this.rangedWeaponSkill) ){
            damage += owner.getOffensiveRating(); //damage from entity
            damage += weapon.getWeaponsOffensiveRating(); // additional damage from weapon
        }
        return damage;
    }

    @Override
    public void updateOccupationSkills(){
        this.creepSkill = owner.getNumberOfSkillPoints(Skill.CREEP);
        this.detectionSkill = owner.getNumberOfSkillPoints(Skill.DETECTION);
        this.pickPocketSkill = owner.getNumberOfSkillPoints(Skill.PICK_POCKET);
        this.rangedWeaponSkill = owner.getNumberOfSkillPoints(Skill.RANGED_WEAPON);
    }

    @Override
    public String toString()
    {
        return "sneak";
    }
}
