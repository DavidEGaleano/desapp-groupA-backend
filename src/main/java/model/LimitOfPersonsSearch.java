package model;

import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class LimitOfPersonsSearch extends SearchStrategy {

	public LimitOfPersonsSearch(User user, UserService userservice, EventService eventservice) {
		super(user,userservice,eventservice);
	}

	@Override
	public List<Event> search() {
		List<Event> events = this.eventservice.obtainEventsWithLimitOfPersons(this.getLimitofpersons());
		return events;
	}

}
