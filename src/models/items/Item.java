package models.items;

import models.map.interactions.interfaces.IInteractionHandler;

public abstract class Item implements IInteractionHandler
{
    String name;

    public Item(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
