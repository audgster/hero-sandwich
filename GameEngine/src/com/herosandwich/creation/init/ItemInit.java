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
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.summonerWeapons.SummonerWeapon;

import java.util.HashMap;

public class ItemInit {

    public enum ItemNames{
        WALL, //Obstacle
        ENEMY_BUTTON, //Interactable
        LOCKED_DOOR, //Interactable
        LOCKED_DOOR_OOP, //Interactable
        EXTRA_LOAF, //One-Shot
        COPPER_COIN, //One-Shot
        SILVER_COIN, //One-Shot
        GOLD_COIN, //One-Shot
        KEY, //Takeable
        CHECK_PLUS_PLUS, //Takeable
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
        PEPPER_JACK, //Equipable[Cheese]
        CELLOPHANE, //Equipable[Shield]
        ALUMINUM_FOIL, //Equipable[Shield]
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
        PEA_SHOOTER, //Sneak Weapon[Ranged]
        ONION_RING_CHAKRAM, //Sneak Weapon[Ranged]
        KETCHUP_BLASTER, //Sneak Weapon[Ranged]
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

        itemMap.put(ItemNames.WONDER_BREAD.ordinal(), new EquipableItem("Wonder Bread (tm)", ItemNames.WONDER_BREAD
                .ordinal(), new DerivedStats(0,0,0,0,1,1), EquipmentType.BODY_ARMOR));
        itemMap.put(ItemNames.MARBLE_RYE.ordinal(), new EquipableItem("Marble Rye", ItemNames.MARBLE_RYE
                .ordinal(), new DerivedStats(0,2,0,0,2,5), EquipmentType.BODY_ARMOR));
        itemMap.put(ItemNames.CIABATTA.ordinal(), new EquipableItem("Ciabatta", ItemNames.CIABATTA
                .ordinal(), new DerivedStats(0,1,0,0,5,2), EquipmentType.BODY_ARMOR));
        itemMap.put(ItemNames.HOAGIE_ROLL.ordinal(), new EquipableItem("Hoagie Roll", ItemNames.HOAGIE_ROLL
                .ordinal(), new DerivedStats(0,1,1,0,2,2), EquipmentType.BODY_ARMOR));

        itemMap.put(ItemNames.ROAST_BEEF.ordinal(), new EquipableItem("Roast Beef", ItemNames.ROAST_BEEF
                .ordinal(), new DerivedStats(0,1,0,0,1,2), EquipmentType.GREAVES));
        itemMap.put(ItemNames.RARE_ROAST_BEEF.ordinal(), new EquipableItem("Rare Roast Beef", ItemNames.RARE_ROAST_BEEF
                .ordinal(), new DerivedStats(0,2,0,0,2,4), EquipmentType.GREAVES));
        itemMap.put(ItemNames.HAM.ordinal(), new EquipableItem("Ham", ItemNames.HAM
                .ordinal(), new DerivedStats(0,1,0,2,0,1), EquipmentType.GREAVES));
        itemMap.put(ItemNames.TURKEY.ordinal(), new EquipableItem("Turkey", ItemNames.TURKEY
                .ordinal(), new DerivedStats(0,0,1,0,2,1), EquipmentType.GREAVES));
        itemMap.put(ItemNames.VEGGIE_PATTY.ordinal(), new EquipableItem("Veggie Patty", ItemNames.VEGGIE_PATTY
                .ordinal(), new DerivedStats(0,0,2,0,1,1), EquipmentType.GREAVES));

        itemMap.put(ItemNames.LETTUCE.ordinal(), new EquipableItem("Lettuce", ItemNames.LETTUCE
                .ordinal(), new DerivedStats(0,1,2,0,1,0), EquipmentType.HELM));
        itemMap.put(ItemNames.TOMATO.ordinal(), new EquipableItem("Tomato", ItemNames.TOMATO
                .ordinal(), new DerivedStats(0,1,0,0,2,1), EquipmentType.HELM));
        itemMap.put(ItemNames.ONION.ordinal(), new EquipableItem("Onion", ItemNames.ONION
                .ordinal(), new DerivedStats(0,1,0,2,0,1), EquipmentType.HELM));
        itemMap.put(ItemNames.PICKLES.ordinal(), new EquipableItem("Pickles", ItemNames.PICKLES
                .ordinal(), new DerivedStats(0,1,0,0,1,2), EquipmentType.HELM));
        itemMap.put(ItemNames.BANANA_PEPPERS.ordinal(), new EquipableItem("Banana Peppers", ItemNames.BANANA_PEPPERS
                .ordinal(), new DerivedStats(0,2,4,0,2,0), EquipmentType.HELM));

        itemMap.put(ItemNames.CHEDDAR.ordinal(), new EquipableItem("Cheddar", ItemNames.CHEDDAR
                .ordinal(), new DerivedStats(0,1,2,0,1,0), EquipmentType.BOOTS));
        itemMap.put(ItemNames.AMERICAN.ordinal(), new EquipableItem("American", ItemNames.AMERICAN
                .ordinal(), new DerivedStats(0,1,2,0,1,0), EquipmentType.BOOTS));
        itemMap.put(ItemNames.PROVOLONE.ordinal(), new EquipableItem("Provolone", ItemNames.PROVOLONE
                .ordinal(), new DerivedStats(0,1,0,2,0,1), EquipmentType.BOOTS));
        itemMap.put(ItemNames.SWISS.ordinal(), new EquipableItem("Swiss", ItemNames.SWISS
                .ordinal(), new DerivedStats(0,1,0,0,1,2), EquipmentType.BOOTS));
        itemMap.put(ItemNames.PEPPER_JACK.ordinal(), new EquipableItem("Pepper Jack", ItemNames.PEPPER_JACK
                .ordinal(), new DerivedStats(0,2,0,0,4,2), EquipmentType.BOOTS));

        itemMap.put(ItemNames.CELLOPHANE.ordinal(), new EquipableItem("Cellophane", ItemNames.CELLOPHANE
                .ordinal(), new DerivedStats(0,0,0,0,2,2), EquipmentType.SHIELD));
        itemMap.put(ItemNames.ALUMINUM_FOIL.ordinal(), new EquipableItem("Aluminum Foil", ItemNames.ALUMINUM_FOIL
                .ordinal(), new DerivedStats(0,0,0,0,5,5), EquipmentType.SHIELD));

        itemMap.put(ItemNames.FIST_WRAPS.ordinal(), new SmasherWeapon("Fist Wraps", ItemNames.FIST_WRAPS
                .ordinal(), new DerivedStats(0,0,0,2,0,0), WeaponType.BRAWL_WEAPON));
        itemMap.put(ItemNames.JALAPENO_POPPERS.ordinal(), new SmasherWeapon("Jalape\u00f1o Poppers", ItemNames
                .JALAPENO_POPPERS.ordinal(), new DerivedStats(0,0,0,5,0,0), WeaponType.BRAWL_WEAPON));
        itemMap.put(ItemNames.KNUCKLE_SANDWICH.ordinal(), new SmasherWeapon("Knuckle Sandwich", ItemNames.KNUCKLE_SANDWICH
                .ordinal(), new DerivedStats(0,0,0,7,0,0), WeaponType.BRAWL_WEAPON));

        itemMap.put(ItemNames.FRENCH_FRY.ordinal(), new SmasherWeapon("Limp French Fry", ItemNames.FRENCH_FRY
                .ordinal(), new DerivedStats(0,0,0,3,0,0), WeaponType.ONE_HANDED_WEAPON));
        itemMap.put(ItemNames.TOOTHPICK.ordinal(), new SmasherWeapon("Cocktail Toothpick", ItemNames.TOOTHPICK
                .ordinal(), new DerivedStats(0,0,0,6,0,0), WeaponType.ONE_HANDED_WEAPON));
        itemMap.put(ItemNames.PLASTIC_SWORD.ordinal(), new SmasherWeapon("Plastic Sword", ItemNames.PLASTIC_SWORD
                .ordinal(), new DerivedStats(0,0,0,9,0,0), WeaponType.ONE_HANDED_WEAPON));

        itemMap.put(ItemNames.BUTTER_KNIFE.ordinal(), new SmasherWeapon("Butter Knife", ItemNames.BUTTER_KNIFE
                .ordinal(), new DerivedStats(0,0,0,5,0,0), WeaponType.TWO_HANDED_WEAPON));
        itemMap.put(ItemNames.PICKLE_SPEAR.ordinal(), new SmasherWeapon("Pickle Spear", ItemNames.PICKLE_SPEAR
                .ordinal(), new DerivedStats(0,0,0,8,0,0), WeaponType.TWO_HANDED_WEAPON));
        itemMap.put(ItemNames.SERRATED_KNIFE.ordinal(), new SmasherWeapon("Serrated Knife", ItemNames.SERRATED_KNIFE
                .ordinal(), new DerivedStats(0,0,0,11,0,0), WeaponType.TWO_HANDED_WEAPON));

        itemMap.put(ItemNames.POTATO_CHIP_SHIV.ordinal(), new SneakWeapon("Potato Chip Shiv", ItemNames.POTATO_CHIP_SHIV
                .ordinal(), new DerivedStats(0,0,0,3,0,0), WeaponType.ONE_HANDED_WEAPON));
        itemMap.put(ItemNames.PEA_SHOOTER.ordinal(), new SneakWeapon("Pea Shooter", ItemNames.PEA_SHOOTER
                .ordinal(), new DerivedStats(0,0,0,2,0,0), WeaponType.RANGED_WEAPON));
        itemMap.put(ItemNames.ONION_RING_CHAKRAM.ordinal(), new SneakWeapon("Onion Ring Chakram", ItemNames
                .ONION_RING_CHAKRAM.ordinal(), new DerivedStats(0,0,0,4,0,0), WeaponType.RANGED_WEAPON));
        itemMap.put(ItemNames.KETCHUP_BLASTER.ordinal(), new SneakWeapon("Ketchup Blaster", ItemNames.KETCHUP_BLASTER
                .ordinal(), new DerivedStats(0,0,0,6,0,0), WeaponType.RANGED_WEAPON));

        itemMap.put(ItemNames.CELERY_STAFF.ordinal(), new SummonerWeapon("Celery Staff", ItemNames.CELERY_STAFF
                .ordinal(), new DerivedStats(0,0,0,2,0,0), WeaponType.TWO_HANDED_WEAPON));
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
        if(itemID < ItemNames.WALL.ordinal() || itemID >= ItemNames.ENEMY_BUTTON.ordinal()){
            throw new IllegalArgumentException("Item corresponding to itemID: " + itemID + " does not exist");
        }
        return (ObstacleItem) itemMap.get(itemID);
    }

    public InteractableItem getInteractableItem(int itemID){
        if(itemID < ItemNames.ENEMY_BUTTON.ordinal() || itemID >= ItemNames.EXTRA_LOAF.ordinal()){
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
