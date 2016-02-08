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

        //Entity
        spriteMap.put("Entity_Smasher_NORTH", "../images/Entity_Smasher_N.png");
		spriteMap.put("Entity_Smasher_NORTHEAST", "../images/Entity_Smasher_NE.png");
		spriteMap.put("Entity_Smasher_EAST", "../images/Entity_Smasher_E.png");
		spriteMap.put("Entity_Smasher_SOUTHEAST", "../images/Entity_Smasher_SE.png");
		spriteMap.put("Entity_Smasher_SOUTH", "../images/Entity_Smasher_S.png");
		spriteMap.put("Entity_Smasher_SOUTHWEST", "../images/Entity_Smasher_SW.png");
		spriteMap.put("Entity_Smasher_WEST", "../images/Entity_Smasher_W.png");
		spriteMap.put("Entity_Smasher_NORTHWEST", "../images/Entity_Smasher_NW.png");
		
        spriteMap.put("Entity_Sneak_NORTH", "../images/Entity_Sneak_N.png");
		spriteMap.put("Entity_Sneak_NORTHEAST", "../images/Entity_Sneak_NE.png");
		spriteMap.put("Entity_Sneak_EAST", "../images/Entity_Sneak_E.png");
		spriteMap.put("Entity_Sneak_SOUTHEAST", "../images/Entity_Sneak_SE.png");
		spriteMap.put("Entity_Sneak_SOUTH", "../images/Entity_Sneak_S.png");
		spriteMap.put("Entity_Sneak_SOUTHWEST", "../images/Entity_Sneak_SW.png");
		spriteMap.put("Entity_Sneak_WEST", "../images/Entity_Sneak_W.png");
		spriteMap.put("Entity_Sneak_NORTHWEST", "../images/Entity_Sneak_NW.png");
		
		spriteMap.put("Entity_Summoner_NORTH", "../images/Entity_Summoner_N.png");
		spriteMap.put("Entity_Summoner_NORTHEAST", "../images/Entity_Summoner_NE.png");
		spriteMap.put("Entity_Summoner_EAST", "../images/Entity_Summoner_E.png");
		spriteMap.put("Entity_Summoner_SOUTHEAST", "../images/Entity_Summoner_SE.png");
		spriteMap.put("Entity_Summoner_SOUTH", "../images/Entity_Summoner_S.png");
		spriteMap.put("Entity_Summoner_SOUTHWEST", "../images/Entity_Summoner_SW.png");
		spriteMap.put("Entity_Summoner_WEST", "../images/Entity_Summoner_W.png");
		spriteMap.put("Entity_Summoner_NORTHWEST", "../images/Entity_Summoner_NW.png");
		
		//Tile
		spriteMap.put("Tile_GROUND", "../images/Tile_Ground.gif");
		spriteMap.put("Tile_WATER", "../images/Tile_Water.gif");
		spriteMap.put("Tile_MOUNTAIN", "../images/Tile_Mountain.gif");

        return spriteMap;
    }
}
