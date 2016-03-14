package com.herosandwich.util.visitor.movement;

import com.herosandwich.events.CharacterPickUpItemEvent;
import com.herosandwich.events.EventDispatcher;
import com.herosandwich.events.PetPickUpItemEvent;
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
import com.herosandwich.models.map.Map;
import com.herosandwich.models.map.MapEventHandler;
import com.herosandwich.models.map.aoe.*;
import com.herosandwich.util.visitor.AoEVisitor;
import com.herosandwich.util.visitor.EntityVisitor;
import com.herosandwich.util.visitor.ItemVisitor;

/**
 * Created by Mitchell on 3/13/2016.
 */
public class MovementExecutionVisitor implements EntityVisitor, ItemVisitor, AoEVisitor{

    private Map map;
    private Entity entity;
    private boolean entityIsCharacter = false;
    private boolean entityIsPet = false;

    public MovementExecutionVisitor(Map map, Entity entity){
        this.map = map;
        this.entity = entity;
    }

    public MovementExecutionVisitor(Map map, Character character){
        this.map = map;
        this.entity = character;
    }

    @Override
    public void visitEntity(Entity entity) {
        entityIsCharacter = false;
        entityIsPet = false;
    }

    @Override
    public void visitCharacter(Character character) {
        visitEntity(character);
        entityIsCharacter = true;
    }

    @Override
    public void visitPet(Pet pet) {
        visitEntity(pet);
        entityIsPet = true;
    }

    @Override
    public void visitNpc(Npc npc) {
        visitCharacter(npc);
    }

    @Override
    public void visitPlayer(Player player) {
        visitCharacter(player);
    }

    @Override
    public void visitMount(Mount mount) {
        visitCharacter(mount);
    }

    @Override
    public void visitAoE(AoE aoE) {

    }

    @Override
    public void visitInstaDeathAoE(InstaDeathAoE aoE) {

    }

    @Override
    public void visitXpAoE(XpAoE aoE) {

    }

    @Override
    public void visitHealDamageAoE(HealDamageAoE aoE) {

    }

    @Override
    public void visitTakeDamageAoE(TakeDamageAoE aoE) {

    }

    @Override
    public void visitTeleportAoE(TeleportAoE aoE) {

    }

    @Override
    public void visitItem(Item item) {
        //Uh-Oh
    }

    @Override
    public void visitInteractableItem(InteractableItem ineractableItem) {
        //do interaction
    }

    @Override
    public void visitObstacleItem(ObstacleItem obstacleItem) {
        throw new IllegalStateException("You cannot move onto Obstacles");
    }

    @Override
    public void visitOneShotItem(OneShotItem oneShotItem) {
        //do effect
        map.removeItem(entity.getPosition(), oneShotItem);
    }

    @Override
    public void visitTakeableItem(TakeableItem takeableItem) {
        //MapEventHandler eventHandler = new MapEventHandler(this.map);
        if(entityIsCharacter){
            //eventHandler.characterPickUpItem((Character)this.entity, takeableItem);
            CharacterPickUpItemEvent event = new CharacterPickUpItemEvent((Character) this.entity, takeableItem);
            EventDispatcher dispatcher = EventDispatcher.getInstance();
            dispatcher.notify(event);
        }
        else if(entityIsPet){
            //eventHandler.petPickUpItem((Pet)this.entity, takeableItem);
            PetPickUpItemEvent event = new PetPickUpItemEvent((Pet)this.entity, takeableItem);
            EventDispatcher dispatcher = EventDispatcher.getInstance();
            dispatcher.notify(event);
        }
    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {
        this.visitTakeableItem(consumableItem);
    }

    @Override
    public void visitEquipableItem(EquipableItem equipableItem) {
        this.visitTakeableItem(equipableItem);
    }

    @Override
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon) {
        this.visitEquipableItem(smasherWeapon);
    }

    @Override
    public void visitSneakWeapon(SneakWeapon sneakWeapon) {
        this.visitEquipableItem(sneakWeapon);
    }

    @Override
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon) {
        this.visitEquipableItem(summonerWeapon);
    }

}
