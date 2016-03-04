package com.herosandwich.models.items;

import com.herosandwich.models.*;
import com.herosandwich.models.entity.Entity;

public abstract class Item{
  protected String name;

  public Item(String name){
      this.name = name;
  }

  public String getName(){
    return name;
  };

  public void executeInteraction( Entity entity){}
}
