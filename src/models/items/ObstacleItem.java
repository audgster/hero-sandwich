package models.items;

public class ObstacleItem extends Item
{
    public ObstacleItem(String name)
    {
        super(name);
    }

    @Override
    public boolean allowMovement()
    {
        return false;
    }
}
