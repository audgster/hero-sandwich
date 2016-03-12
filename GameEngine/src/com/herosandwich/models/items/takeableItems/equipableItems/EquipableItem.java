package com.herosandwich.models.items.takeableItems.equipableItems;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import java.util.HashSet;

public abstract class EquipableItem extends TakeableItem {
    protected DerivedStats derivedStats;
    protected OccupationWeaponRestriction oWR;
    protected HashSet<EquipmentSlots> allowableSlots;
    protected EquipmentType equipmentType;

    public EquipableItem(String name, int itemId){
        super(name,itemId);
        allowableSlots = new HashSet<>();

        derivedStats = new DerivedStats(1, 10, 10, 10, 10, 10);
        oWR = OccupationWeaponRestriction.EVERYONE;
        equipmentType = EquipmentType.ARMOR;
    }

    public EquipableItem(String name, DerivedStats derivedStat, int itemId){
        super(name, itemId);
        allowableSlots = new HashSet<>();

        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
        this.equipmentType = EquipmentType.ARMOR;
    }

    //use this one for all non-weapons!!!
    public EquipableItem(String name, DerivedStats derivedStat, int itemId, EquipmentType equipmentType){
        super(name, itemId);
        allowableSlots = new HashSet<>();

        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
        allowableSlots.add(EquipmentSlots.CHEST);
        this.equipmentType = equipmentType;
    }

    public EquipableItem(String name, DerivedStats derivedStat, int itemId, EquipmentSlots slot, EquipmentType equipmentType){
        super(name, itemId);
        allowableSlots = new HashSet<>();

        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
        allowableSlots.add(slot);
        this.equipmentType = equipmentType;
    }

    public DerivedStats getDerivedStats(){
        return derivedStats;
    }

    public OccupationWeaponRestriction getOccupationWeaponRestriction(){
        return this.oWR;
    }

    public String getAction(){ return "Equip";}
}
