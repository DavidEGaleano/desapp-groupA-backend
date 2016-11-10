package persistance.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import builders.EventBuilder;
import model.Event;
import persistance.services.EventService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestEventService {
	
	@Autowired
    private EventService eventService;
    
    @Test
    public void shouldEventGetOneSuggestion() {
    	ArrayList<Event> suggestions = new ArrayList<Event>();
    	suggestions.add(new EventBuilder().build());
    	Event event = new EventBuilder().withSuggestion(suggestions).build();
    	eventService.save(event);
    	Assert.assertEquals(eventService.getById(event.id).suggestions.size(),1);
    }
    
    @Test
    public void shouldBeDeleteAEvent(){
    	Event event = new EventBuilder().build();
    	Event event2 = new EventBuilder().build();
    	eventService.save(event);
    	eventService.save(event2);
    	eventService.delete(event2);
    	Assert.assertEquals(1, eventService.retriveAll().size());
    }
    
    @Test
    public void shouldBeGetAEventByID(){
    	Event event = new EventBuilder().build();
    	Event event2 = new EventBuilder().build();
    	eventService.save(event);
    	eventService.save(event2);
    	Assert.assertEquals(event.id, eventService.getById(event.id).id);
    } 
	
    @After
    public void drop(){
    	eventService.deleteAll();
    }
    
}