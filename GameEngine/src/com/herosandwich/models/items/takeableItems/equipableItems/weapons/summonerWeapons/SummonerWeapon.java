package com.herosandwich.models.items.takeableItems.equipableItems.weapons.summonerWeapons;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.util.visitor.ItemVisitor;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public abstract class SummonerWeapon extends Weapon {
    public SummonerWeapon(String name, int itemId, DerivedStats derivedStats){
        super(name, itemId, derivedStats);
        oWR = OccupationWeaponRestriction.SUMMONER;
        weaponType = WeaponType.ONE_HANDED_WEAPON;
    }

    public SummonerWeapon(String name, int itemId, DerivedStats derivedStats, WeaponType wType){
        super(name, itemId, derivedStats);
        oWR = OccupationWeaponRestriction.SUMMONER;
        weaponType = wType;
    }

    public void accept(ItemVisitor visitor){
        visitor.visitSummonerWeapon(this);
    }
}