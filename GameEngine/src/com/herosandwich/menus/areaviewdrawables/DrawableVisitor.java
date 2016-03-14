package com.herosandwich.menus.areaviewdrawables;

import com.herosandwich.models.entity.*;
import com.herosandwich.models.entity.Character;
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
import com.herosandwich.models.map.Tile;
import com.herosandwich.models.map.aoe.*;
import com.herosandwich.util.visitor.AoEVisitor;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;
import com.herosandwich.util.visitor.TileVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamfortier on 3/12/16.
 */
public class DrawableVisitor implements EntityVisitor, TileVisitor, ItemVisitor, AoEVisitor{

    private List<Drawable> drawableList = new ArrayList<Drawable>();

    private AoeDrawable drawableAoe = new AoeDrawable();
    private NpcDrawable npcDrawable = new NpcDrawable();
    private ItemDrawable itemDrawable = new ItemDrawable();
    private EntityDrawable entityDrawable = new EntityDrawable();

    SpriteMap spriteMap = SpriteMap.getInstance();

    @Override
    public void visitEntity(Entity entity) {
        entityDrawable.setGraphicKey(101);
        drawableList.add(entityDrawable);
    }

    @Override
    public void visitCharacter(Character character) {
        entityDrawable.setGraphicKey(101);
        drawableList.add(entityDrawable);    }

    @Override
    public void visitPet(Pet pet) {

    }

    @Override
    public void visitNpc(Npc npc) {
        entityDrawable.setType(npc.getName());
        drawableList.add(entityDrawable);
   }

    @Override
    public void visitPlayer(Player player) {
        entityDrawable.setGraphicKey(101);
        drawableList.add(entityDrawable);
    }

    @Override
    public void visitMount(Mount mount) {

    }

    @Override
    public void visitItem(Item item) {
        itemDrawable.setGraphicKey(item.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitInteractableItem(InteractableItem interactableItem) {
        itemDrawable.setGraphicKey(interactableItem.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitObstacleItem(ObstacleItem obstacleItem) {
        itemDrawable.setGraphicKey(obstacleItem.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitOneShotItem(OneShotItem oneShotItem) {
        itemDrawable.setGraphicKey(oneShotItem.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitTakeableItem(TakeableItem takeableItem) {
        itemDrawable.setGraphicKey(takeableItem.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {
        itemDrawable.setGraphicKey(consumableItem.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitEquipableItem(EquipableItem equipableItem) {
        itemDrawable.setGraphicKey(equipableItem.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon) {
        itemDrawable.setGraphicKey(smasherWeapon.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitSneakWeapon(SneakWeapon sneakWeapon) {
        itemDrawable.setGraphicKey(sneakWeapon.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon) {
        itemDrawable.setGraphicKey(summonerWeapon.getItemId());
        drawableList.add(itemDrawable);
    }

    @Override
    public void visitTile(Tile tile) {

    }


    @Override
    public void visitAoE(AoE aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }

    @Override
    public void visitInstaDeathAoE(InstaDeathAoE aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }

    @Override
    public void visitXpAoE(XpAoE aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }

    @Override
    public void visitHealDamageAoE(HealDamageAoE aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }

    @Override
    public void visitTakeDamageAoE(TakeDamageAoE aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }

    @Override
    public void visitTeleportAoE(TeleportAoE aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }

    @Override
    public void visitTrapAoE(InstantDamageAoETrap aoE) {
        drawableAoe.setAoeType(aoE.toString());
        drawableList.add(drawableAoe);
    }


    public void clearDrawableList() {
        drawableList.clear();
    }

    public List getDrawableList() {
        return drawableList;
    }
}
