package com.herosandwich.models.items;

public class ConsumableItem extends TakeableItem{
  public ConsumableItem(String name){
    super(name);
  }

  public void consume(){
    //consume an item when avatar chooses it from inventory
  }
}
