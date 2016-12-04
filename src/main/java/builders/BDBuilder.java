package builders;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.DependsOn;

import kind.Kind;
import model.Event;
import model.User;
import persistance.services.EventService;
import persistance.services.UserService;

public class BDBuilder {
	
	EventService eventservice;
	UserService userservive;
	
	public EventService getEventservice() {
		return eventservice;
	}

	public void setEventservice(EventService eventservice) {
		this.eventservice = eventservice;
	}

	public UserService getUserservive() {
		return userservive;
	}

	public void setUserservive(UserService userservive) {
		this.userservive = userservive;
	}

	@PostConstruct
	@DependsOn("org.springframework.context.config.internalBeanConfigurerAspect")
	public void createEntities() throws IOException, ParseException{
		

		ArrayList<Event> events = new EventBuilder().fromJson("./src/main/resources/dataGBA/BailablesData.json");
		
		
		for(Event event:events){
			this.eventservice.save(event);
		}

	}
}
