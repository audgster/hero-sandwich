package com.herosandwich.events;

/**
 * Created by clayhausen on 3/13/16.
 */

import com.herosandwich.models.entity.Entity;

/** Passes the Npc that died **/
public class EntityDeathEvent implements GameEvent<EntityDeathListener> {
    private final Entity deadEntity;

    public EntityDeathEvent(Entity deadEntity) {
        this.deadEntity = deadEntity;
    }

    @Override
    public void notify(EntityDeathListener listener) {
        listener.entityDies( deadEntity );
    }
}
