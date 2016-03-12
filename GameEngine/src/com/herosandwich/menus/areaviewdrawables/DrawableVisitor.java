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
import com.herosandwich.models.items.takeableItems.equipableItems.smasherWeapons.SmasherWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.sneakWeapons.SneakWeapon;
import com.herosandwich.models.items.takeableItems.equipableItems.summonerWeapons.SummonerWeapon;
import com.herosandwich.models.map.Tile;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;
import com.herosandwich.util.visitor.TileVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamfortier on 3/12/16.
 */
public class DrawableVisitor implements EntityVisitor, TileVisitor, ItemVisitor{

    private List<Drawable> drawableList = new ArrayList<Drawable>();

    private NpcDrawable npcDrawable = new NpcDrawable();

    SpriteMap spriteMap = SpriteMap.getInstance();

    @Override
    public void visitEntity(Entity entity) {

    }

    @Override
    public void visitCharacter(Character character) {
        character.getOccupation();
    }

    @Override
    public void visitPet(Pet pet) {

    }

    @Override
    public void visitNpc(Npc npc) {
//        drawableList.add(npcDrawable.setGraphicKey(npc.getName());)
   }

    @Override
    public void visitPlayer(Player player) {

    }

    @Override
    public void visitMount(Mount mount) {

    }

    @Override
    public void visitItem(Item item) {

    }

    @Override
    public void visitInteractableItem(InteractableItem ineractableItem) {
        //drawableList.add(spriteMap.getImageForKey(ineractableItem.getItemId()));
    }

    @Override
    public void visitObstacleItem(ObstacleItem obstacleItem) {

    }

    @Override
    public void visitOneShotItem(OneShotItem oneShotItem) {

    }

    @Override
    public void visitTakeableItem(TakeableItem takeableItem) {

    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {

    }

    @Override
    public void visitEquipableItem(EquipableItem equipableItem) {

    }

    @Override
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon) {

    }

    @Override
    public void visitSneakWeapon(SneakWeapon sneakWeapon) {

    }

    @Override
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon) {

    }

    @Override
    public void visitTile(Tile tile) {

    }




    public void clearDrawableList() {
        drawableList.clear();
    }

    public List getDrawableList() {
        return drawableList;
    }
}
