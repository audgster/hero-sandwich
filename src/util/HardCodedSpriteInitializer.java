package util;

import java.util.HashMap;

public class HardCodedSpriteInitializer implements ISpriteMapInitializer
{
    @Override
    public HashMap<String, String> initialize() {
        HashMap<String, String> spriteMap = new HashMap<>();

        //AOE
        spriteMap.put("Identifier", "file");

        //Items
        spriteMap.put("Identifier", "file");
        spriteMap.put("Identifier", "file");

        //Entity
        spriteMap.put("Identifier", "file");
        spriteMap.put("Identifier", "file");

        return spriteMap;
    }
}
