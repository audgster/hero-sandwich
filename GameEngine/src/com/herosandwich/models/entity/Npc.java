package com.herosandwich.models.entity;

import com.herosandwich.models.items.takeableItems.TakeableItem;

import java.util.HashMap;
import java.util.List;

public class Npc extends Character
{
    private Attitude attitudeTowardsPlayer;
    private Trade trade;

    public Npc()
    {
        attitudeTowardsPlayer = Attitude.NEUTRAL;
        trade = new Trade();
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

    public List<TakeableItem> trade(HashMap<TakeableItem, Integer> itemsFromBuyer)
    {
        if (trade.validateTrade(itemsFromBuyer))
        {
            return Trade.convertFromMap(trade.getItemsFromVendor());
        }

        return Trade.convertFromMap(itemsFromBuyer);
    }

    // Talk

    // Attack?
}
