package webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import builders.EventBuilder;
import model.Event;
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
	@Path("/create")
	@Produces("application/json")
	public String setProfile(@PathParam("address") String address){
		Event event = new EventBuilder().build();
		try {
			this.getEventService().save(event);
		}catch(Exception e){
			return "{Error: Can't create Event,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Event Created"+","
				+"ID:"+ event.id+","
				+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/events")
	@Produces("application/json")
	public List<Event> events() {
		return this.getEventService().retriveAll();
	}

	@GET
	@Path("/delete/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Event toDelete = this.getEventService().getById(id);
			this.getEventService().delete(toDelete);
		} catch (Exception e) {
			return "{Error: Can't delete Event or invalid ID ,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Event Deleted"+","
		+"ID:"+id+","
		+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/getEvent/{id}")
	@Produces("application/json")
	public Event getEvent(@PathParam("id") final Integer id) {
		try {
			return this.getEventService().getById(id);
		} catch (Exception e) {
			return null;
		}
	}
	

}

