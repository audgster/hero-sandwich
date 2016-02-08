package util;

import java.util.HashMap;

public class HardCodedSpriteInitializer implements ISpriteMapInitializer
{
    @Override
    public HashMap<String, String> initialize() {
        HashMap<String, String> spriteMap = new HashMap<>();

        //AOE
        spriteMap.put("AoE_TakeDamageAoE", "../images/AoE_TakeDamage.gif");
		spriteMap.put("AoE_HealDamageAoE", "../images/AoE_HealDamage.gif");
		spriteMap.put("AoE_LevelUpAoE", "../images/AoE_LevelUp.gif");
		spriteMap.put("AoE_InstaDeathAoE", "../images/AoE_InstaDeath.gif");

        //Items
        spriteMap.put("Item_ConsumableItem", "../images/Item_Consumable.png");
        spriteMap.put("Item_equippableEquipableItem", "../images/Item_Equipable.png");
		spriteMap.put("Item_TakeableItem", "../images/Item_Takeable.png");
		spriteMap.put("Item_OneShotItem", "../images/Item_OneShot.png");
		spriteMap.put("Item_InteractableItem", "../images/Item_Interactable.png");
		spriteMap.put("Item_ObstacleItem", "../images/Item_Obstacle.png");

		spriteMap.put("Item_Super Sayan SwordEquipableItem", "../images/SuperSayanSword.gif");
		spriteMap.put("Item_The Boots Of AwesomeEquipableItem", "../images/TheBootsOfAwesome.gif");

        spriteMap.put("Item_Healing Super PotionStatModifyingOneShotItem", "../images/Item_Equipable.png");
        spriteMap.put("Item_Mediocre Healing PotionStatModifyingConsumableItem", "../images/Item_Equipable.png");

        //Entity
        spriteMap.put("Entity_Smasher_NORTH", "../images/Entity_Smasher_N.gif");
		spriteMap.put("Entity_Smasher_NORTHEAST", "../images/Entity_Smasher_NE.gif");
		spriteMap.put("Entity_Smasher_EAST", "../images/Entity_Smasher_E.gif");
		spriteMap.put("Entity_Smasher_SOUTHEAST", "../images/Entity_Smasher_SE.gif");
		spriteMap.put("Entity_Smasher_SOUTH", "../images/Entity_Smasher_S.gif");
		spriteMap.put("Entity_Smasher_SOUTHWEST", "../images/Entity_Smasher_SW.gif");
		spriteMap.put("Entity_Smasher_WEST", "../images/Entity_Smasher_W.gif");
		spriteMap.put("Entity_Smasher_NORTHWEST", "../images/Entity_Smasher_NW.gif");
		
        spriteMap.put("Entity_Sneak_NORTH", "../images/Entity_Sneak_N.gif");
		spriteMap.put("Entity_Sneak_NORTHEAST", "../images/Entity_Sneak_NE.gif");
		spriteMap.put("Entity_Sneak_EAST", "../images/Entity_Sneak_E.gif");
		spriteMap.put("Entity_Sneak_SOUTHEAST", "../images/Entity_Sneak_SE.gif");
		spriteMap.put("Entity_Sneak_SOUTH", "../images/Entity_Sneak_S.gif");
		spriteMap.put("Entity_Sneak_SOUTHWEST", "../images/Entity_Sneak_SW.gif");
		spriteMap.put("Entity_Sneak_WEST", "../images/Entity_Sneak_W.gif");
		spriteMap.put("Entity_Sneak_NORTHWEST", "../images/Entity_Sneak_NW.gif");
		
		spriteMap.put("Entity_Summoner_NORTH", "../images/Entity_Summoner_N.gif");
		spriteMap.put("Entity_Summoner_NORTHEAST", "../images/Entity_Summoner_NE.gif");
		spriteMap.put("Entity_Summoner_EAST", "../images/Entity_Summoner_E.gif");
		spriteMap.put("Entity_Summoner_SOUTHEAST", "../images/Entity_Summoner_SE.gif");
		spriteMap.put("Entity_Summoner_SOUTH", "../images/Entity_Summoner_S.gif");
		spriteMap.put("Entity_Summoner_SOUTHWEST", "../images/Entity_Summoner_SW.gif");
		spriteMap.put("Entity_Summoner_WEST", "../images/Entity_Summoner_W.gif");
		spriteMap.put("Entity_Summoner_NORTHWEST", "../images/Entity_Summoner_NW.gif");
		
		//Tile
		spriteMap.put("Tile_GROUND", "../images/Tile_Ground.gif");
		spriteMap.put("Tile_WATER", "../images/Tile_Water.gif");
		spriteMap.put("Tile_MOUNTAIN", "../images/Tile_Mountain.gif");

        return spriteMap;
    }
}
