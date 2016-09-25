package model;

import java.util.ArrayList;
import java.util.List;

public class SaturdayNightFeverSearch extends SearchStrategy {
	
	public SaturdayNightFeverSearch(User user) {
		super(user);
	}

	@Override
	public ArrayList<Event> search() {
		//Abrir conexion con la base
		this.setKindTypes(this.user);
		//ArrayList<Event> events = bd.getEventsForTypesAllNight(typeMusic,typeFilm,typeFood);
		ArrayList<Event> events = new ArrayList<Event>();
		//cerrar conexion
		return events;
	}

}
