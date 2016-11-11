package model;

import java.util.ArrayList;
import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class SaturdayNightFeverSearch extends SearchStrategy {
	
	public SaturdayNightFeverSearch(User user, UserService userservice, EventService eventservice) {
		super(user,userservice,eventservice);
	}

	@Override
	public List<Event> search() {
		//Abrir conexion con la base
		//ArrayList<Event> events = bd.getEventsForTypesAllNight(typeMusic,typeFilm,typeFood);
		ArrayList<Event> events = new ArrayList<Event>();
		//cerrar conexion
		return events;
	}

}
