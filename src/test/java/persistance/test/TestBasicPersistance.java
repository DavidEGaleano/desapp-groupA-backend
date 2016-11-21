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
import builders.ProfileBuilder;
import builders.UserBuilder;
import kind.Kind;
import model.Event;
import model.Profile;
import model.User;
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
    public void testSaveProfile() {
    	Profile profile = new ProfileBuilder().build();
    	profileService.save(profile);
    	Assert.assertEquals(profile.id, profileService.getById(profile.id).id);
    }
    
    @Test
    public void testSaveEvent() {
    	ArrayList<Kind> types = new ArrayList<Kind>();
    	types.add(Kind.ELECTRONIC);
    	types.add(Kind.CLASSIC);
    	types.add(Kind.ACTION);
    	Event event = new EventBuilder().withTypes(types).build();
    	eventService.save(event);
    	Assert.assertEquals(event.id, eventService.getById(event.id).id);
    }
    
    @Test
    public void testSaveUser() {
    	User user = new UserBuilder().build();
    	userService.save(user);
    	Assert.assertEquals(user.id,userService.getById(user.id).id);
    }
	
    @After
    public void drop(){
    	profileService.deleteAll();
    	userService.deleteAll();
    	eventService.deleteAll();
    }
   
}
