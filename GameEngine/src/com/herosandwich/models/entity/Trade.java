package com.herosandwich.models.entity;

import com.herosandwich.creation.init.ItemInit;
import com.herosandwich.models.items.takeableItems.TakeableItem;

import java.util.*;

public class Trade
{
    int itemId;
    int price;

    public Trade(int itemId, int price)
    {
        this.itemId = itemId;
        this.price = price;
    }

    public TakeableItem executeTrade(int currency)
    {
        if (currency >= price) {
            ItemInit itemLookup = ItemInit.getInstance();
            return itemLookup.getTakeableItem(itemId);
        }

        return null;
    }

}
