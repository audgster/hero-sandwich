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
        retreiveItemId(item);
    }

    @Override
    public void visitInteractableItem(InteractableItem ineractableItem) {
        retreiveItemId(ineractableItem);
    }

    @Override
    public void visitObstacleItem(ObstacleItem obstacleItem) {
        retreiveItemId(obstacleItem);
    }

    @Override
    public void visitOneShotItem(OneShotItem oneShotItem) {
        retreiveItemId(oneShotItem);
    }

    @Override
    public void visitTakeableItem(TakeableItem takeableItem) {
        retreiveItemId(takeableItem);
    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {
        retreiveItemId(consumableItem);
    }

    @Override
    public void visitEquipableItem(EquipableItem equipableItem) {
        retreiveItemId(equipableItem);
    }

    @Override
    public void visitSmasherWeapon(SmasherWeapon smasherWeapon) {
        retreiveItemId(smasherWeapon);
    }

    @Override
    public void visitSneakWeapon(SneakWeapon sneakWeapon) {
        retreiveItemId(sneakWeapon);
    }

    @Override
    public void visitSummonerWeapon(SummonerWeapon summonerWeapon) {
        retreiveItemId(summonerWeapon);
    }

    private void retreiveItemId(Item item)
    {
        int itemId = item.getItemId();

        Element itemnode = doc.createElement("item");

        itemnode.setAttribute("item-id", Integer.toString(itemId));

        itemElement.appendChild(itemnode);
    }

    public Node retreiveSavedObject()
    {
        Node node = this.itemElement;

        this.itemElement = null;

        return node;
    }
}
