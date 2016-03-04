package com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;

/**
 * Created by matthewdiaz on 3/4/16.
 */

public abstract class SmasherWeapon extends EquipableItem {
    public SmasherWeapon(String name){
        super(name);
    }

    public boolean isPickable(){
        return true;
    }
}
