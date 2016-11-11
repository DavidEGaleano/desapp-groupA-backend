package model;

import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class EconomicSearch extends SearchStrategy {

	public EconomicSearch(User user, UserService userservice,EventService eventservice) {
		super(user,userservice,eventservice);
	}

	@Override
	public List<Event> search() {
		if(this.user != null){
			int limit = this.user.getLimitAmount();
			List<Event> events = this.eventservice.getEconomicEvents(limit);
			return events;
		}
		return null;
	}

}
