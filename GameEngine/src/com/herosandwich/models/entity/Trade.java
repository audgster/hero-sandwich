package com.herosandwich.models.entity;

import com.herosandwich.models.items.takeableItems.TakeableItem;

import java.util.*;

public class Trade
{
    HashMap<TakeableItem, Integer> itemsFromVendor;
    HashMap<TakeableItem, Integer> itemsFromBuyer;

    public Trade()
    {
        itemsFromVendor = new HashMap<>();
        itemsFromBuyer = new HashMap<>();
    }

    public boolean addItemFromVendor(TakeableItem item, int quantity)
    {
        if (item != null && quantity > 0)
        {
            int qty = quantity;
            if (itemsFromVendor.containsKey(item))
            {
                qty += itemsFromVendor.get(item);
                itemsFromVendor.replace(item, qty);
            }

            itemsFromVendor.put(item, qty);
            return true;
        }
        return false;
    }

    public boolean removeItemFromVendor(TakeableItem item, int quantity)
    {
        if (item != null && quantity > 0)
        {
            if (itemsFromVendor.containsKey(item))
            {
                int qty = quantity + itemsFromVendor.get(item);

                if (qty < 1)
                {
                    itemsFromVendor.remove(item);
                }
                else
                {
                    itemsFromVendor.replace(item, qty);
                }
            }

            return true;
        }
        return false;
    }

    public boolean addItemFromBuyer(TakeableItem item, int quantity)
    {
        if (item != null && quantity > 0)
        {
            int qty = quantity;
            if (itemsFromBuyer.containsKey(item))
            {
                qty += itemsFromBuyer.get(item);
                itemsFromBuyer.replace(item, qty);
                return true;
            }

            itemsFromBuyer.put(item, qty);
            return true;
        }
        return false;
    }

    public boolean removeItemFromBuyer(TakeableItem item, int quantity)
    {
        if (item != null && quantity > 0)
        {
            if (itemsFromBuyer.containsKey(item))
            {
                int qty = quantity + itemsFromBuyer.get(item);

                if (qty < 1)
                {
                    itemsFromBuyer.remove(item);
                }
                else
                {
                    itemsFromBuyer.replace(item, qty);
                }
            }

            return true;
        }

        return false;
    }

    public boolean validateTrade(HashMap<TakeableItem, Integer> fromBuyer)
    {
        // Not sure if this works
        if (itemsFromBuyer.equals(fromBuyer))
        {
            return true;
        }

        return false;
    }

    public static List<TakeableItem> convertFromMap(HashMap<TakeableItem, Integer> map)
    {
        List<TakeableItem> returnList = new ArrayList<>();

        for (Map.Entry<TakeableItem, Integer> e : map.entrySet())
        {
            int numberOfTimes = e.getValue();

            TakeableItem item = e.getKey();

            for (int i = 0; i < numberOfTimes; i++)
            {
                returnList.add(item);
            }
        }

        return returnList;
    }

    public HashMap<TakeableItem, Integer> getItemsFromVendor()
    {
        return itemsFromVendor;
    }
}
