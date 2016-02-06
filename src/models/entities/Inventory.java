package models.entities;

import models.items.*;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private List<Item> bag;
    private int capacity; // the maximum size of the Inventory
    private int count; // the number of items currently in the Inventory

    /* Default Constructor */

    public Inventory() {
	count = 0;
	capacity = 5;
	bag = new ArrayList(capacity);
	for (int i = 0; i < capacity; ++i) { bag.add(null); }
    }

    /* Parameterized Constructor */

    public Inventory(int n) {
	count = 0;
	capacity = n;
	bag = new ArrayList(capacity);
	for (int i = 0; i < capacity; ++i) { bag.add(null); }	
    }

    public boolean isFull() {
	if (count == capacity) {
	    return true;
	}
	return false;	  
    }

    /* Accessors */

    public Item getItemAt(int slot) {
	return bag.get(slot);
    }

    /* Mutators */
    /* Adds an item to the first available slot in the inventory
     * Returns false if the item could not be added (inventory is full)
     */
    public boolean add(Item item) {
	
	boolean itemAdded = false;
	
	for (int i = 0; i < capacity; ++i) {
	    // if slot is empty
	    System.out.println("Bag size: " + bag.size() );
	    if ( bag.get(i) == null ) {		
		bag.add(i, item);
		itemAdded = true;
		++count;
		break;
	    }
	    System.out.println(bag.get(i));
	}
	return itemAdded;
    }

    // Removes the Item at the indicated slot
    // Empty slots are null, so it will return null if the slot is empty
    public Item remove(int slot) {
	Item toBeRemoved = bag.get(slot);
	bag.set(slot, null);
	--count;
	return toBeRemoved;
    }

    // Removes the passed in Item
    // Returns false if the Item was not found
    public boolean remove(Item item) {
	boolean removed = false;
	int index = bag.indexOf(item);
	
	// if Item is not found
	if (index == -1) {
	    return !removed;
	}

	bag.set(index, null);
	--count;
	return removed;
    }    

    @Override
    public String toString() {
	StringBuilder strBuilder = new StringBuilder();
	strBuilder.append("[Inventory:");
	for (int i = 0; i < capacity; ++i) {
	    int rowLength = 5;
	    Item currentSlot = getItemAt(i);
	    if (currentSlot == null) {
		strBuilder.append("| --Empty-- |");
	    } else {
		strBuilder.append("| " + currentSlot.toString() + " |");
	    }
	}
	strBuilder.append("]");
	String str = strBuilder.toString();
	return str;
    }
}
