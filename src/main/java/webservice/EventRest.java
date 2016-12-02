package webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import builders.EventBuilder;
import model.Event;
import persistance.services.EventService;
import utils.ResponseGenerator;

@Path("/event")
public class EventRest extends ResponseGenerator{

	public EventService eventService;

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService( EventService eventService) {
		this.eventService = eventService;
	}
	
	
	@PUT
	@Path("/create")
	@Produces("application/json")
	public Response setProfile(){
		Event event = new EventBuilder().build();
		try {
			this.eventService.save(event);
		}catch(Exception e){
			return responseBadRequest("{Error: Can't create Event,"
										+ "Status: FAIL}");
		}
		return responseOK("{Action:"+"Event Created"+","
						  +"ID:"+ event.id+","
						  +"Status"+": "+"OK"+"}");
	}
	
	@GET
	@Path("/events")
	@Produces("application/json")
	public List<Event> events() {
		return this.eventService.retriveAll();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public Response deleteProfile(@PathParam("id") final Integer id) {

		try {
			Event event = this.getEventService().getById(id);
			this.eventService.delete(event);
		} catch (Exception e) {
			return responseBadRequest("{Error: Can't delete Event or invalid ID ,"
					+ "Status: FAIL}");
		}
		return responseOK("{Action:"+"Event Deleted"+","
						  +"ID:"+id+","
						  +"Status"+": "+"OK"+"}");
	}
	
	@PUT
	@Path("/update/address/{event_id}/{address}")
	@Produces("application/json")
	public Response updateAddress(@PathParam("event_id") final Integer id, @PathParam("address") final String address){
		try{
			Event event = this.getEventService().getById(id);
			event.setAddress(address);
			this.eventService.update(event);
		}catch (Exception e){
			return responseBadRequest("{Error: Can't update user address or invalid ID,"
					+ "Status: FAIL}");
		}
		return responseOK("{Action:"+"Event address changed"+","
						  +"ID:"+id+","
						  +"Status"+": "+"OK"+"}");
	}
	
	@PUT
	@Path("/update/limitofpersons/{event_id}/{limit}")
	@Produces("application/json")
	public Response updateLimitOfPersons(@PathParam("event_id") final Integer id, @PathParam("limit") final Integer limit){
		try{
			Event event = this.getEventService().getById(id);
			event.setLimitOfPersons(limit);
			this.eventService.update(event);
		}catch (Exception e){
			return responseBadRequest("{Error: Can't update event limit of persons or invalid ID,"
									  + "Status: FAIL}");
		}
		return responseOK( "{Action:"+"Event limit of persons changed"+","
							+"ID:"+id+","
							+"Status"+": "+"OK"+"}");
	}
	
	@PUT
	@Path("/update/amount/{event_id}/{amount}")
	@Produces("application/json")
	public Response updateAmount(@PathParam("event_id") final Integer id, @PathParam("amount") final Integer amount){
		try{
			Event event = this.getEventService().getById(id);
			event.setAmount(amount);
			this.eventService.update(event);
		}catch (Exception e){
			return responseBadRequest("{Error: Can't update event amount or invalid ID,"
									  + "Status: FAIL}");
		}
		return responseOK("{Action:"+"Event amount changed"+","
							+"ID:"+id+","
							+"Status"+": "+"OK"+"}");
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
	
	@GET
	@Path("/setAssisAnEvent/{iduser}/{idevent}")
	@Produces("application/json")
	public Response setAssistAnEvent(@PathParam("idevent") final Integer idevent, @PathParam("iduser") final Integer iduser) {
		
		try {
			Event event = this.eventService.getById(idevent);
			if(! event.hasAttendId(iduser)){
				event.addAttendId(iduser);
				this.eventService.update(event);
				return responseOK("{ \"Action\":\"Person added\","
						+"\"ID\": "+idevent+","
						+"\"Status\":\"NO CHANGE\"}");
			}else{
				return responseOK("{ \"Action\":\"Person allready exist\","
						+"\"ID\": "+idevent+","
						+"\"Status\":\"NO CHANGE\"}");
			}
		} catch (Exception e) {
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");

		}

	}
	
	@GET
	@Path("/removeAssisAnEvent/{iduser}/{idevent}")
	@Produces("application/json")
	public Response removeAssistAnEvent(@PathParam("idevent") final Integer idevent, @PathParam("iduser") final Integer iduser) {
		
		try {
			Event event = this.eventService.getById(idevent);
			if(event.hasAttendId(iduser)){
				event.removeAttendId(iduser);
				this.eventService.update(event);
				return responseOK("{ \"Action\":\"Person removed\","
						+"\"ID\": "+idevent+","
						+"\"Status\":\"OK\"}");
			}else{
				return responseOK("{ \"Action\":\"Person wasn't regitered to that event\","
						+"\"ID\": "+idevent+","
						+"\"Status\":\"NO CHANGE\"}");
			}
		} catch (Exception e) {
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");

		}

	}
	
	@GET
	@Path("/validateAssit/{iduser}/{idevent}")
	@Produces("application/json")
	public Response validateAssisAnEvent(@PathParam("iduser") final Integer id, @PathParam("idevent") final Integer idevent) {
		try {
			Event event = this.eventService.getById(id);
			if(! event.hasAttendId(id)){
				return responseOK("{ \"Action\":\"Person allready registered at event\","
						+"\"ID\": "+idevent+","
						+"\"Value\": "+"true"+","
						+"\"Status\":\"OK\"}"						
						);
			}else{
				return responseOK("{ \"Action\":\"Person isn't registered at event\","
						+"\"ID\": "+idevent+","
						+"\"Value\": "+"true"+","
						+"\"Status\":\"OK\"}");
			}
		} catch (Exception e) {
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");
		}
	}
	
	

}

