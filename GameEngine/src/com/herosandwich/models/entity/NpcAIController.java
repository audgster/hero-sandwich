package com.herosandwich.models.entity;

import com.herosandwich.menus.areaviewdrawables.Listener;
import com.herosandwich.models.map.Map;

/**
 * Created by Mitchell on 3/14/2016.
 */
public class NpcAIController{

    private Npc npc;
    private Map map;

    public NpcAIController(Npc npc, Map map){
        this.npc = npc;
        this.map = map;
    }

    public void update(){
        if(npc.getAttitudeTowardsPlayer() == Attitude.HOSTILE || npc.getAttitudeTowardsPlayer() == Attitude
                .VERY_HOSTILE){

        }
    }

}
