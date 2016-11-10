package webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import builders.EventBuilder;
import kind.Kind;
import model.Event;
import model.Profile;
import persistance.services.EventService;

@Path("/event")
public class WebServiceEventRest {

	public EventService eventService;

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService( EventService eventService) {
		this.eventService = eventService;
	}
	
	
	@GET
	@Path("/{address}")
	@Produces("application/json")
	public Event getProfile(@PathParam("address") String address){
		//Event event = new EventBuilder().withAddress(address).build();
		return null;
	}
	
	@GET
	@Path("/create/{address}")
	@Produces("application/json")
	public Event setProfile(@PathParam("address") String address){
		ArrayList<Event> suggestions = new ArrayList<Event>();
		suggestions.add(new EventBuilder().build());
		Event event = new EventBuilder().withAddress(address).withSuggestion(suggestions).build();
		this.getEventService().save(event);
		return this.getEventService().getById(event.id);
	}
	
	@GET
	@Path("/events")
	@Produces("application/json")
	public List<Event> events() {

		return this.getEventService().retriveAll();

	}

	@DELETE
	@Path("/deleteevent/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Event toDelete = this.getEventService().getById(id);
			this.getEventService().delete(toDelete);
		} catch (Exception e) {
			return "Id not found";
		}
		return "Delete Ok";
	}
	
	@GET
	@Path("/getEvent/{id}")
	@Produces("application/json")
	public Event getEvent(@PathParam("id") final Integer id) {
		return this.getEventService().getById(id);
	}
	

}

