package util;

/**
 * Created by simonnea on 2/1/16.
 */
public enum Direction
{
    EAST(6),
    NORTHEAST(9),
    NORTH(8),
    NORTHWEST(7),
    WEST(4),
    SOUTHWEST(1),
    SOUTH(2),
    SOUTHEAST(3);

    private final int keyMap;

    Direction(int key)
    {
        this.keyMap = key;
    }

    public int getKeyBinding()
    {
        return keyMap;
    }
}
