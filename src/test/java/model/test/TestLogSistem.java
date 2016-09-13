package model.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import model.LogSistem;

public class TestLogSistem {
	
	public LogSistem alogsistem;
	
	@Before
	public void setUp(){
		alogsistem = new LogSistem();
		alogsistem.users.put("userTest", "testPass");
	}
	
	@Test
	public void shouldBeValidate(){
		
	}
	
	
	@After
	public void tearDown(){
		
	}
}
