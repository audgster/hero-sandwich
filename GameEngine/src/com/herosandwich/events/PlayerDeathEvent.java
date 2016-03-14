package com.herosandwich.events;

import com.herosandwich.models.map.Map;
import com.herosandwich.models.entity.Character;

/**
 * Created by clayhausen on 3/13/16.
 */
public class PlayerDeathEvent implements GameEvent<PlayerDeathListener> {
    private final Character deadPlayer;

    public PlayerDeathEvent( Character deadPlayer ) {
        this.deadPlayer = deadPlayer;
    }

    @Override
    public void notify( PlayerDeathListener listener ) {
        listener.playerDies( deadPlayer );
    }
}
