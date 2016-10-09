package model;

import java.util.ArrayList;

public class SaturdayNightFeverSearch extends SearchStrategy {
	
	public SaturdayNightFeverSearch(User user) {
		super(user);
	}

	@Override
	public ArrayList<Event> search() {
		//Abrir conexion con la base
		//ArrayList<Event> events = bd.getEventsForTypesAllNight(typeMusic,typeFilm,typeFood);
		ArrayList<Event> events = new ArrayList<Event>();
		//cerrar conexion
		return events;
	}

}
