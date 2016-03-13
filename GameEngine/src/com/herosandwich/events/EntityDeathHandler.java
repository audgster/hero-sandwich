package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.PositionHex;

/**
 * Created by clayhausen on 3/13/16.
 */
public class EntityDeathHandler implements EntityDeathListener {
    private Map map;

    public EntityDeathHandler(Map map) {
        this.map = map;
    }

    /** Remove the dead entity from the map **/
    @Override
    public void entityDies(Entity deadEntity) {
            PositionHex pos = deadEntity.getPosition();
            Tile tile = map.getTile(pos);
            tile.removeEntity(deadEntity);
    }
}
