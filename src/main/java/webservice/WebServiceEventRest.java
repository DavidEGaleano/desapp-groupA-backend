package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import builders.EventBuilder;
import model.Event;

@Service("WebServiceEventRest")
@Path("/event")
public class WebServiceEventRest {
	
	@GET
	@Path("/{address}")
	@Produces("application/json")
	public Event getProfile(@PathParam("address") String address){
		Event event = new EventBuilder().withAddress(address).build();
		return event;
	}
	
	@GET
	@Path("/create/{address}")
	@Produces("application/json")
	public String setProfile(@PathParam("address") String address){
		Event event = new EventBuilder().withAddress(address).build();
		return "{event created}";
	}
}

