package com.herosandwich.events;

import com.herosandwich.models.entity.Character;

/**
 * Created by clayhausen on 3/13/16.
 */

public interface PlayerDeathListener {

    void playerDies( Character deadPlayer );

}
