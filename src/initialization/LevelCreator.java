package initialization;


import models.map.Map;

public class LevelCreator {

    public LevelCreator(){}

    public Level createLevel() {
        MapCreator mapCreator = new MapCreator("initialization/config.xml");
        Map map = mapCreator.create();
        return new Level(1, map);

    }

    public Level createLevel(Level level, Map map) {
        level.setMap(map);
        return level;
    }
}
