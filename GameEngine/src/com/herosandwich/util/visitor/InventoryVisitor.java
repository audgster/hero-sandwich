package com.herosandwich.util.visitor;

import com.herosandwich.models.inventory.Inventory;

public interface InventoryVisitor
{
    void visit(Inventory inventory);
}
