package model.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Event;
import model.System;
import builders.EventBuilder;
import builders.SystemBuilder;
import junit.framework.Assert;

public class TestSystem {
	
	private System aSystem;
	private Event aEvent;
	
	@Before
	public void  setUp(){
		aSystem = new SystemBuilder().build();
		aEvent = new EventBuilder().build();
	}
	
	@Test
	public void shouldBeAddAnEvent(){
		aSystem.addEvent(aEvent);
		Assert.assertEquals(aSystem.allEvents.size(), 1);
	}
	
	@Test
	public void shouldBeCreateANewUser(){
		aSystem.registerNewUser("aName", "aPassword", "anEmail@gmail.com");
		Assert.assertEquals(aSystem.users.size(), 1);
	}
	
	@Test
	public void shouldBeObtainAUser(){
		aSystem.registerNewUser("aName", "aPassword", "anEmail@gmail.com");
		Assert.assertEquals(aSystem.obtainUser("aName").getName(), "aName");
	}
	
	
	@After
	public void tearDown(){
		aSystem = null;
		aEvent = null;
	}
}
