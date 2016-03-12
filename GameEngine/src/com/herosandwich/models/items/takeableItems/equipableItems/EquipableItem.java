package com.herosandwich.models.items.takeableItems.equipableItems;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import java.util.HashSet;
import java.util.Iterator;

public abstract class EquipableItem extends TakeableItem {
    protected DerivedStats derivedStats;
    protected OccupationWeaponRestriction oWR;
    protected HashSet<EquipmentSlots> allowableSlots;
    protected EquipmentType equipmentType;

    //use this one if don't want to insert a new DerivedStat
    public EquipableItem(String name, int itemId, EquipmentType equipmentType){
        super(name, itemId);
        allowableSlots = new HashSet<>();

        derivedStats = new DerivedStats(1, 10, 10, 10, 10, 10);
        oWR = OccupationWeaponRestriction.EVERYONE;
        this.equipmentType = equipmentType;
        calculateAllowableSlots();
    }

    //use this one for max customization!!!! Best option!
    public EquipableItem(String name, int itemId, DerivedStats derivedStat, EquipmentType equipmentType){
        super(name, itemId);
        allowableSlots = new HashSet<>();

        derivedStats = derivedStat;
        oWR = OccupationWeaponRestriction.EVERYONE;
        this.equipmentType = equipmentType;
        calculateAllowableSlots();
    }

    private void calculateAllowableSlots(){
        if(equipmentType == EquipmentType.HELM){
            allowableSlots.add(EquipmentSlots.HEAD);
        }else if(equipmentType == EquipmentType.BODY_ARMOR){
            allowableSlots.add(EquipmentSlots.CHEST);
        }else if(equipmentType == EquipmentType.WEAPON){
            allowableSlots.add(EquipmentSlots.LEFT_HAND);
            allowableSlots.add(EquipmentSlots.RIGHT_HAND);
        }else if(equipmentType == EquipmentType.SHIELD){
            allowableSlots.add(EquipmentSlots.LEFT_HAND);
            allowableSlots.add(EquipmentSlots.RIGHT_HAND);
        }else if(equipmentType == EquipmentType.GREAVES){
            allowableSlots.add(EquipmentSlots.LEGGINGS);
        }else if(equipmentType == EquipmentType.BOOTS){
            allowableSlots.add(EquipmentSlots.FEET);
        }
    }

    public DerivedStats getDerivedStats(){
        return derivedStats;
    }

    public OccupationWeaponRestriction getOccupationWeaponRestriction(){
        return this.oWR;
    }

    public String getAction(){ return "Equip";}
    public Iterator getSlotPosition(){
        return allowableSlots.iterator();
    }

    //not sure if we need this any more?
    public EquipmentType getEquipmentType(){
        return equipmentType;
    }
}
