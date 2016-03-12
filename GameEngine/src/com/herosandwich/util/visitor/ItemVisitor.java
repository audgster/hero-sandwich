package com.herosandwich.util.visitor;

import com.herosandwich.models.items.Item;
import com.herosandwich.models.items.interactableItems.InteractableItem;
import com.herosandwich.models.items.obstacleItems.ObstacleItem;
import com.herosandwich.models.items.oneShotItems.OneShotItem;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.consumableItems.ConsumableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.sneakWeapons.SneakWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.weapons.summonerWeapons.SummonerWeapon;

public interface ItemVisitor {
    void visitItem(Item item);
    void visitInteractableItem(InteractableItem ineractableItem);
    void visitObstacleItem(ObstacleItem obstacleItem);
    void visitOneShotItem(OneShotItem oneShotItem);
    void visitTakeableItem(TakeableItem takeableItem);
    void visitConsumableItem(ConsumableItem consumableItem);
    void visitEquipableItem(EquipableItem equipableItem);
    //do I need these subtypes?
    void visitSmasherWeapon(SmasherWeapon smasherWeapon);
    //even more subtypes?
    void visitSneakWeapon(SneakWeapon sneakWeapon);
    void visitSummonerWeapon(SummonerWeapon summonerWeapon);
}
