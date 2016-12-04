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
import builders.ProfileBuilder;
import builders.UserBuilder;
import model.Event;
import model.Profile;
import model.Searcher;
import model.User;
import persistance.services.EventService;
import persistance.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestEconomicSearch {
	 
	private User aUser;
	private Profile aProfile;
	@Autowired
	private Searcher search;
	@Autowired
	private EventService eventservice;
	@Autowired
	private UserService userservice;
	Event anEvent500;
	Event anEvent1000;
	Event anEvent100;
	Event anEvent250;
	
	@Before
	public void setUP(){
		
		anEvent100 = new EventBuilder().withAmount(100).build();
		anEvent1000 = new EventBuilder().withAmount(1000).build();
		anEvent500 = new EventBuilder().withAmount(500).build();
		anEvent250 = new EventBuilder().withAmount(250).build();

		eventservice.save(anEvent1000);
		eventservice.save(anEvent100);
		eventservice.save(anEvent500);
		eventservice.save(anEvent250);
	}
	
	@Test
	public void shouldBeReturn4Events(){
		aProfile = new ProfileBuilder().withLimitAmount(2000).build();
		aUser = new UserBuilder().withProfile(aProfile).build();
		userservice.save(aUser);
		Assert.assertEquals(search.economicTour(aUser.id).size(), 4);
	}
	
	@Test
	public void shouldBeReturn3Events(){
		aProfile = new ProfileBuilder().withLimitAmount(700).build();
		aUser = new UserBuilder().withProfile(aProfile).build();
		userservice.save(aUser);
		Assert.assertEquals(search.economicTour(aUser.id).size(), 3);
	}
	
	@Test
	public void shouldBeReturn2Events(){
		aProfile = new ProfileBuilder().withLimitAmount(300).build();
		aUser = new UserBuilder().withProfile(aProfile).build();
		userservice.save(aUser);
		Assert.assertEquals(search.economicTour(aUser.id).size(), 2);
	}
	
	@Test
	public void shouldBeReturn1Events(){
		aProfile = new ProfileBuilder().withLimitAmount(200).build();
		aUser = new UserBuilder().withProfile(aProfile).build();
		userservice.save(aUser);
		Assert.assertEquals(search.economicTour(aUser.id).size(), 1);
	}
	
	@Test
	public void shouldBeReturn0Events(){
		aProfile = new ProfileBuilder().withLimitAmount(0).build();
		aUser = new UserBuilder().withProfile(aProfile).build();
		userservice.save(aUser);
		Assert.assertEquals(search.economicTour(aUser.id).size(), 0);
	}
	
	@After
	public void delete(){
		eventservice.deleteAll();
		aUser = null;
		aProfile = null;
	}
	
	
}
