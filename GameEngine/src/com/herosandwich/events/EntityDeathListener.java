package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;

/**
 * Created by clayhausen on 3/13/16.
 */
public interface EntityDeathListener {

    void entityDies( Entity deadEntity );

}
