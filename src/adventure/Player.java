package adventure;

import java.util.*;

public class Player {

	private static String location_; //name of room player is in
	private static Map<String, Item> inventory_ = new HashMap<String, Item>(); //inventory of items
	private static int score_ = 0; //overall score

	public Player() {
		location_ = "Bright orange hallway"; // set to first room, however we
												// address it
	}


	public void move(String direction, HashMap<String, Room> rooms) {
		direction = direction.toLowerCase();
		Room current = rooms.get(location_);

		String[] temp = current.getNeighbors();

		if (direction.equals("north")) { //if direction is north...
			if (!temp[0].equals("-")) {//if there is a room in said direction
				location_ = temp[0];
			} else {
				System.out.println("Sorry, cannot go this way, try again!");
			}
		} else if (direction.equals("south")) {//if direction is south...
			if (!temp[1].equals("-")) {//if there is a room in said direction
				location_ = temp[1];
			} else {
				System.out.println("Sorry, cannot go this way, try again!");
			}
		} else if (direction.equals("east")) {//if direction is east...
			if (!temp[2].equals("-")) { //if there is a room in said direction
				location_ = temp[2];
			} else {
				System.out.println("Sorry, cannot go this way, try again!");
			}
		} else if (direction.equals("west")) {//if direction is west...
			if (!temp[3].equals("-")) {//if there is a room in said direction
				location_ = temp[3];
			} else {
				System.out.println("Sorry, cannot go this way, try again!");
			}
		} else { //else
			System.out.println("Sorry, not valid direction, try again!");
		}

	}
	
	public void add(String item, HashMap<String, Room> rooms) {
		// check whether object is in room you are in
		Room current = rooms.get(location_);

		Item temp = null;

		if (current.getInventory().containsKey(item)) { // item is in room
			temp = current.getInventory().get(item);

			current.getInventory().remove(item);
			inventory_.put(temp.getName(), temp);
			System.out.println(item + " was successfully added");
		} else { //else
			System.out.println("Sorry, " + item + " is not in the room.");
		}
	}


	public void drop(String item, HashMap<String, Room> rooms) {
		Item temp = null;

		if (inventory_.containsKey(item)) { //if item is in inventory
			temp = inventory_.get(item);
			inventory_.remove(item);

			Room current = rooms.get(location_);

			current.getInventory().put(temp.getName(), temp);
			System.out.println(item + " was successfully dropped");
		} else { // else
			System.out.println("Sorry, " + item + " is not in your inventory.");
		}
	}


	public String getLocation() {
		return location_;
	}


	public void getInventory() {
		if (inventory_.isEmpty()) { //if inventory is empty
			System.out.println("Inventory is empty");
		} else { //else
			for (Map.Entry<String, Item> elt : inventory_.entrySet()) {
				System.out.println(elt.getKey());
			}
		}
	}


	public void look(String item) {
		System.out.println(inventory_.get(item).getDescription());
	}


	public void look(HashMap<String, Room> rooms) {
		rooms.get(location_).look();
	}


	public int getScore() {
		return score_;
	}
	

	public void checkScores(HashMap<String, Score> scores, String ref) {
		if (scores.containsKey(ref)) { //if scores contains key
			score_ = score_ + scores.get(ref).getScore();
			scores.remove(ref);
		}
	}
	
}
