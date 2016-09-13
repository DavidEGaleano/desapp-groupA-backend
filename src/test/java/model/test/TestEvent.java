package model.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kind.*;
import model.Event;

public class TestEvent {
	
	public Event anEvent;
	public Event anEvent2;
	@Before
	public void setUp(){
		//esto se debe cambiar a un Builder/Factory
		anEvent = new Event(new ArrayList<Kind>(),null,DayMoment.AFTERNOON,"direccion",1500,4);
		anEvent2 = new Event(new ArrayList<Kind>(),null,DayMoment.AFTERNOON,"direccion",1500,5);
	}
    
	
	@Test
	public void suggestionsShouldBeAdded(){
		anEvent.newSuggestion(anEvent2);
		Assert.assertEquals(1,anEvent.suggestions.size());
	}
	
	@After
	public void tearDown(){
		
	}
}
