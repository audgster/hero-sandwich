package com.herosandwich.util.visitor.movement;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
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
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;
import com.herosandwich.util.visitor.TileVisitor;

/**
 * Created by Mitchell on 3/10/2016.
 */
public class MovementVisitor implements TileVisitor, EntityVisitor, ItemVisitor{

    private boolean canMove;

    public MovementVisitor(){
        this.canMove = false;
    }

    public final boolean canMove(){
        return this.canMove;
    }

    public final void acceptRule(boolean b){
        this.canMove = this.canMove & b;
    }

    @Override
    public void visitEntity(Entity entity) {
        acceptRule(false);
    }

    @Override
    public void visitCharacter(Character character) {
        acceptRule(false);
    }

    @Override
    public void visitPet(Pet pet) {
        acceptRule(false);
    }

    @Override
    public void visitNpc(Npc npc) {
        acceptRule(false);
    }

    @Override
    public void visitPlayer(Player player) {
        acceptRule(false);
    }

    @Override
    public void visitMount(Mount mount) {
        acceptRule(false);
    }

    @Override
    public void visitItem(Item item) {
        acceptRule(true);
    }

    @Override
    public void visitInteractableItem(InteractableItem ineractableItem) {
        acceptRule(true);
    }

    @Override
    public void visitObstacleItem(ObstacleItem obstacleItem) {
        acceptRule(false);
    }

    @Override
    public void visitOneShotItem(OneShotItem oneShotItem) {
        acceptRule(true);
    }

    @Override
    public void visitTakeableItem(TakeableItem takeableItem) {
        acceptRule(true);
    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {
        acceptRule(true);
    }

    @Override
    public void visitEquipableItem(EquipableItem equipableItem) {
        acceptRule(true);
    }

    @Override
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon) {
        acceptRule(true);
    }

    @Override
    public void visitSneakWeapon(SneakWeapon sneakWeapon) {
        acceptRule(true);
    }

    @Override
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon) {
        acceptRule(true);
    }

    @Override
    public void visitTile(Tile tile) {
        acceptRule(true);
    }
}
