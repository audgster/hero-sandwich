package models.items;
import java.util.List;

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
    public List<String> getSaveState(){
      return null;
    }
}
