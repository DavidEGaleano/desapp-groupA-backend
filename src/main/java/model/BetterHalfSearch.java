package model;

import java.util.ArrayList;

public class BetterHalfSearch extends SearchStrategy {

	public BetterHalfSearch(User user) {
		super(user);
	}

	@Override
	public ArrayList<Event> search() {
		//esta busqueda va a necesitar especificar a la pareja en el usuario (discutir);
		return new ArrayList<Event>();
	}

}
