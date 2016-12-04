package model.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import builders.EventBuilder;
import builders.UserBuilder;
import model.Event;
import model.Searcher;
import model.User;
import persistance.services.EventService;
import persistance.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestWithLimitOfPersonsSearch {
	private User aUser;
	@Autowired
	private Searcher search;
	@Autowired
	private EventService eventservice;
	@Autowired
	private UserService userservice;
	Event anEvent50;
	Event anEvent10;
	Event anEvent100;
	Event anEvent4;
	
	@Before
	public void setUP(){
		
		anEvent100 = new EventBuilder().withLimitOfPersons(100).build();
		anEvent50 = new EventBuilder().withLimitOfPersons(50).build();
		anEvent10 = new EventBuilder().withLimitOfPersons(10).build();
		anEvent4 = new EventBuilder().withLimitOfPersons(4).build();
		aUser = new UserBuilder().build();
		userservice.save(aUser);
		eventservice.save(anEvent50);
		eventservice.save(anEvent100);
		eventservice.save(anEvent4);
		eventservice.save(anEvent10);
	}
	
	@Test
	public void shouldReturn4events(){			
		Assert.assertEquals(search.forLimitOfPersons(aUser.id, 3).size(),4);
	}
	
	@Test
	public void shouldReturn3events(){	
		Assert.assertEquals(search.forLimitOfPersons(aUser.id, 9).size(),3);
	}
	
	@Test
	public void shouldReturn2events(){		
		Assert.assertEquals(search.forLimitOfPersons(aUser.id, 12).size(),2);
	}
	
	@Test
	public void shouldReturn1event(){		
		Assert.assertEquals(search.forLimitOfPersons(aUser.id, 55).size(),1);
	}
	
	@Test
	public void shouldReturn0event(){	
		Assert.assertEquals(search.forLimitOfPersons(aUser.id, 120).size(),0);
	}
	
	@After
	public void drop(){
		userservice.delete(aUser);
		eventservice.delete(anEvent50);
		eventservice.delete(anEvent100);
		eventservice.delete(anEvent4);
		eventservice.delete(anEvent10);
	}
}
