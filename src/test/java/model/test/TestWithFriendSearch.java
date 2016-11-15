package model.test;

//import java.util.ArrayList;

//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;

//import builders.EventBuilder;
//import builders.UserBuilder;
//import kind.Kind;
//import model.Event;
//import model.Profile;
//import model.SearchMode;
//import model.User;

public class TestWithFriendSearch {
	/*
	public User aUser;
	public ArrayList<User> friends;
	public ArrayList<Event> events;
	public SearchMode search;
	public Profile profile;
	
	
	@Before
	public void setUp(){
		events= new ArrayList<Event>();
		friends = new ArrayList<User>();
		ArrayList<Kind> kinds;
		ArrayList<Kind> kindsII;
		ArrayList<Kind> kindsIII;
		kinds = new ArrayList<Kind>();
		kinds.add(Kind.ACTION);
		kinds.add(Kind.FAST_FOOD);
		events.add(new EventBuilder().withAmount(1800)
				.withTypes(kinds)
				.build()
				);
		
		kindsII = new ArrayList<Kind>();
		kindsII.add(Kind.ACTION);
		kindsII.add(Kind.ROCK);
		events.add(new EventBuilder().withAmount(1500)
				.withTypes(kindsII)
				.build()
				);
		kindsIII = new ArrayList<Kind>();
		kindsIII.add(Kind.ROCK);
		kindsIII.add(Kind.FAST_FOOD);
		events.add(new EventBuilder().withAmount(1500)
				.withTypes(kindsIII)
				.build()
				);
		
		search = new SearchMode();
	}
	
	@Test
	public void shouldBeReturn3Events(){
		friends.add(new UserBuilder().withProfile(new Profile(Kind.ACTION, Kind.ROCK, Kind.FAST_FOOD, 2500)).build());
		aUser = new UserBuilder()
				.withProfile(new Profile(Kind.ACTION, Kind.ROCK, Kind.FAST_FOOD, 2500))
				.withFriends(friends)
				.build();
		search.withFriendMode(aUser);
		search.setEvents(events);
		Assert.assertEquals(search.doSearch().size(),3);
	}
	
	
	@Test
	public void shouldBeReturn2Events(){
		friends.add(new UserBuilder().withProfile(new Profile(Kind.ACTION, Kind.ROCK, Kind.FAST_FOOD, 1500)).build());
		aUser = new UserBuilder()
				.withProfile(new Profile(Kind.ACTION, Kind.ROCK, Kind.FAST_FOOD, 1500))
				.withFriends(friends)
				.build();
		search.withFriendMode(aUser);
		search.setEvents(events);
		Assert.assertEquals(search.doSearch().size(),2);
	}
	
	@Test
	public void shouldBeReturn1Event(){
		friends.add(new UserBuilder().withProfile(new Profile(Kind.ADVENTURE, Kind.ROCK, Kind.FAST_FOOD, 1500)).build());
		aUser = new UserBuilder()
				.withProfile(new Profile(Kind.ACTION, Kind.ROCK, Kind.FAST_FOOD, 1500))
				.withFriends(friends)
				.build();
		search.withFriendMode(aUser);
		search.setEvents(events);
		Assert.assertEquals(search.doSearch().size(),1);
	}
	
	@Test
	public void shouldBeReturn0Events(){
		friends.add(new UserBuilder().withProfile(new Profile(Kind.ADVENTURE, Kind.ELECTRONIC, Kind.FAST_FOOD, 1500)).build());
		aUser = new UserBuilder()
				.withProfile(new Profile(Kind.ACTION, Kind.ROCK, Kind.FAST_FOOD, 1500))
				.withFriends(friends)
				.build();
		search.withFriendMode(aUser);
		search.setEvents(events);
		Assert.assertEquals(search.doSearch().size(),0);
	}
	
	
	
	@After
	public void tearDown(){
		aUser = null;
		friends = new ArrayList<User>();
		search.setEvents(new ArrayList<Event>());
	}
	*/
}
