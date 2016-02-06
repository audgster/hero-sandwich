package initialization;


public class LevelCreator {

    public LevelCreator(){}

    public Level createLevel() {
        MapCreator mapCreator = new MapCreator("initialization/config.xml");
        TestMap map = mapCreator.create();
        return new Level(1, map);

    }

    public Level createLevel(Level level, TestMap map) {
        level.setMap(map);
        return level;
    }
}
