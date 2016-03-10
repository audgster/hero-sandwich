package com.herosandwich.models.items;

import com.herosandwich.models.entity.Entity;

public abstract class Item{
    private String name;
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

    public void executeInteraction( Entity entity){}
}
