package model;

import java.util.ArrayList;
import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class SurpriseMeSearch extends SearchStrategy {

	public SurpriseMeSearch(User user, UserService userservice, EventService eventservice) {
		super(user,userservice,eventservice);
	}

	@Override
	public List<Event> search() {
		return new ArrayList<Event>();
	}

}
