package com.herosandwich.models.items.takeableItems.equipableItems.summonerWeapons;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;

import java.util.Collection;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public abstract class SummonerWeapon extends EquipableItem {
    public SummonerWeapon(String name, int itemId, DerivedStats derivedStats){
        super(name, itemId, derivedStats, EquipmentType.WEAPON);
        oWR = OccupationWeaponRestriction.SUMMONER;
    }
}