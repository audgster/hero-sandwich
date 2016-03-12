package com.herosandwich.models.map;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.Item;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;
import com.herosandwich.util.visitor.TileVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void acceptTileVisitor(TileVisitor tVisitor){
        tVisitor.visitTile(this);
    }

    public void acceptItemVisitor(ItemVisitor iVisitor){
        for(Item item: itemList){
            item.accept(iVisitor);
        }
    }

    public void acceptEntityVisitor(EntityVisitor eVisitor){
        for(Entity entity: entityList){
            entity.accept(eVisitor);
        }
    }

    /*
    public void accept(AOEVisitor aoeVisitor){
        for(AreaOfEffect aoe: aoeList){
            aoe.accept(aoeVisitor);//
        }
    }
     */

}
