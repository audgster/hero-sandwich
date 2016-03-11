package com.herosandwich.models.entity;

import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.util.visitor.EntityVisitor;

import java.util.HashMap;
import java.util.List;

public class Npc extends Character
{
    private Attitude attitudeTowardsPlayer;
    private Trade trade;

    private String[] thingsToSay;
    private HashMap<Character, Integer> conversations;

    public Npc()
    {
        attitudeTowardsPlayer = Attitude.NEUTRAL;
        trade = new Trade();

        thingsToSay = new String[5];
        conversations = new HashMap<>();
    }

    /*
    * Attitude towards Player
    * */
    public void setAttitudeTowardsPlayer(Attitude attitude)
    {
        attitudeTowardsPlayer = attitude;
    }

    public void changeAttitude(boolean increment)
    {
        if (increment)
        {
            switch (attitudeTowardsPlayer)
            {
                case VERY_HOSTILE:
                    attitudeTowardsPlayer = Attitude.HOSTILE;
                    break;
                case HOSTILE:
                    attitudeTowardsPlayer = Attitude.NEUTRAL;
                    break;
                case NEUTRAL:
                    attitudeTowardsPlayer = Attitude.FRIENDLY;
                    break;
                case FRIENDLY:
                    attitudeTowardsPlayer = Attitude.VERY_FRIENDLY;
                    break;
                case VERY_FRIENDLY:
                    attitudeTowardsPlayer = Attitude.VERY_FRIENDLY;
                    break;
            }
        }
        else
        {
            switch (attitudeTowardsPlayer)
            {
                case VERY_FRIENDLY:
                    attitudeTowardsPlayer = Attitude.FRIENDLY;
                    break;
                case FRIENDLY:
                    attitudeTowardsPlayer = Attitude.NEUTRAL;
                    break;
                case NEUTRAL:
                    attitudeTowardsPlayer = Attitude.HOSTILE;
                    break;
                case HOSTILE:
                    attitudeTowardsPlayer = Attitude.VERY_HOSTILE;
                    break;
                case VERY_HOSTILE:
                    attitudeTowardsPlayer = Attitude.VERY_HOSTILE;
                    break;
            }
        }
    }

    /*
    * Trading
    * */
    public List<TakeableItem> trade(HashMap<TakeableItem, Integer> itemsFromBuyer)
    {
        if (trade.validateTrade(itemsFromBuyer))
        {
            return Trade.convertFromMap(trade.getItemsFromVendor());
        }

        return Trade.convertFromMap(itemsFromBuyer);
    }

    /*
    * Talking
    * */
    public String talk(Character c)
    {
        if (conversations.containsKey(c))
        {
            int thingToSayIndex = conversations.get(c);

            int nextThingToSay = (thingToSayIndex + 1) > thingsToSay.length ? 0 : thingToSayIndex + 1;

            conversations.replace(c, nextThingToSay);

            return thingsToSay[thingToSayIndex];
        }
        else
        {
            conversations.put(c, 1);
            return thingsToSay[0];
        }
    }

    public void updateThingsToSay(String[] thingsToSay)
    {
        this.thingsToSay = thingsToSay;

        conversations.clear();
    }

    /*
    * Attacking
    * */

    // Hook for visitor
    public void accept(EntityVisitor eVisitor)
    {
        eVisitor.visitNpc(this);
    }
}
