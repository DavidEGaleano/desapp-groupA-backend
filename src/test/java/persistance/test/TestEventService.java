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
import kind.Kind;
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
    public void shouldEventGetTypes() {
    	ArrayList<Kind> types = new ArrayList<Kind>();
    	types.add(Kind.ACTION);
    	Event event = new EventBuilder().withTypes(types).build();
    	eventService.save(event);
    	Assert.assertEquals(eventService.getById(event.id).types.size(),1);
    }
    
    @Test
    public void shouldBeGetAEventByID(){
    	Event event = new EventBuilder().build();
    	Event event2 = new EventBuilder().build();
    	eventService.save(event);
    	eventService.save(event2);
    	Assert.assertEquals(event.id, eventService.getById(event.id).id);
    } 
    
    @Test
    public void shouldBeGet2EventsBasedOnLimitOfPersons(){
    	Event event = new EventBuilder().withLimitOfPersons(50).build();
    	Event event2 = new EventBuilder().withLimitOfPersons(60).build();
    	eventService.save(event);
    	eventService.save(event2);
    	Assert.assertEquals(2, eventService.obtainEventsWithLimitOfPersons(40).size());
    } 
    
    @Test
    public void shouldBeGet1EventsBasedOnLimitOfPersons(){
    	Event event = new EventBuilder().withLimitOfPersons(50).build();
    	Event event2 = new EventBuilder().withLimitOfPersons(20).build();
    	eventService.save(event);
    	eventService.save(event2);
    	Assert.assertEquals(1, eventService.obtainEventsWithLimitOfPersons(40).size());
    } 
    
    @Test
    public void shouldBeGet0EventsBasedOnLimitOfPersons(){
    	Event event = new EventBuilder().withLimitOfPersons(50).build();
    	Event event2 = new EventBuilder().withLimitOfPersons(20).build();
    	eventService.save(event);
    	eventService.save(event2);
    	Assert.assertEquals(0, eventService.obtainEventsWithLimitOfPersons(100).size());
    } 

    @After
    public void drop(){
    	eventService.deleteAll();
    }
    
    
    
}