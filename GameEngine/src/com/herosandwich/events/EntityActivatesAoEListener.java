package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.map.aoe.AoE;

/**
 * Created by Mitchell on 3/14/2016.
 */
public interface EntityActivatesAoEListener {

    void entityActivatesAoE(Entity entity, AoE aoE);

}
