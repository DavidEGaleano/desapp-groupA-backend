package model;

import java.util.ArrayList;
import java.util.List;

import kind.Kind;

public class WithFriendSearch extends SearchStrategy {
	
	public WithFriendSearch(User user) {
		super(user);
	}
	
	@Override
	public ArrayList<Event> search() {
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
