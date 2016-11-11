package model;

import java.util.ArrayList;
import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class BetterHalfSearch extends SearchStrategy {

	public BetterHalfSearch(User user, UserService userservice, EventService eventservice) {
		super(user,userservice,eventservice);
	}

	@Override
	public List<Event> search() {
		//Abrir conexion con la base
		//ArrayList<Event> events = bd.getEventsForTypes(typeMusic,typeFilm,typeFood);
		ArrayList<Event> events = this.userEventPreferences(this.user, this.events);
		//cerrar conexion
		events = this.userEventPreferences(this.user.getCouple(), events);
		return events;
	}

}
