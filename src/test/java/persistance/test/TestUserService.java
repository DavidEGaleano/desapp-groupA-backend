package persistance.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import builders.UserBuilder;

import model.User;
import persistance.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestUserService {
	
	@Autowired
    private UserService userService;
    
    @Test
    public void shouldBeGetAUserByID(){
    	User anUser = new UserBuilder().build();
    	User anUser2 = new UserBuilder().build();
    	userService.save(anUser);
    	userService.save(anUser2);
    	Assert.assertEquals(anUser.id, userService.getById(anUser.id).id);
    } 
    
    @Test
    public void shouldBeGetAUserByEmail(){
    	User anUser = new UserBuilder().withMail("test@gmail.com").build();
    	User anUser2 = new UserBuilder().withMail("test2@gmail.com").build();
    	userService.save(anUser);
    	userService.save(anUser2);
    	List<User> list = userService.getUserWithEmail("test@gmail.com");
    	Assert.assertEquals(1, list.size());
    	Assert.assertEquals(anUser.mail, list.get(0).mail);
    }
    
    @Test
    public void shouldBeNotGetAUserByEmailNotRegistered(){
    	User anUser = new UserBuilder().withMail("test@gmail.com").build();
    	User anUser2 = new UserBuilder().withMail("test2@gmail.com").build();
    	userService.save(anUser);
    	userService.save(anUser2);
    	Assert.assertEquals(0, userService.getUserWithEmail("notmail@gmail.com").size());
    }
    
    
    @After
    public void drop(){
    	userService.deleteAll();
    }
    
}

