package com.herosandwich.models.items.obstacleItems;

import com.herosandwich.models.items.Item;
import com.herosandwich.util.visitor.ItemVisitor;

/**
 * Created by matthewdiaz on 3/9/16.
 */
public class ObstacleItem extends Item{
    public ObstacleItem(String name, int itemId){
        super(name, itemId);
    }

    public void accept(ItemVisitor visitor){
        visitor.visitObstacleItem(this);
    }
}
