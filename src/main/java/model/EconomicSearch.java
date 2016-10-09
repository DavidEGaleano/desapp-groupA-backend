package model;

import java.util.ArrayList;

public class EconomicSearch extends SearchStrategy {

	public EconomicSearch(User user) {
		super(user);
	}

	@Override
	public ArrayList<Event> search() {
		//Abrir conexion con la base
		//int limit = this.user.getProfile().getLimitAmount();
		//ArrayList<Event> events = bd.getEconomicEvents(limit);
		//cerrar conexion
		//return events
		return null;
	}

}
