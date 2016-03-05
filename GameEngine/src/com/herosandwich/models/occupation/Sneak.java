package com.herosandwich.models.occupation;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.sneakWeapons.SneakWeapon;

import java.util.List;

public class Sneak extends Property{
    private int creepSkill = 1;
    private int detectionSkill = 1;
    private int pickPocketSkill = 1;
    private int weaponSkill = 1;

    public void creep(Entity entity){
        if(successfulAction(this.creepSkill) ){
            entity.modifyAgilty(30);
        }
        //needs to reset value of modification when exits creep mode
    }

    //will complete when Tile exists!!
    public void detectAndRemoveTrap(Entity entity){
        if(successfulAction(this.detectionSkill) ){

        }
    }

    /* very poor way of doing this. But first attempt!
     * Clay had a very cool idea that when entity interacts
     * player can pick the item that they want get from the npc!! :)
     */
    public void pickPocket(Entity entity, Entity npc){
        if(successfulAction(this.pickPocketSkill) ){
            List<TakeableItem> nPCItems =  npc.getInventory();
            TakeableItem item = npc.removeItemFromInventory(nPCItems.get(0));
            entity.insertItemToInventory(item);
        }
    }

    public int rangedWeaponAttack(Entity entity, SneakWeapon weapon){
        int damage = 0;
        if(successfulAction(this.weaponSkill) ){
            damage += entity.getOffensiveRating(); //damage from entity
            damage += weapon.getWeaponsOffensiveRating(); // additional damage from weapon
        }
        return damage;
    }

    @Override
    public void levelUp(int creepIncrease, int detectionIncrease, int pickPocketIncrease, int weaponIncrease ){
        this.creepSkill += creepIncrease;
        this.detectionSkill +=  detectionIncrease;
        this.pickPocketSkill += pickPocketIncrease;
        this.weaponSkill += weaponIncrease;
    }
}
