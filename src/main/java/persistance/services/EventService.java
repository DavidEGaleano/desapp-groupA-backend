package persistance.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Event;
import persistance.repositories.EventRepository;

public class EventService extends GenericService<Event>{
	private static final long serialVersionUID = -2932116622242535846L;
	
	EventRepository eventrepository;
	
	public EventRepository getEventrepository() {
		return eventrepository;
	}

	public void setEventrepository(EventRepository eventrepository) {
		this.eventrepository = eventrepository;
	}

	@Transactional
	public List<Event> getEconomicEvents(int limit){		
		return this.eventrepository.obtainEconomicEvents(limit);
	}
	
}

