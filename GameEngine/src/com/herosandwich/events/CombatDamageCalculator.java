package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Character;

/**
 * Created by clayhausen on 3/11/16.
 */
public class CombatDamageCalculator implements CharacterMeleeAttacksEntityListener {

    @Override
    public boolean characterMeleeAttacksEntity(Character attackingCharacter, Entity targetEntity) {

        boolean success = false;

        // Determine whether or not the attack was successful
        /*
        Occupation occupation = attackingCharacter.getOccupation();
        attackingCharacter.getRightHand();
        occupation.successfulAction(5);
        */

        // Determine the amount of damage dealt
        int grossDamageDealt = attackingCharacter.getOffensiveRating() /*+ attackCharacter.getWeaponSkill()*/;
        int damageAbsorbed = targetEntity.getArmorRating();
        int netDamageDealt = -( grossDamageDealt - damageAbsorbed );
        // Make sure attacks deal at least 1 damage
        if ( netDamageDealt == 0 ) {
            --netDamageDealt;
        }

        // Deal the damage
        targetEntity.modifyCurrentLife( -netDamageDealt );

        /** Test print **/
        System.out.println(attackingCharacter.getName() + " dealt " + netDamageDealt + " to " + targetEntity.getName() + "!");
        System.out.println(targetEntity.getName() + " has " + targetEntity.getCurrentLife() + " health remaining!");
        System.out.println(targetEntity.getName() + " has " + targetEntity.getLives() + " lives remaining!");

        // TODO
        /* Check if target has 0 lives and 0 health remaining...if so, notify npcDeathEvent */
        EventDispatcher dispatcher = EventDispatcher.getInstance();
        if ( targetEntity.getCurrentLife() <= 0 && targetEntity.getLives() <= 0 ) {
            dispatcher.notify( new EntityDeathEvent(targetEntity) );
        }

        return success;
    }

}
