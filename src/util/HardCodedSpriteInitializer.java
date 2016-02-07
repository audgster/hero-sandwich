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
        spriteMap.put("Item_Consumable", "../images/Item_Consumable.png");
        spriteMap.put("Item_Equipable", "../images/Item_Equipable.png");
		spriteMap.put("Item_Takeable", "../images/Item_Takeable.png");
		spriteMap.put("Item_OneShot", "../images/Item_OneShot.png");
		spriteMap.put("Item_Interactable", "../images/Item_Interactable.png");
		spriteMap.put("Item_Obstacle", "../images/Item_Obstacle.png");

        //Entity
        spriteMap.put("Entity_Smasher_0", "../images/Entity_Smasher_0.png");
        spriteMap.put("Entity_Sneak_0", "../images/Entity_Sneak_0.png");
		spriteMap.put("Entity_Summoner_0", "../images/Entity_Summoner_0.png");
		
		//Tile
		spriteMap.put("Tile_Grass", "../images/Tile_Grass.png");
		spriteMap.put("Tile_Water", "../images/Tile_Water.png");
		spriteMap.put("Tile_Mountain", "../images/Tile_Water.png");

        return spriteMap;
    }
}
