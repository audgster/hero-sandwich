package com.herosandwich.models.items;

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
}
