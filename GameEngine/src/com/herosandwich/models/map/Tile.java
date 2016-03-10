package com.herosandwich.models.map;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.Item;
import com.herosandwich.util.PositionHex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mitchell on 3/7/2016.
 */
public class Tile {

    public enum Terrain{
        GRASS,
        WATER,
        MOUNTAIN
    }

    private PositionHex pos;
    private Terrain terrain;
    private List<Entity> entityList;
    private List<Item> itemList;
    //private List<AreaOfEffect> aoeList;

    public Tile(PositionHex pos, Terrain terrain){
        this.pos = pos;
        this.terrain = terrain;
        this.entityList = new ArrayList<Entity>();
        this.itemList = new ArrayList<Item>();
        //this.aoeList = new ArrayList<AreaOfEffect>();
    }

    public Tile(PositionHex pos, Terrain terrain, Collection<Entity> entities, Collection<Item> items/*, Collection<AreaOfEffect> aoes*/){
        this.pos = pos;
        this.terrain = terrain;
        this.entityList = new ArrayList<Entity>();
        this.itemList = new ArrayList<Item>();
        //this.aoeList = new ArrayList<AreaOfEffect>();

        if(entities != null) {
            for (Entity entity : entities) {
                entityList.add(entity);
            }
        }

        if(items != null) {
            for (Item item: items) {
                itemList.add(item);
            }
        }
        /*
        if(aoes != null) {
            for (AreaOfEffect aoe : aoes) {
                aoeList.add(aoe);
            }
        }
        */
    }

    public PositionHex getPosition(){
        return pos;
    }

    public Terrain getTerrain(){
        return terrain;
    }

}
