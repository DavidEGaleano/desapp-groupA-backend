package persistance.test;

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
    public void testSave() {
    	profileService.save(new Profile(Kind.ACTION, Kind.ELECTRONIC, Kind.FAST_FOOD, 1000));
    	eventService.save(new EventBuilder().build());
    	userService.save(new UserBuilder().build());
        Assert.assertEquals(1, profileService.retriveAll().size());
        Assert.assertEquals(1, eventService.retriveAll().size());
        Assert.assertEquals(1,userService.retriveAll().size());
    }
}
