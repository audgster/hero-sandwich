package com.herosandwich.models.items.takeableItems.equipableItems;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.TakeableItem;

public abstract class EquipableItem extends TakeableItem {
    protected DerivedStats derivedStats;
    protected OccupationWeaponRestriction oWR;
    protected EquipmentSlots slot;

    public EquipableItem(String name, int itemId){
        super(name,itemId);
        derivedStats = new DerivedStats(1, 10, 10, 10, 10, 10);
        oWR = OccupationWeaponRestriction.EVERYONE;
        slot = EquipmentSlots.CHEST;
    }

    public EquipableItem(String name, DerivedStats derivedStat, int itemId){
        super(name, itemId);
        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
        slot = EquipmentSlots.CHEST;
    }

    public EquipableItem(String name, DerivedStats derivedStat, int itemId, EquipmentSlots slot){
        super(name, itemId);
        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
        this.slot = slot;
    }

    public EquipmentSlots getItemsEquipmentSlotLocation(){
        return this.slot;
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
        return this.oWR;
    }
}
