package com.herosandwich.models.items;

import com.herosandwich.util.visitor.ItemVisitor;

public abstract class Item{
    protected String name;
    private int itemId;

    public Item(String name, int itemId)
    {
        this.name = name;
        this.itemId = itemId;
    }

    public String getName()
    {
        return name;
    }

    public int getItemId()
    {
        return itemId;
    }

    public void accept(ItemVisitor visitor){
        visitor.visitItem(this);
    }
}
