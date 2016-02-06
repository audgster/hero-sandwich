package models.entities;

import models.items.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Equipment {
    /* ATTRIBUTES */
    private HashMap<EquipmentType, EquipableItem> equipment;

    /* METHODS */
    
    /* Constructor */
    public Equipment() {
	equipment = new HashMap();
	equipment.put(EquipmentType.HELM, null);
	equipment.put(EquipmentType.ARMOR, null);
	equipment.put(EquipmentType.LEGGINGS, null);
	equipment.put(EquipmentType.BOOTS, null);
	equipment.put(EquipmentType.WEAPON, null);	
    }
    
    /* Equip & Unequip */
    public boolean equip(EquipableItem item) {

	EquipmentType eType = item.getEquipmentType();
	boolean successful = true;

	// Check if item slot is already taken up
	if (equipment.get(eType) != null) {
	    return !successful;
	}

	equipment.put(eType, item);
	return successful;	
    }
    
    public void unequip(EquipableItem item){
	EquipmentType eType = item.getEquipmentType();
	equipment.put(eType, null);
    }

    /* Accessors */
    public EquipableItem getHelm() {
	return equipment.get(EquipmentType.HELM);
    }

    public EquipableItem getArmor() {
	return equipment.get(EquipmentType.ARMOR);
    }

    public EquipableItem getLeggings() {
	return equipment.get(EquipmentType.LEGGINGS);
    }

    public EquipableItem getBoots() {
	return equipment.get(EquipmentType.BOOTS);
    }

    public EquipableItem getWeapon() {
	return equipment.get(EquipmentType.WEAPON);
    }

    @Override
    public String toString() {	   
	StringBuilder strBuilder = new StringBuilder();
	strBuilder.append("[Equipment:\n");
	Set setOfETypes = equipment.keySet();
	Iterator<EquipmentType> iter = setOfETypes.iterator();
	
	while ( iter.hasNext() ) {
	    EquipmentType nextEquipment = iter.next();
	    strBuilder.append( nextEquipment.name() + " " );
	    
	    // If a slot is empty, append a String representing that; otherwise, use the Item in the slot's toString()
	    EquipableItem equipableItem = equipment.get(nextEquipment);
	    String equipableItemString = ( equipableItem == null ) ? ": --Empty--\n" : equipableItem.toString();
	    strBuilder.append(equipableItemString);
	}
	
	strBuilder.append("]");
	String str = strBuilder.toString();
	return str;
    }    
}
