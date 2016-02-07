package util;

import java.util.HashMap;

public class HardCodedSpriteInitializer implements ISpriteMapInitializer
{
    @Override
    public HashMap<String, String> initialize() {
        HashMap<String, String> spriteMap = new HashMap<>();

        //AOE
        spriteMap.put("AoE_TakeDamage", "../images/AoE_TakeDamage.png");
		spriteMap.put("AoE_HealDamage", "../images/AoE_HealDamage.png");
		spriteMap.put("AoE_LevelUp", "../images/AoE_LevelUp.png");
		spriteMap.put("AoE_InstaDeath", "../images/AoE_InstaDeath.png");

        //Items
        spriteMap.put("Item_ConsumableItem", "../images/Item_Consumable.png");
        spriteMap.put("Item_EquipableItem", "../images/Item_Equipable.png");
		spriteMap.put("Item_TakeableItem", "../images/Item_Takeable.png");
		spriteMap.put("Item_OneShotItem", "../images/Item_OneShot.png");
		spriteMap.put("Item_InteractableItem", "../images/Item_Interactable.png");
		spriteMap.put("Item_ObstacleItem", "../images/Item_Obstacle.png");

        //Entity
        spriteMap.put("Entity_Smasher_NORTH", "../images/Entity_Smasher_0.png");
		spriteMap.put("Entity_Smasher_NORTHEAST", "../images/Entity_Smasher_1.png");
		spriteMap.put("Entity_Smasher_EAST", "../images/Entity_Smasher_2.png");
		spriteMap.put("Entity_Smasher_SOUTHEAST", "../images/Entity_Smasher_3.png");
		spriteMap.put("Entity_Smasher_SOUTH", "../images/Entity_Smasher_4.png");
		spriteMap.put("Entity_Smasher_SOUTHWEST", "../images/Entity_Smasher_5.png");
		spriteMap.put("Entity_Smasher_WEST", "../images/Entity_Smasher_6.png");
		spriteMap.put("Entity_Smasher_NORTHWEST", "../images/Entity_Smasher_7.png");
		
        spriteMap.put("Entity_Sneak_0", "../images/Entity_Sneak_0.png");
		
		spriteMap.put("Entity_Summoner_0", "../images/Entity_Summoner_0.png");
		
		//Tile
		spriteMap.put("Tile_GROUND", "../images/Tile_Ground.png");
		spriteMap.put("Tile_WATER", "../images/Tile_Water.png");
		spriteMap.put("Tile_MOUNTAINn", "../images/Tile_Mountain.png");

        return spriteMap;
    }
}
