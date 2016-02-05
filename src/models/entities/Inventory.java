package models.entities;

import models.Items.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> bag;
    private int capacity;

    /* Default Constructor */

    public Inventory() {
	capacity = 5;
	bag = new ArrayList(capacity);
	bag.trimToSize();
    }

    /* Parameterized Constructor */

    public Inventory(int n) {
	capacity = n;
	bag = new ArrayList(capacity);
	bag.trimToSize();
    }

    public boolean isFull() {
	return false;
    }

    /* Accessors */
    
    public Item getItemAt(int slot) {
	return bag.get(slot);
    }

    /* Mutators */
    // Adds an item to the end of the bag
    public boolean add(Item item) {
	return false;
    }

    @Override
    public String toString() {
	StringBuilder strBuilder = new StringBuilder();
	strBuilder.append("[Inventory:");
	for (int i = 0; i < capacity; ++i) {
	    int rowLength = 5;
	    Item currentSlot = getItemAt(i);
	    if (currentSlot == null) {
		strBuilder.append("| -- Empty Slot -- |");
	    } else {
		strBuilder.append("| -- " + currentSlot.toString() + " -- |");
	    }
	    // create new row 
	    if (i % rowLength == 0 && i != capacity - 1) strBuilder.append("\n");	    
	}
	strBuilder.append("]");
	String str = strBuilder.toString();
	return str;
    }
}
