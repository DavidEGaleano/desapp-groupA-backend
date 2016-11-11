package model;

import java.util.ArrayList;
import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class WithFriendSearch extends SearchStrategy {
	
	public WithFriendSearch(User user, UserService userservice, EventService eventservice) {
		super(user,userservice,eventservice);
	}
	
	@Override
	public List<Event> search() {
		//Abrir conexion con la base
		List<User> friends = this.user.getFriends();
		//ArrayList<Event> events = bd.getEventsForTypes(user.getProfile().getTypeOfMusic(),user.getProfile().gettypeFilm(),user.getProfile().getTypeFood());
		ArrayList<Event> events = this.userEventPreferences(this.user, this.events);
		//cerrar conexion
		if(friends.size()>0){
			for(int i=0;i < friends.size();i++){
				events = this.userEventPreferences(friends.get(i), events);
			}
		}
		return events;
	}

}
