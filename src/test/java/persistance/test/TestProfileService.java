package persistance.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import builders.ProfileBuilder;
import model.Profile;
import persistance.services.ProfileService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestProfileService {
	@Autowired
    private ProfileService profileService;
    
    @Test
    public void shouldBeGetAEventByID(){
    	Profile profile = new ProfileBuilder().build();
    	Profile profile2 = new ProfileBuilder().build();
    	profileService.save(profile);
    	profileService.save(profile2);
    	Assert.assertEquals(profile.id, profileService.getById(profile.id).id);
    } 
	
    @After
    public void drop(){
    	profileService.deleteAll();
    }
    
}
