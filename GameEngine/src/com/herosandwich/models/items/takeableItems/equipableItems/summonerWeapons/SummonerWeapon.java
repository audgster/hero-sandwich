package com.herosandwich.models.items.takeableItems.equipableItems.summonerWeapons;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public abstract class SummonerWeapon extends EquipableItem {
    public SummonerWeapon(String name, DerivedStats dervidedStat, int itemId){
        super(name, dervidedStat, itemId);
        oWR = OccupationWeaponRestriction.SUMMONER;
    }
}