package com.herosandwich.events;

import com.herosandwich.models.entity.Entity;
import com.herosandwich.models.entity.Character;
import com.herosandwich.models.entity.Skill;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.Weapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.WeaponType;
import com.herosandwich.models.occupation.Occupation;

/**
 * Created by clayhausen on 3/11/16.
 */
public class CombatDamageCalculator implements CharacterMeleeAttacksEntityListener {

    @Override
    public boolean characterMeleeAttacksEntity(Character attackingCharacter, Entity targetEntity) {

        boolean successful = true;
        int bonusDamage = 0;

        Weapon rightWeapon = attackingCharacter.getRightHand();
        Weapon leftWeapon = attackingCharacter.getLeftHand();
        Occupation occupation = attackingCharacter.getOccupation();

        if (rightWeapon != null && leftWeapon != null) { // two weapons equipped

            Skill rightWeaponSkill = Skill.convertFromString(WeaponType.convertToString(rightWeapon.getWeaponType()));
            if (!occupation.successfulAction(rightWeaponSkill)) {
                successful = false;
            } else {
                bonusDamage += occupation.getLevelOfSkill(rightWeaponSkill);
            }

            Skill leftWeaponSkill = Skill.convertFromString(WeaponType.convertToString(leftWeapon.getWeaponType()));
            if (!occupation.successfulAction(leftWeaponSkill)) {
                successful = false;
            } else {
                bonusDamage += occupation.getLevelOfSkill(leftWeaponSkill);
            }

            if (successful == false) {
                /** Test print **/
                System.out.println(attackingCharacter.getName() + " failed the skill check: attack failed!");
                return successful;
            }

        } else if (rightWeapon != null) {

            Skill weaponSkill = Skill.convertFromString(WeaponType.convertToString(rightWeapon.getWeaponType()));
            if (!occupation.successfulAction(weaponSkill)) {
                /** Test print **/
                System.out.println(attackingCharacter.getName() + " failed the skill check: attack failed!");
                return !successful;
            } else {
                bonusDamage = occupation.getLevelOfSkill(weaponSkill);
            }

        } else if (leftWeapon != null) {

            Skill weaponSkill = Skill.convertFromString(WeaponType.convertToString(leftWeapon.getWeaponType()));
            if (!occupation.successfulAction(weaponSkill)) {
                /** Test print **/
                System.out.println(attackingCharacter.getName() + " failed the skill check: attack failed!");
                return !successful;
            } else {
                bonusDamage = occupation.getLevelOfSkill(weaponSkill);
            }

        } else { // No weapons equipped
            if (occupation.toString() == "Smasher") {
                if (!occupation.successfulAction(Skill.BRAWL)) {
                    /** Test print **/
                    System.out.println(attackingCharacter.getName() + " failed the skill check: attack failed!");
                    return !successful;
                } else {
                    bonusDamage = occupation.getLevelOfSkill(Skill.BRAWL);
                }
            } else { // only Smasher can attack without weapons

                return !successful;

            }
        }

            // Determine the amount of damage dealt
            int grossDamageDealt = attackingCharacter.getOffensiveRating() + bonusDamage;
            int damageAbsorbed = targetEntity.getArmorRating();
            int netDamageDealt = -(grossDamageDealt - damageAbsorbed);
            // Make sure attacks deal at least 1 damage
            if (netDamageDealt <= 0) {
                --netDamageDealt;
            }

            // Deal the damage
            targetEntity.modifyCurrentLife(netDamageDealt);


            /** Test print **/
            System.out.println(attackingCharacter.getName() + " dealt " + netDamageDealt + " to " + targetEntity.getName() + "!");
            System.out.println(targetEntity.getName() + " has " + targetEntity.getCurrentLife() + " health remaining!");
            System.out.println(targetEntity.getName() + " has " + targetEntity.getLives() + " lives remaining!");

            // TODO
        /* Check if target has 0 lives and 0 health remaining...if so, notify npcDeathEvent */
            EventDispatcher dispatcher = EventDispatcher.getInstance();
            if (targetEntity.getCurrentLife() <= 0 && targetEntity.getLives() <= 0) {
                dispatcher.notify(new EntityDeathEvent(targetEntity));
            }

            return successful;
    }
}