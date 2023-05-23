package adventure;


public class Score {
	private String action_; //type of action (drop, take, visit)
	private String item_; //name of item involved (if there is one)
	private String place_; //name of room action takes place in
	private int score_; //score from completing goal


	public Score(String action, String item, String place, int score) {
		action_ = action;
		item_ = item;
		place_ = place;
		score_ = score;
	}


	public int getScore() {
		return score_;
	}


	public String getAction() {
		return action_;
	}


	public String getItem() {
		return item_;
	}


	public String getPlace() {
		return place_;
	}
}
