package models.entities;

import models.items.*;
import models.items.actions.AddConstantHealthAction;

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
	bag = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; ++i) {
            bag.add(null);
			//bag.add(new EquipableItem("megaArmor" , EquipmentType.ARMOR, new StatModifiers())); /*new EquipableItem("megaArmor" , EquipmentType.ARMOR, new StatModifiers())*/ //new ConsumableItem("Potion", new AddConstantHealthAction(10))
		}
    }

    /* Parameterized Constructor */

    public Inventory(int n) {
	count = 0;
	capacity = n;
	bag = new ArrayList<>(capacity);
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

    public ArrayList<Item> getInventory() {
	return bag;
    }

    /* Mutators */
    /* Adds an item to the first available slot in the inventory
     * Returns false if the item could not be added (inventory is full)
     */
    public boolean add(Item item) {
	
	boolean itemAdded = false;
	
	for (int i = 0; i < capacity; ++i) {
	    // if slot is empty
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

  // Swaps the items at two indicies in the Inventory
  public void swap(int index1, int index2) {
    Item item1 = bag.get(index1);
    Item item2 = bag.get(index2);
    bag.set(index1, item2);
    bag.set(index2, item1);
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

	public List<String> getSaveState() {
		List<String> state = new ArrayList<String>();
		state.add("capacity: " + Integer.toString(capacity) + System.getProperty("line.separator") + " ");
		//state.add("count: " + Integer.toString(count) + System.getProperty("line.separator") + " ");
		state.add("bag {" + System.getProperty("line.separator") + " ");
		for(Item item : bag) {
			state.add(item.getClass().getSimpleName() + " {" + System.getProperty("line.separator") + " ");
			state.addAll(item.getSaveState());
			state.add("}" + System.getProperty("line.separator") + " ");
		}
		return state;
	}
}
