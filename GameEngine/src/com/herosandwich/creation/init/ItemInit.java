package com.herosandwich.creation.init;

import com.herosandwich.models.items.Item;
import com.herosandwich.models.items.interactableItems.InteractableItem;
import com.herosandwich.models.items.obstacleItems.ObstacleItem;
import com.herosandwich.models.items.oneShotItems.OneShotItem;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.summonerWeapons.SummonerWeapon;

import java.util.HashMap;

/**
 * Created by Mitchell on 3/12/2016.
 */
public class ItemInit {

    public enum ItemNames{
        WALL, //Obstacle
        LOCKED_DOOR, //Interactable
        ONE_UP, //One-Shot
        COPPER_COIN, //One-Shot
        SILVER_COIN, //One-Shot
        GOLD_COIN, //One-Shot
        KEY, //Takeable
        HEALTH_POTION_MINOR, //Consumable
        HEALTH_POTION_MODERATE, //Consumable
        HEALTH_POTION_MAJOR, //Consumable
        MANA_POTION_MINOR, //Consumable
        MANA_POTION_MODERATE, //Consumable
        MANA_POTION_MAJOR, //Consumable
        WONDER_BREAD, //Equipable
        WHEAT_BREAD, //Equipable

    }

    private static ItemInit instance = null;
    private HashMap<Integer, Item> itemMap;

    private ItemInit(){
        itemMap = new HashMap<Integer, Item>();



    }

    private static ItemInit getInstance(){
        if(instance == null){
            return new ItemInit();
        }
        else{
            return instance;
        }
    }

    public Item getItem(int itemID){
        return itemMap.get(itemID);
    }

    public InteractableItem getInteractableItem(int itemID){
        return (InteractableItem) itemMap.get(itemID);
    }

    public ObstacleItem getObstacleItem(int itemID){
        return (ObstacleItem) itemMap.get(itemID);
    }

    public OneShotItem getOneShotItem(int itemID){
        return (OneShotItem) itemMap.get(itemID);
    }

    public TakeableItem getTakeableItem(int itemID){
        return (TakeableItem) itemMap.get(itemID);
    }

    public EquipableItem getEquipableItem(int itemID){
        return (EquipableItem) itemMap.get(itemID);
    }

    public Weapon getWeapon(int itemID){
        return (Weapon) itemMap.get(itemID);
    }

    public SmasherWeapon getSmasherWeapon(int itemID){
        return (SmasherWeapon) itemMap.get(itemID);
    }

    public SneakWeapon getSneakWeapon(int itemID){
        return (SneakWeapon) itemMap.get(itemID);
    }

    public SummonerWeapon getSummonerWeapon(int itemID){
        return (SummonerWeapon) itemMap.get(itemID);
    }

}
