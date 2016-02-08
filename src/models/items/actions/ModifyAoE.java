package models.items.actions;

import models.entities.Entity;
import models.items.TakeableItem;
import models.map.Tile;
import models.map.areaofeffect.AreaOfEffect;
import models.map.areaofeffect.LevelUpAoE;

import java.util.List;

public class ModifyAoE implements IAction
{

    @Override
    public boolean execute(Entity entity, Tile tile)
    {
        TakeableItem item = new TakeableItem("Magic AoE Wand");

        boolean hasItem = entity.getInventory().hasItem(item);

        if (hasItem)
        {
            for (AreaOfEffect aoe : tile.getAllAoE())
                tile.removeAoE(aoe);


            entity.getInventory().remove(item);
            return true;
        }

        return false;
    }

    @Override
    public List<String> getSaveState() {
        return null;
    }
}
