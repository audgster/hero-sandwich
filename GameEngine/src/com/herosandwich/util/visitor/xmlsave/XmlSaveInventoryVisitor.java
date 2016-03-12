package com.herosandwich.util.visitor.xmlsave;

import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.Item;
import com.herosandwich.util.visitor.InventoryVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlSaveInventoryVisitor implements InventoryVisitor
{
    private Document doc;
    private Element inventory = null;

    public XmlSaveInventoryVisitor(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public void visitInventory(Inventory inventory)
    {
        this.inventory = doc.createElement("inventory");

        XmlSaveItemVisitor visitor = new XmlSaveItemVisitor(doc);

        inventory.acceptItemVisitor(visitor);

        this.inventory.appendChild(visitor.retreiveSavedObject());
    }

    public Node retrieveSavedObject()
    {
        Node node = this.inventory;

        this.inventory = null;

        return node;
    }
}
