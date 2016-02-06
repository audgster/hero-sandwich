package models.entities;

import models.items.*;

public class Equipment {
    /* ATTRIBUTES */
    private HashMap<EquipmentType, EquipableItem> equipment;

    /* METHODS */
    
    /* Constructor */
    public Equipment() {
	equipment = new Hashmap();
	equipment.put(HELM, null);
	equipment.put(ARMOR, null);
	equipment.put(LEGGINGS, null);
	equipment.put(BOOTS, null);
	equipment.put(WEAPON, null);	
    }
    
    /* Accessors */
    public boolean equip(EquipableItem item) {
	return false;
    }
    
    public boolean unequip(EquipableItem item){
	return false;
    }

    public EquipableItem getHead() {
	return head;
    }

    public EquipableItem getChest() {
	return chest;
    }

    public EquipableItem getLegs() {
	return legs;
    }

    public EquipableItem getFeet() {
	return feet;
    }

    public EquipableItem getHands() {
	return hands;
    }
}
