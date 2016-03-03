package com.herosandwich.models.items;

public abstract class TakeableItem extends Item{
  public TakeableItem(String name){
      super(name);
  }

  public void getPickedUp(){
      // Item gets picked and added to inventory
      // when Entity walks over it
  }

}
