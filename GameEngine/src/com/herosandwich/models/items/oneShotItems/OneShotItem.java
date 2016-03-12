package com.herosandwich.models.items.oneShotItems;

import com.herosandwich.models.items.Item;
import com.herosandwich.util.visitor.ItemVisitor;

/**
 * Created by matthewdiaz on 3/9/16.
 */
public class OneShotItem extends Item{
    public OneShotItem(String name, int itemId){
        super(name, itemId);
    }

    public void accept(ItemVisitor visitor){
        visitor.visitOneShotItem(this);
    }
}
