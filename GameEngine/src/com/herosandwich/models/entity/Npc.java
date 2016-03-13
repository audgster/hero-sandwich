package com.herosandwich.models.entity;

import com.herosandwich.creation.init.ItemInit;
import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.util.visitor.EntityVisitor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.List;

public class Npc extends Character
{
    private Attitude attitudeTowardsPlayer;
    private HashMap<Integer, Integer> sell;
    private HashMap<Integer, Integer> buy;

    private String[] thingsToSay;
    private HashMap<Character, Integer> conversations;

    public Npc()
    {
        super();
        attitudeTowardsPlayer = Attitude.NEUTRAL;
        sell = new HashMap<>();
        buy = new HashMap<>();

        thingsToSay = new String[5];
        conversations = new HashMap<>();
    }

    public Npc(Character character, Attitude attitude, HashMap<Integer, Integer> sell, HashMap<Integer, Integer> buy, String[] thgs2say)
    {
        super(character);

        this.attitudeTowardsPlayer = attitude;
        this.sell = sell;
        this.buy = buy;
        this.thingsToSay = thgs2say;

        conversations = new HashMap<>();
    }

    public Npc(Npc npc)
    {
        super(npc);
        this.attitudeTowardsPlayer = npc.getAttitudeTowardsPlayer();
        this.conversations = npc.getConversations();
        this.thingsToSay = npc.getThingsToSay();
        this.sell = npc.getSell();
        this.buy = npc.getBuy();
    }

    /*
    * Attitude towards Player
    * */
    public Attitude getAttitudeTowardsPlayer()
    {
        return attitudeTowardsPlayer != null ? attitudeTowardsPlayer : Attitude.NEUTRAL;
    }

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
    public TakeableItem sell(int itemId, int currency)
    {
        if (!sell.containsKey(itemId))
            return null;

        int price =  sell.get(itemId);

        if (currency == price)
        {
            ItemInit init = ItemInit.getInstance();

            modifyCurrency(currency);

            return init.getTakeableItem(itemId);
        }

        return null;
    }

    public int buy(int itemId)
    {
        if (!buy.containsKey(itemId))
            return -1;

        int price = buy.get(itemId);

        if (getCurrency() >= price)
        {
            modifyCurrency(-(price));
            return price;
        }

        return -1;
    }

    public HashMap<Integer, Integer> getSell()
    {
        return this.sell;
    }

    public HashMap<Integer, Integer> getBuy()
    {
        return this.buy;
    }

    public void addOrReplaceSale(int itemId, int price)
    {
        if (price < 1)
            throw new IllegalArgumentException("Price of a trade can't be negative");

        if (sell.containsKey(itemId))
        {
            sell.replace(itemId, price);
        }
        else
        {
            sell.put(itemId, price);
        }
    }

    public void removeSale(int itemId)
    {
        sell.remove(itemId);
    }

    public void addOrReplaceBuy(int itemId, int price)
    {
        if (price < 1)
            throw new IllegalArgumentException("Price of a trade can't be negative");

        if (buy.containsKey(itemId))
        {
            buy.replace(itemId, price);
        }
        else
        {
            buy.put(itemId, price);
        }
    }

    public void removeBuy(int itemId)
    {
        buy.remove(itemId);
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

    private HashMap<Character, Integer> getConversations()
    {
        return this.conversations;
    }

    public String[] getThingsToSay()
    {
        return this.thingsToSay;
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
