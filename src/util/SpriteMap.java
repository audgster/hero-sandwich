package util;

//import java.net.URL;
import java.util.HashMap;

public class SpriteMap
{
    HashMap<String, String> spriteMap;

    public SpriteMap(ISpriteMapInitializer initializer)
    {
        spriteMap = initializer.initialize();
    }

    public String getResourcePath(String entityId) throws Exception
    {
        //Should return default texture?
        if (!spriteMap.containsKey(entityId))
            throw new Exception("Merp tried to get an entity that doesn't exist");

        String relativePath = spriteMap.get(entityId);
		return relativePath;
        //return ResourceUtil.getResourceURL(relativePath);
    }
}
