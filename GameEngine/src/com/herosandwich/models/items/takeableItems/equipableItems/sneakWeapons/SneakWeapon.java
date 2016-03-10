package com.herosandwich.models.items.takeableItems.equipableItems.sneakWeapons;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;

/**
 * Created by matthewdiaz on 3/4/16.
 */

public abstract class SneakWeapon extends EquipableItem {
    public SneakWeapon(String name, DerivedStats dervidedStat, int itemId){
        super(name, dervidedStat, itemId);
    }

    @Override
    public void getPickedUp(){
        //Only pickable if entity has occupation Sneak
    }

}