package model;

import java.util.ArrayList;

public class BetterHalfSearch extends SearchStrategy {

	public BetterHalfSearch(User user) {
		super(user);
	}

	@Override
	public ArrayList<Event> search() {
		//Abrir conexion con la base
		//ArrayList<Event> events = bd.getEventsForTypes(typeMusic,typeFilm,typeFood);
		ArrayList<Event> events = this.userEventPreferences(this.user, this.events);
		//cerrar conexion
		events = this.userEventPreferences(this.user.getCouple(), events);
		return events;
	}

}
