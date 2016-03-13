package com.herosandwich.util.visitor.xmlsave;

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
import com.herosandwich.util.visitor.ItemVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlSaveItemVisitor implements ItemVisitor
{
    private Document doc;

    Element itemElement;

    public XmlSaveItemVisitor(Document doc)
    {
        this.doc = doc;

        itemElement = doc.createElement("items");
    }

    @Override
    public void visitItem(Item item) {
        retrieveItemId(item);
    }

    @Override
    public void visitInteractableItem(InteractableItem ineractableItem) {
        retrieveItemId(ineractableItem);
    }

    @Override
    public void visitObstacleItem(ObstacleItem obstacleItem) {
        retrieveItemId(obstacleItem);
    }

    @Override
    public void visitOneShotItem(OneShotItem oneShotItem) {
        retrieveItemId(oneShotItem);
    }

    @Override
    public void visitTakeableItem(TakeableItem takeableItem) {
        retrieveItemId(takeableItem);
    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {
        retrieveItemId(consumableItem);
    }

    @Override
    public void visitEquipableItem(EquipableItem equipableItem) {
        retrieveItemId(equipableItem);
    }

    @Override
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon) {
        retrieveItemId(smasherWeapon);
    }

    @Override
    public void visitSneakWeapon(SneakWeapon sneakWeapon) {
        retrieveItemId(sneakWeapon);
    }

    @Override
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon) {
        retrieveItemId(summonerWeapon);
    }

    private void retrieveItemId(Item item)
    {
        int itemId = item.getItemId();

        Element itemnode = doc.createElement("item");

        itemnode.setAttribute("item-id", Integer.toString(itemId));

        itemElement.appendChild(itemnode);
    }

    public Node retrieveSavedObject()
    {
        Node node = this.itemElement;

        this.itemElement = null;

        return node;
    }
}
