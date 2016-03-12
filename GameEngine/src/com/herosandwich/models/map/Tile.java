package com.herosandwich.models.map;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.Item;
import com.herosandwich.models.map.aoe.AoE;
import com.herosandwich.util.PositionHex;
import com.herosandwich.util.visitor.AoEVisitor;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;
import com.herosandwich.util.visitor.TileVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
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
    private LinkedHashSet<Item> itemList;
    private LinkedHashSet<AoE> aoeList;

    public Tile(PositionHex pos, Terrain terrain){
        this.pos = pos;
        this.terrain = terrain;
        this.entity = null;
        this.itemList = new LinkedHashSet<Item>();
        this.aoeList = new LinkedHashSet<AoE>();
    }

    public Tile(PositionHex pos, Terrain terrain, Entity entity, Collection<Item> items, Collection<AoE> aoes){
        this.pos = pos;
        this.terrain = terrain;
        this.entity = entity;
        this.itemList = new LinkedHashSet<Item>();
        this.aoeList = new LinkedHashSet<AoE>();

        if(items != null) {
            for (Item item: items) {
                itemList.add(item);
            }
        }

        if(aoes != null) {
            for (AoE aoe : aoes) {
                aoeList.add(aoe);
            }
        }
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
        if(this.itemList.contains(item)){
            //error
            return item;
        }
        else{
            this.itemList.add(item);
            return item;
        }
    }

    public Item removeItem(Item item){
        if(this.itemList.contains(item)){
            this.itemList.remove(item);
            return item;
        }
        else{
            //error
            return null;
        }
    }

    public AoE addAoE(AoE aoe){
        if(this.aoeList.contains(aoe)){
            //error
            return aoe;
        }
        else{
            this.aoeList.add(aoe);
            return aoe;
        }
    }

    public AoE removeAoE(AoE aoe){
        if(this.aoeList.contains(aoe)){
            this.aoeList.remove(aoe);
            return aoe;
        }
        else{
            //error
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

    public void accept(AoEVisitor aoeVisitor){
        for(AoE aoe: aoeList){
            aoe.accept(aoeVisitor);
        }
    }

}
