package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.map.aoe.AoE;

/**
 * Created by Mitchell on 3/14/2016.
 */
public class EntityActivatesAoEEvent implements GameEvent<EntityActivatesAoEListener> {

    private final Entity entity;
    private final AoE aoE;

    public EntityActivatesAoEEvent(Entity entity, AoE aoE) {
        this.entity = entity;
        this.aoE = aoE;
    }

    @Override
    public void notify(EntityActivatesAoEListener listener) {
        listener.entityActivatesAoE(entity, aoE);
    }
}
