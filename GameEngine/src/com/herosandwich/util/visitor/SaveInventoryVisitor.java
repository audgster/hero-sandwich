package com.herosandwich.util.visitor;

import com.herosandwich.models.inventory.Inventory;
import com.herosandwich.models.items.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SaveInventoryVisitor implements InventoryVisitor
{
    private Document doc;
    private Element inventory = null;

    public SaveInventoryVisitor(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public void visitInventory(Inventory inventory)
    {
        this.inventory = doc.createElement("inventory");

        for (Item i : inventory.getInventory())
        {
            Element item = doc.createElement("item");
            item.setAttribute("itemId", Integer.toString(i.getItemId()));

            this.inventory.appendChild(item);
        }
    }

    public Node retrieveSavedObject()
    {
        Node node = this.inventory;

        this.inventory = null;

        return node;
    }
}
