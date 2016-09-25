package model;

import java.util.ArrayList;

public class SurpriseMeSearch extends SearchStrategy {

	public SurpriseMeSearch(User user) {
		super(user);
	}

	@Override
	public ArrayList<Event> search() {
		return new ArrayList<Event>();
	}

}
