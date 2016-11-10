package persistance.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import builders.UserBuilder;
import junit.framework.Assert;
import model.User;
import persistance.services.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestUserService {
	@Autowired
    private UserService userService;
	
    //@Test
    public void shouldBeSaveNEvent() {
    	User anUser = new UserBuilder().build();
    	User anUser2 = new UserBuilder().build();
    	userService.save(anUser);
    	userService.save(anUser2);
    	Assert.assertEquals(2, userService.retriveAll().size());
    }
    
    //@Test
    public void shouldBeDeleteAEvent(){
    	User anUser = new UserBuilder().build();
    	User anUser2 = new UserBuilder().build();
    	userService.save(anUser);
    	userService.save(anUser2);
    	userService.delete(anUser2);
    	Assert.assertEquals(1, userService.retriveAll().size());
    }
    
    //@Test
    public void shouldBeGetAEventByID(){
    	User anUser = new UserBuilder().build();
    	User anUser2 = new UserBuilder().build();
    	userService.save(anUser);
    	userService.save(anUser2);
    	Assert.assertEquals(anUser.id, userService.getById(anUser.id).id);
    } 
	
    //@After
    public void drop(){
    	userService.deleteAll();
    }
    
}
