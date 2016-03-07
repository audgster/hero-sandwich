package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;

/**
 * Created by matthewdiaz on 3/4/16.
 */

public abstract class SmasherWeapon extends EquipableItem {
    public SmasherWeapon(String name, DerivedStats dervidedStat){
        super(name, dervidedStat);
    }

    @Override
    public void getPickedUp(){
        //Only pickable if entity has occupation Smasher
    }

}
