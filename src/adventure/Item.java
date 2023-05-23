package adventure;


public class Item {
	private String name_; //name of item
	private String description_; //short description
	private String location_; //name of room item starts in

	public Item (String name, String descrip, String location) {
		name_ = name;
		description_ = descrip;
		location_ = location;
	}
	

	public void look() {
		System.out.println(description_);
	}


	public String getName () {
		return name_;
	}
	

	public String getLocation () {
		return location_;
	}

	public String getDescription () {
		return description_;
	}
}
