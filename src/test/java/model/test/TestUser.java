package model.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import builders.UserBuilder;
import model.User;

public class TestUser {
	
	private User aUser;
	private User aFriend;
	
	@Before
	public void setUp(){
		aUser = new UserBuilder().build();
	}
    
	
	@Test
	public void friendShouldBeAdded(){
		aFriend = new UserBuilder().build();
		aUser.addFriend(aFriend);
		Assert.assertEquals(aUser.getFriends().size(),1);
	}
	
	@Test
	public void requestShouldBeAdded(){
		aFriend = new UserBuilder().build();
		aUser.sendFriendRequest(aFriend);
		Assert.assertEquals(aUser.getFriendsRequests().size(), 1);
	}
	
	@Test
	public void shouldBeDeleteAFriend(){
		aFriend = new UserBuilder().build();
		aUser.addFriend(aFriend);
		aUser.deleteFriend(aFriend);
		Assert.assertEquals(aUser.getFriends().size(),0);
	}
	
	@Test
	public void shouldBeAcceptAFriend(){
		aFriend = new UserBuilder().build();
		aUser.sendFriendRequest(aFriend);
		aUser.acceptFriend(aFriend);
		Assert.assertEquals(aUser.getFriends().size(), 1);
	}
	
	@Test
	public void shouldBeCancelAFriend(){
		aFriend = new UserBuilder().build();
		aUser.sendFriendRequest(aFriend);
		aUser.cancelFriend(aFriend);
		Assert.assertTrue(aUser.getFriendsRequests().isEmpty());
		Assert.assertTrue(aUser.getFriends().isEmpty());
	}
	
	
	@After
	public void tearDown(){
		aUser = null;
		aFriend = null;
	}
}
