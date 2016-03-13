package com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons;
import com.herosandwich.models.entity.DerivedStats;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipmentType;
import com.herosandwich.models.items.takeableItems.equipableItems.OccupationWeaponRestriction;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.util.visitor.ItemVisitor;

/**
 * Created by matthewdiaz on 3/4/16.
 */

public class SneakWeapon extends Weapon {
    public SneakWeapon(String name, int itemId, DerivedStats derivedStats){
        super(name, itemId, derivedStats, WeaponType.RANGED_WEAPON);
        oWR = OccupationWeaponRestriction.SNEAK;
    }

    public SneakWeapon(String name, int itemId, DerivedStats derivedStats, WeaponType weaponType){
        super(name, itemId, derivedStats, weaponType);
        oWR = OccupationWeaponRestriction.SNEAK;
    }

    public void accept(ItemVisitor visitor){
        visitor.visitSneakWeapon(this);
    }
}