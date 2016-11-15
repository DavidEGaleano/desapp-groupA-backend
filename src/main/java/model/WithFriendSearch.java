package model;

import java.util.ArrayList;
import java.util.List;

import kind.Kind;
import persistance.services.EventService;
import persistance.services.UserService;

public class WithFriendSearch extends SearchStrategy {
	
	public WithFriendSearch(User user, UserService userservice, EventService eventservice) {
		super(user,userservice,eventservice);
	}
	
	@Override
	public List<Event> search() {
	
		List<User> friends = this.user.getFriends();
		List<Kind> kinds = new ArrayList<Kind>();
		kinds.add(user.getProfile().getTypeOfMusic());
		kinds.add(user.getProfile().getTypeOfFilm());
		kinds.add(user.getProfile().getTypeOfFood());
		List<Event> bdevents = this.eventservice.retriveAll();
		this.events = (ArrayList<Event>)bdevents;
		ArrayList<Event> events = this.userEventPreferences(this.user, this.events);
		if(friends.size()>0){
			for(int i=0;i < friends.size();i++){
				events = this.userEventPreferences(friends.get(i), events);
			}
		}
		return events;
	}

}
