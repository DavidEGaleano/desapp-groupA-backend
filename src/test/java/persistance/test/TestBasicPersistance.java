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
import builders.UserBuilder;
import kind.Kind;
import model.Event;
import model.Profile;
import persistance.services.EventService;
import persistance.services.ProfileService;
import persistance.services.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestBasicPersistance {
	
	@Autowired
    private ProfileService profileService;
	@Autowired
    private EventService eventService;
	@Autowired
	private UserService userService;
	
    @Test
    public void testSaveService() {
    	profileService.save(new Profile(Kind.ACTION, Kind.ELECTRONIC, Kind.FAST_FOOD, 1000));
    	Assert.assertEquals(1, profileService.retriveAll().size());
    }
    
    @Test
    public void testSaveEvent() {
    	ArrayList<Kind> types = new ArrayList<Kind>();
    	//types.add(Kind.ELECTRONIC);
    	//types.add(Kind.FAST_FOOD);
    	//types.add(Kind.ACTION);
    	Event event = new EventBuilder().withTypes(types).build();
    	eventService.save(event);
    	Assert.assertEquals(1, eventService.retriveAll().size());
    }
    
    @Test
    public void testSaveUser() {
    	userService.save(new UserBuilder().build());
    	Assert.assertEquals(1,userService.retriveAll().size());
    }
	
    @After
    public void drop(){
    	profileService.deleteAll();
    	userService.deleteAll();
    	eventService.deleteAll();
    }
   
}
