package com.herosandwich.util.visitor;

import com.herosandwich.models.items.Item;
import com.herosandwich.models.items.interactableItems.InteractableItem;
import com.herosandwich.models.items.obstacleItems.ObstacleItem;
import com.herosandwich.models.items.oneShotItems.OneShotItem;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.models.items.takeableItems.consumableItems.ConsumableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.sneakWeapons.SneakWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.summonerWeapons.SummonerWeapon;

/**
 * Created by Mitchell on 3/10/2016.
 */
public interface ItemVisitor {
    public void visitItem(Item item);
    public void visitInteractableItem(InteractableItem ineractableItem);
    public void visitObstacleItem(ObstacleItem obstacleItem);
    public void visitOneShotItem(OneShotItem oneShotItem);
    public void visitTakeableItem(TakeableItem takeableItem);
    public void visitConsumableItem(ConsumableItem consumableItem);
    public void visitEquipableItem(EquipableItem equipableItem);
    //do I need these subtypes?
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon);
    //even more subtypes?
    public void visitSneakWeapon(SneakWeapon sneakWeapon);
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon);
}
