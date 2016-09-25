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
		this.setKindTypes(this.user);
		//ArrayList<Event> events = bd.getEventsForTypes(typeMusic,typeFilm,typeFood);
		ArrayList<Event> events = new ArrayList<Event>();
		//cerrar conexion
		if(friends.size()>0){
			for(int i=0;i < friends.size();i++){
				events = this.friendEventPreferences(friends.get(i), events);
			}
		}
		return events;
	}
	
	private ArrayList<Event> friendEventPreferences(User user, ArrayList<Event> pEvents){
		ArrayList<Event> events = new ArrayList<Event>();
		this.setKindTypes(user);
		for(int i=0;i < pEvents.size();i++){
			Event event = pEvents.get(i);
			if(this.matchAllTypes(event)){
				events.add(event);
			}
		}
		return events;
	}
	
	private boolean matchAllTypes(Event event){
		List<Kind> types = event.getTypes();
		return (types.contains(typeMusic) && types.contains(typeFilm) && types.contains(typeFood));
	}

}
