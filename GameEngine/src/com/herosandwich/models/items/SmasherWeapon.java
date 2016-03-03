package com.herosandwich.models.items;

public abstract class SmasherWeapon extends EquipableItem{
  public SmasherWeapon(String name){
    super(name);
  }

  public boolean isPickable(){
    return true;
  }
}
