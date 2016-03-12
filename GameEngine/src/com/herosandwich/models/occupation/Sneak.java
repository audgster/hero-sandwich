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

    public void creep(Character c){
        if(successfulAction(this.creepSkill) ){
            c.modifyAgilty(30);
        }
        //needs to reset value of modification when exits creep mode
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
    public String toString() {
        return "Sneak";
    }

    public String getDescription(){ return "A sandwich who loves to smash things";}
}
