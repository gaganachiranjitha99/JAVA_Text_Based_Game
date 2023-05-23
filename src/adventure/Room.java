package adventure;

import java.util.*;

public class Room {
	private String name_; //name of room
	private String[] neighbors_; //names of neighboring rooms
	private String description_; //short description
	private HashMap<String, Item> items_ = new HashMap<String, Item>(); //inventory of item in room


	public Room(String name, String description, String[] neighbors, HashMap<String, Item> items) {
		name_ = name;
		description_ = description;
		neighbors_ = neighbors;
		
		setItems(items);
	}


	public void setItems(HashMap<String, Item> items) {
		for (Map.Entry<String, Item> elt : items.entrySet()) { //iterate through collection
			//if items location matches rooms name...
			if (elt.getValue().getLocation().equals(name_)) {
				//...put item in room
				items_.put(elt.getKey(), elt.getValue());
			}
		}
	}


	public void look() {
		System.out.println(description_);

		System.out.println("Can exit to the ");
		// traverse neighbors array
		if (!neighbors_[0].equals("-")) { // if there is spot to north
			System.out.print("NORTH, ");
		}

		if (!neighbors_[1].equals("-")) { // if there is spot to south
			System.out.print("SOUTH, ");
		}

		if (!neighbors_[2].equals("-")) { // if there is spot to east
			System.out.print("EAST, ");
		}

		if (!neighbors_[3].equals("-")) { // if there is spot to west
			System.out.print("WEST, ");
		}

		System.out.println();
		System.out.println();

		if (items_.isEmpty()) { // if collection of items in room is empty
			System.out.println("No items in room, sorry.");
		} else { // else, items in room, print them out
			for (Map.Entry<String, Item> elt : items_.entrySet()) { // iterate										
				System.out.print(elt.getKey() + ", ");
			}
			System.out.println(" are in the room.");
		}

	}


	public String[] getNeighbors() {
		return neighbors_;
	}


	public String getName() {
		return name_;
	}


	public HashMap<String, Item> getInventory() {
		return items_;
	}


	public String getDescription() {
		return description_;
	}
		
}
