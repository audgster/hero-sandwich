package com.herosandwich.models.entity;

import com.herosandwich.models.items.takeableItems.TakeableItem;
import com.herosandwich.util.visitor.EntityVisitor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        super();
        attitudeTowardsPlayer = Attitude.NEUTRAL;
        trade = null;

        thingsToSay = new String[5];
        conversations = new HashMap<>();
    }

    public Npc(Character character, Attitude attitude, Trade trade, String[] thgs2say)
    {
        super(character);

        this.attitudeTowardsPlayer = attitude;
        this.trade = trade;
        this.thingsToSay = thgs2say;

        conversations = new HashMap<>();
    }

    public Npc(Npc npc)
    {
        super(npc);
        this.attitudeTowardsPlayer = npc.getAttitudeTowardsPlayer();
        this.conversations = npc.getConversations();
        this.thingsToSay = npc.getThingsToSay();
        this.trade = npc.getTrade();
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
    public TakeableItem trade(int currency)
    {
        return trade.executeTrade(currency);
    }

    private Trade getTrade()
    {
        return this.trade;
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

    private String[] getThingsToSay()
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
