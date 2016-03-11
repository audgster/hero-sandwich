package com.herosandwich.models.items.takeableItems.equipableItems;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public abstract class EquipableItem extends TakeableItem {
    protected DerivedStats derivedStats;
    protected OccupationWeaponRestriction oWR;

    public EquipableItem(String name, DerivedStats derivedStat, int itemId){
        super(name, itemId);
        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
    }

    public int getWeaponsOffensiveRating(){
        return derivedStats.getOffensiveRating();
    }

     //derived Stats of Item
    //needs to be called my character when item is equipped
    public DerivedStats getDerivedStats(){
        return derivedStats;
    }

    public OccupationWeaponRestriction getOccupationWeaponRestriction(){
        return oWR;
    }
}
