package com.herosandwich.events;

import com.herosandwich.models.entity.Character;
import com.herosandwich.models.map.Map;

/**
 * Created by clayhausen on 3/13/16.
 */
public class PlayerDeathHandler implements PlayerDeathListener {

    private Map map;

    public PlayerDeathHandler(Map map) {
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void playerDies(Character deadPlayer) {
        // No lives remaining
        if (deadPlayer.getLives() <= 0) {
            // go to Game Over screen
        } else { // spawn at last checkpoint
            map.addEntity(map.getCheckPoint(), deadPlayer);
        }
    }

}
