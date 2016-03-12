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
    private Entity entity;
    private List<Item> itemList;
    //private List<AreaOfEffect> aoeList;

    public Tile(PositionHex pos, Terrain terrain){
        this.pos = pos;
        this.terrain = terrain;
        this.entity = null;
        this.itemList = new ArrayList<Item>();
        //this.aoeList = new ArrayList<AreaOfEffect>();
    }

    public Tile(PositionHex pos, Terrain terrain, Entity entity, Collection<Item> items/*, Collection<AreaOfEffect> aoes*/){
        this.pos = pos;
        this.terrain = terrain;
        this.entity = entity;
        this.itemList = new ArrayList<Item>();
        //this.aoeList = new ArrayList<AreaOfEffect>();

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

    public Entity getEntity(){
        return entity;
    }

    //get for items and aoes?

    public void addEntity(Entity entity){
        if(this.entity != null){
            throw new IllegalStateException("Tile already contains an entity");
        }
        this.entity = entity;
    }

    public void removeEntity(Entity entity){
        if(!this.entity.equals(entity)){
            throw new IllegalArgumentException("Given entity does not match previously stored entity");
        }
        this.entity = null;
    }

    public Item addItem(Item item){
        if(this.itemList.add(item)){
            return item;
        }
        else{
            return null;
        }
    }

    public Item removeItem(Item item){
        if(this.itemList.remove(item)){
            return item;
        }
        else{
            return null;
        }
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
        this.entity.accept(eVisitor);
    }

    /*
    public void accept(AOEVisitor aoeVisitor){
        for(AreaOfEffect aoe: aoeList){
            aoe.accept(aoeVisitor);//
        }
    }
     */

}
