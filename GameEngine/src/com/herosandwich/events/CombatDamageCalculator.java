package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.occupation.Property;

/**
 * Created by clayhausen on 3/11/16.
 */
public class CombatDamageCalculator implements CharacterMeleeAttacksEntityListener {
    boolean mutex = false;

    @Override
    public boolean characterMeleeAttacksEntity(Character attackingCharacter, Entity targetEntity) {

        boolean success = false;

        // Determine the amount of damage dealt
        int grossDamageDealt = attackingCharacter.getOffensiveRating() /*+ attackCharacter.getWeaponSkill()*/;
        int damageAbsorbed = targetEntity.getArmorRating();
        int netDamageDealt = -( grossDamageDealt - damageAbsorbed );
        // Make sure attacks deal at least 1 damage
        if ( netDamageDealt == 0 ) {
            --netDamageDealt;
        }
        System.out.println(netDamageDealt);

        // Deal the damage
        targetEntity.modifyCurrentLife( -netDamageDealt );

        return success;
    }

}
