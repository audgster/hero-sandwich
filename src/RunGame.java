import models.entities.Entity;
import models.entities.EntityStats;
import models.entities.Smasher;
import util.Direction;
import util.EntityIdentifier;

public class RunGame{

	public static void main(String[] args)
  	{
    GameWindow gw = new GameWindow();
		gw.setVisible(true);

    // Entity entity = new Entity("EntityTest",
    //         new Smasher(),
    //         new EntityStats(10, 10, 10, 10, 10, 3, 0, 100, 100),
    //         EntityIdentifier.GROUND,
    //         Direction.NORTH);

    // System.out.println(entity.getEntityStats().getLife());
    // System.out.println(entity.getEntityStats().getCurrentLife());

    // Entity entity2 = new Entity();


    // System.out.println(entity2.getEntityStats().getLife());
    // System.out.println(entity2.getEntityStats().getCurrentLife());
	}
}
