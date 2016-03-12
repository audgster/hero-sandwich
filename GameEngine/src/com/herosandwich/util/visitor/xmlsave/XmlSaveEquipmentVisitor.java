package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.equipment.Equipment;
import com.herosandwich.models.equipment.EquipmentSlots;
import com.herosandwich.models.items.takeableItems.equipableItems.EquipableItem;
import com.herosandwich.util.visitor.EquipmentVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class XmlSaveEquipmentVisitor implements EquipmentVisitor
{
    private Document doc;

    private Element equipmentNode = null;

    public XmlSaveEquipmentVisitor(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public void visitEquipment(Equipment equipment)
    {
        equipmentNode = doc.createElement("equipment");

        HashMap<EquipmentSlots, EquipableItem> equipmentHashMap = equipment.getEquipment();

        for (Map.Entry<EquipmentSlots, EquipableItem> e : equipmentHashMap.entrySet())
        {
            Element equipmentSlot = doc.createElement("equipmentslot");

            equipmentSlot.setAttribute("slot", e.getKey().toString().toLowerCase());
            equipmentSlot.setAttribute("itemId", Integer.toString(e.getValue().getItemId()));

            equipmentNode.appendChild(equipmentSlot);
        }
    }

    public Node retrieveSavedObject() {
        Node node = this.equipmentNode;

        this.equipmentNode = null;

        return node;
    }
}
