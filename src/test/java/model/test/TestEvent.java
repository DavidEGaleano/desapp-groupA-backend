package model.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import builders.EventBuilder;
import model.Event;

public class TestEvent {
	
	public Event anEvent;
	public Event anEvent2;
	
	@Before
	public void setUp(){
		anEvent = new EventBuilder().build();
		anEvent2 = new EventBuilder().build();
	}
    
	
	@Test
	public void suggestionsShouldBeAdded(){
		anEvent.newSuggestion(anEvent2);
		Assert.assertEquals(1,anEvent.suggestions.size());
	}
	
	@After
	public void tearDown(){
		anEvent = null;
		anEvent2 = null;
	}
}
