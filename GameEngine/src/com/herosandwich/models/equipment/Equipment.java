package com.herosandwich.models.equipment;

import com.herosandwich.models.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewdiaz on 3/4/16.
 */
public class Equipment {
    private List<Item> equipment;

    public Equipment(){
        equipment = new ArrayList();
    }

    public void insertItem(Item item){
        equipment.add(item);
    }

    public boolean removeItem(Item item){
        return  equipment.remove(item);
    }

    public List<Item> getInventory(){
        return  equipment;
    }
}
