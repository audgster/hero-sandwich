package com.herosandwich.creation.init;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.Item;
import com.herosandwich.models.items.interactableItems.InteractableItem;
import com.herosandwich.models.items.obstacleItems.ObstacleItem;
import com.herosandwich.models.items.oneShotItems.OneShotItem;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.consumableItems.ConsumableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.summonerWeapons.SummonerWeapon;

import java.util.HashMap;

public class ItemInit {

    public enum ItemNames{
        WALL, //Obstacle
        LOCKED_DOOR, //Interactable
        EXTRA_LOAF, //One-Shot
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
        WONDER_BREAD, //Equipable[Bread]
        MARBLE_RYE, //Equipable[Bread]
        CIABATTA, //Equipable[Bread]
        HOAGIE_ROLL, //Equipable[Bread]
        ROAST_BEEF, //Equipable[Meat]
        RARE_ROAST_BEEF, //Equipable[Meat]
        HAM, //Equipable[Meat]
        TURKEY, //Equipable[Meat]
        VEGGIE_PATTY, //Equipable[Meat]
        LETTUCE, //Equipable[Veggie]
        TOMATO, //Equipable[Veggie]
        ONION, //Equipable[Veggie]
        PICKLES, //Equipable[Veggie]
        BANANA_PEPPERS, //Equipable[Veggie]
        CHEDDAR, //Equipable[Cheese]
        AMERICAN, //Equipable[Cheese]
        PROVOLONE, //Equipable[Cheese]
        SWISS, //Equipable[Cheese]
        FIST_WRAPS, //Smasher Weapon[Brawler]
        JALAPENO_POPPERS, //Smasher Weapon[Brawler]
        KNUCKLE_SANDWICH, //Smasher Weapon[Brawler]
        FRENCH_FRY, //Smasher Weapon[One-Handed]
        TOOTHPICK, //Smasher Weapon[One-Handed]
        PLASTIC_SWORD, //Smasher Weapon[One-Handed]
        BUTTER_KNIFE, //Smasher Weapon[Two-Handed]
        PICKLE_SPEAR, //Smasher Weapon[Two-Handed]
        SERRATED_KNIFE, //Smasher Weapon[Two-Handed]
        POTATO_CHIP_SHIV, //Sneak Weapon[One-Handed]
        KETCHUP_BLASTER, //Sneak Weapon[Ranged]
        ONION_RING_CHAKRAM, //Sneak Weapon[Ranged]
        PEA_SHOOTER, //Sneak Weapon[Ranged]
        CELERY_STAFF, //Summoner_Weapon[Two-Handed]
    }

    private static ItemInit instance = null;
    private HashMap<Integer, Item> itemMap;

    private ItemInit(){
        itemMap = new HashMap<Integer, Item>();

        itemMap.put(ItemNames.WALL.ordinal(), new ObstacleItem("Wall", ItemNames.WALL.ordinal()));

        itemMap.put(ItemNames.LOCKED_DOOR.ordinal(), new InteractableItem("Locked Door", ItemNames.LOCKED_DOOR.ordinal
                ()));

        itemMap.put(ItemNames.EXTRA_LOAF.ordinal(), new OneShotItem("Extra Loaf", ItemNames.EXTRA_LOAF.ordinal()));
        itemMap.put(ItemNames.COPPER_COIN.ordinal(), new OneShotItem("Copper Coin", ItemNames.COPPER_COIN.ordinal()));
        itemMap.put(ItemNames.SILVER_COIN.ordinal(), new OneShotItem("Silver Coin", ItemNames.SILVER_COIN.ordinal()));
        itemMap.put(ItemNames.GOLD_COIN.ordinal(), new OneShotItem("Gold Coin", ItemNames.GOLD_COIN.ordinal()));

        itemMap.put(ItemNames.KEY.ordinal(), new TakeableItem("Key", ItemNames.KEY.ordinal()));

        itemMap.put(ItemNames.HEALTH_POTION_MINOR.ordinal(), new ConsumableItem("Health Potion (Minor)", ItemNames
                .HEALTH_POTION_MINOR.ordinal()));
        itemMap.put(ItemNames.HEALTH_POTION_MODERATE.ordinal(), new ConsumableItem("Health Potion (Moderate)", ItemNames
                .HEALTH_POTION_MODERATE.ordinal()));
        itemMap.put(ItemNames.HEALTH_POTION_MAJOR.ordinal(), new ConsumableItem("Health Potion (Major)", ItemNames
                .HEALTH_POTION_MAJOR.ordinal()));
        itemMap.put(ItemNames.MANA_POTION_MINOR.ordinal(), new ConsumableItem("Mana Potion (Minor)", ItemNames
                .MANA_POTION_MINOR.ordinal()));
        itemMap.put(ItemNames.MANA_POTION_MODERATE.ordinal(), new ConsumableItem("Mana Potion (Moderate)", ItemNames
                .MANA_POTION_MODERATE.ordinal()));
        itemMap.put(ItemNames.MANA_POTION_MAJOR.ordinal(), new ConsumableItem("Mana Potion (Major)", ItemNames
                .MANA_POTION_MAJOR.ordinal()));

        itemMap.put(ItemNames.WONDER_BREAD.ordinal(), new EquipableItem("Wonder Bread", ItemNames.WONDER_BREAD
                .ordinal(), new DerivedStats(), EquipmentType.BODY_ARMOR));

    }

    public static ItemInit getInstance(){
        if(instance == null){
            return new ItemInit();
        }
        else{
            return instance;
        }
    }

    public Item getItem(int itemID){
        if(itemID < 0 || itemID >= ItemNames.values().length){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return itemMap.get(itemID);
    }

    public ObstacleItem getObstacleItem(int itemID){
        if(itemID < ItemNames.WALL.ordinal() || itemID >= ItemNames.LOCKED_DOOR.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (ObstacleItem) itemMap.get(itemID);
    }

    public InteractableItem getInteractableItem(int itemID){
        if(itemID < ItemNames.LOCKED_DOOR.ordinal() || itemID >= ItemNames.EXTRA_LOAF.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (InteractableItem) itemMap.get(itemID);
    }

    public OneShotItem getOneShotItem(int itemID){
        if(itemID < ItemNames.EXTRA_LOAF.ordinal() || itemID >= ItemNames.KEY.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (OneShotItem) itemMap.get(itemID);
    }

    public TakeableItem getTakeableItem(int itemID){
        if(itemID < ItemNames.KEY.ordinal() || itemID >= ItemNames.values().length){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (TakeableItem) itemMap.get(itemID);
    }

    public ConsumableItem getConsumableItem(int itemID){
        if(itemID < ItemNames.HEALTH_POTION_MINOR.ordinal() || itemID >= ItemNames.WONDER_BREAD.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (ConsumableItem) itemMap.get(itemID);
    }

    public EquipableItem getEquipableItem(int itemID){
        if(itemID < ItemNames.WONDER_BREAD.ordinal() || itemID >= ItemNames.values().length){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (EquipableItem) itemMap.get(itemID);
    }

    public Weapon getWeapon(int itemID){
        if(itemID < ItemNames.FIST_WRAPS.ordinal() || itemID >= ItemNames.values().length){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (Weapon) itemMap.get(itemID);
    }

    public SmasherWeapon getSmasherWeapon(int itemID){
        if(itemID < ItemNames.FIST_WRAPS.ordinal() || itemID >= ItemNames.POTATO_CHIP_SHIV.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (SmasherWeapon) itemMap.get(itemID);
    }

    public SneakWeapon getSneakWeapon(int itemID){
        if(itemID < ItemNames.POTATO_CHIP_SHIV.ordinal() || itemID >= ItemNames.CELERY_STAFF.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (SneakWeapon) itemMap.get(itemID);
    }

    public SummonerWeapon getSummonerWeapon(int itemID){
        if(itemID < ItemNames.CELERY_STAFF.ordinal() || itemID >= ItemNames.values().length){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (SummonerWeapon) itemMap.get(itemID);
    }

}
