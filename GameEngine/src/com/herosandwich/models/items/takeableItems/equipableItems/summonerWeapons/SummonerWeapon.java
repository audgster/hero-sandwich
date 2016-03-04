package com.herosandwich.models.items.takeableItems.equipableItems.summonerWeapons;

import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public abstract class SummonerWeapon extends EquipableItem {
    public SummonerWeapon(String name, DerivedStats dervidedStat){
        super(name, dervidedStat);
    }

    @Override
    public void getPickedUp(){
        if(true){
            super.getPickedUp();
        }


        //Only pickable if entity has occupation Summoner
    }
}