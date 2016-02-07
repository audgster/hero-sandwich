package initialization;

import models.map.Map;
import models.Level;
import models.map.locationmanager.LocationManager;

public class LevelCreator {

    public LevelCreator(){}

    public Level createLevel() {
        MapCreator mapCreator = new MapCreator("../initialization/config.xml");
        Map map = mapCreator.create();
        return new Level(new LocationManager(), map);
    }

    public Level createLevel(Level level, Map map) {
        level.setMap(map);
        return level;
    }
}
