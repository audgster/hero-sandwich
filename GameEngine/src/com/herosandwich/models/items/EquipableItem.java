package com.herosandwich.models.items;

public abstract class EquipableItem extends TakeableItem{
  public EquipableItem(String name){
    super(name);
  }

  public void equipToEntity(){
    //equips this item to Entity
  }
}
