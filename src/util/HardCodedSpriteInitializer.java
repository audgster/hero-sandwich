package util;

import java.util.HashMap;

public class HardCodedSpriteInitializer implements ISpriteMapInitializer
{
    @Override
    public HashMap<String, String> initialize() {
        HashMap<String, String> spriteMap = new HashMap<>();

        //AOE
        spriteMap.put("AoE_TakeDamageAoE", "resources/images/AoE_TakeDamage.gif");
		spriteMap.put("AoE_HealDamageAoE", "resources/images/AoE_HealDamage.gif");
		spriteMap.put("AoE_LevelUpAoE", "resources/images/AoE_LevelUp.gif");
		spriteMap.put("AoE_InstaDeathAoE", "resources/images/AoE_InstaDeath.gif");

        //Items
        spriteMap.put("Item_ConsumableItem", "resources/images/Item_Consumable.png");
        spriteMap.put("Item_equippableEquipableItem", "resources/images/Item_Equipable.png");
		spriteMap.put("Item_TakeableItem", "resources/images/Item_Takeable.png");
		spriteMap.put("Item_OneShotItem", "resources/images/Item_OneShot.png");
		spriteMap.put("Item_InteractableItem", "resources/images/Item_Interactable.png");
		spriteMap.put("Item_ObstacleItem", "resources/images/Item_Obstacle.png");

		spriteMap.put("Item_Super Sayan SwordEquipableItem", "resources/images/SuperSayanSword.gif");
		spriteMap.put("Item_The Boots Of AwesomeEquipableItem", "resources/images/TheBootsOfAwesome.gif");

        spriteMap.put("Item_Healing Super PotionStatModifyingOneShotItem", "resources/images/HealingSuperPotion.gif");
        spriteMap.put("Item_Mediocre Healing PotionStatModifyingConsumableItem", "resources/images/MediocreHealingPotion.gif");

		spriteMap.put("Item_Magic AoE WandTakeableItem", "resources/images/MagicAoeWand.gif");

		spriteMap.put("Item_AoE RemoverInteractableItem", "resources/images/AoeRemover.gif");

        spriteMap.put("Item_Super Unmoveable ObjectObstacleItem", "resources/images/UnmoveableObject.gif");

        //Entity
        spriteMap.put("Entity_Smasher_NORTH", "resources/images/Entity_Smasher_N.gif");
		spriteMap.put("Entity_Smasher_NORTHEAST", "resources/images/Entity_Smasher_NE.gif");
		spriteMap.put("Entity_Smasher_EAST", "resources/images/Entity_Smasher_E.gif");
		spriteMap.put("Entity_Smasher_SOUTHEAST", "resources/images/Entity_Smasher_SE.gif");
		spriteMap.put("Entity_Smasher_SOUTH", "resources/images/Entity_Smasher_S.gif");
		spriteMap.put("Entity_Smasher_SOUTHWEST", "resources/images/Entity_Smasher_SW.gif");
		spriteMap.put("Entity_Smasher_WEST", "resources/images/Entity_Smasher_W.gif");
		spriteMap.put("Entity_Smasher_NORTHWEST", "resources/images/Entity_Smasher_NW.gif");
		
        spriteMap.put("Entity_Sneak_NORTH", "resources/images/Entity_Sneak_N.gif");
		spriteMap.put("Entity_Sneak_NORTHEAST", "resources/images/Entity_Sneak_NE.gif");
		spriteMap.put("Entity_Sneak_EAST", "resources/images/Entity_Sneak_E.gif");
		spriteMap.put("Entity_Sneak_SOUTHEAST", "resources/images/Entity_Sneak_SE.gif");
		spriteMap.put("Entity_Sneak_SOUTH", "resources/images/Entity_Sneak_S.gif");
		spriteMap.put("Entity_Sneak_SOUTHWEST", "resources/images/Entity_Sneak_SW.gif");
		spriteMap.put("Entity_Sneak_WEST", "resources/images/Entity_Sneak_W.gif");
		spriteMap.put("Entity_Sneak_NORTHWEST", "resources/images/Entity_Sneak_NW.gif");
		
		spriteMap.put("Entity_Summoner_NORTH", "resources/images/Entity_Summoner_N.gif");
		spriteMap.put("Entity_Summoner_NORTHEAST", "resources/images/Entity_Summoner_NE.gif");
		spriteMap.put("Entity_Summoner_EAST", "resources/images/Entity_Summoner_E.gif");
		spriteMap.put("Entity_Summoner_SOUTHEAST", "resources/images/Entity_Summoner_SE.gif");
		spriteMap.put("Entity_Summoner_SOUTH", "resources/images/Entity_Summoner_S.gif");
		spriteMap.put("Entity_Summoner_SOUTHWEST", "resources/images/Entity_Summoner_SW.gif");
		spriteMap.put("Entity_Summoner_WEST", "resources/images/Entity_Summoner_W.gif");
		spriteMap.put("Entity_Summoner_NORTHWEST", "resources/images/Entity_Summoner_NW.gif");
		
		//Tile
		spriteMap.put("Tile_GROUND", "resources/images/Tile_Ground.gif");
		spriteMap.put("Tile_WATER", "resources/images/Tile_Water.gif");
		spriteMap.put("Tile_MOUNTAIN", "resources/images/Tile_Mountain.gif");

        return spriteMap;
    }
}
