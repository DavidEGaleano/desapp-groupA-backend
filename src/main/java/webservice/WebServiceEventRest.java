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
			this.eventService.save(event);
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
		return this.eventService.retriveAll();
	}

	@GET
	@Path("/delete/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Event event = this.getEventService().getById(id);
			this.eventService.delete(event);
		} catch (Exception e) {
			return "{Error: Can't delete Event or invalid ID ,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Event Deleted"+","
		+"ID:"+id+","
		+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/update/address/{event_id}/{address}")
	@Produces("application/json")
	public String updateAddress(@PathParam("event_id") final Integer id, @PathParam("address") final String address){
		try{
			Event event = this.getEventService().getById(id);
			event.setAddress(address);
			this.eventService.update(event);
		}catch (Exception e){
			return "{Error: Can't update user address or invalid ID,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Event address changed"+","
		+"ID:"+id+","
		+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/update/limitofpersons/{event_id}/{limit}")
	@Produces("application/json")
	public String updateLimitOfPersons(@PathParam("event_id") final Integer id, @PathParam("limit") final Integer limit){
		try{
			Event event = this.getEventService().getById(id);
			event.setLimitOfPersons(limit);
			this.eventService.update(event);
		}catch (Exception e){
			return "{Error: Can't update event limit of persons or invalid ID,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Event limit of persons changed"+","
		+"ID:"+id+","
		+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/update/amount/{event_id}/{amount}")
	@Produces("application/json")
	public String updateAmount(@PathParam("event_id") final Integer id, @PathParam("amount") final Integer amount){
		try{
			Event event = this.getEventService().getById(id);
			event.setAmount(amount);
			this.eventService.update(event);
		}catch (Exception e){
			return "{Error: Can't update event amount or invalid ID,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Event amount changed"+","
		+"ID:"+id+","
		+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/getEvent/{id}")
	@Produces("application/json")
	public Event getEvent(@PathParam("id") final Integer id) {
		try {
			return this.eventService.getById(id);
		} catch (Exception e) {
			return null;
		}
	}
	

}

