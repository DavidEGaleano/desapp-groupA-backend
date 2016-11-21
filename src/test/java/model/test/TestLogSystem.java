package model.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.LogSystem;

public class TestLogSystem {
	
	private LogSystem aLogSystem;
	private String aUserName = "aUserName";
	private String aPassword = "aPassword";
	private String incorrectPassword = "aLongIncorrectPassword";
	
	@Before
	public void setUp(){
		aLogSystem = new LogSystem();
	}
	
	@Test
	public void shouldBeAddAUser(){
		aLogSystem.newUser(aUserName, aPassword);
		Assert.assertEquals(aLogSystem.getUsers().size(),1);
	}
	
	@Test
	public void shouldBeExistAUser(){
		aLogSystem.newUser(aUserName, aPassword);
		Assert.assertFalse(aLogSystem.notExistUser(aUserName));
	}
	
	@Test
	public void shouldBeNotExistAUser(){
		aLogSystem.newUser(aUserName, aPassword);
		Assert.assertTrue(aLogSystem.notExistUser("aUserName2"));
	}
	
	@Test
	public void shouldBeACorrectPassword(){
		Assert.assertTrue(aLogSystem.correctPaswordSize(aPassword));
	}
	
	@Test
	public void shouldBeAnIncorrectPassword(){
		Assert.assertFalse(aLogSystem.correctPaswordSize("psw"));
		Assert.assertFalse(aLogSystem.correctPaswordSize(incorrectPassword));
	}
	
	@Test
	public void shouldBeAutenticateUser(){
		aLogSystem.newUser(aUserName, aPassword);
		Assert.assertTrue(aLogSystem.autenticateUser(aUserName, aPassword));
	}
	
	@Test
	public void shouldBeNotAutenticateUser(){
		aLogSystem.newUser(aUserName, aPassword);
		Assert.assertFalse(aLogSystem.autenticateUser(aUserName, "wrong"));
		Assert.assertFalse(aLogSystem.autenticateUser("otherName", aPassword));
		Assert.assertFalse(aLogSystem.autenticateUser("otherName", "wrong"));
		Assert.assertFalse(aLogSystem.autenticateUser(aUserName, "wrong"));
	}
	
	@Test
	public void shouldBeChangePassword(){
		aLogSystem.newUser(aUserName, aPassword);
		aLogSystem.changePassword(aUserName, aPassword, "newPassword");
		Assert.assertTrue(aLogSystem.autenticateUser(aUserName, "newPassword"));
	}
	
	@Test
	public void shouldBeNotChangePassword(){
		aLogSystem.newUser(aUserName, aPassword);
		aLogSystem.changePassword(aUserName, aPassword, incorrectPassword);
		Assert.assertFalse(aLogSystem.autenticateUser(aUserName, incorrectPassword));
	}
	
	
	@After
	public void tearDown(){
		aLogSystem = null;
	}
}
